package org.diorite.web.cms.pages.providers;

import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.diorite.web.cms.dao.StaticPageRepository;
import org.diorite.web.cms.models.StaticPage;
import org.diorite.web.cms.pages.IPagesProvider;
import org.diorite.web.cms.pages.Page;

@Component
public class StaticPagesProvider implements IPagesProvider
{
    @Autowired
    private StaticPageRepository staticPageRepository;

    @Override
    public Set<Page> getPages()
    {
        return this.staticPageRepository.findAll().stream().map(this::pageFrom).collect(Collectors.toSet());
    }

    @Override
    public Page getPage(final String arg)
    {
        return this.pageFrom(this.staticPageRepository.findOne(Integer.parseInt(arg)));
    }

    private Page pageFrom(final StaticPage staticPage)
    {
        return new Page(this.nameFrom(staticPage), String.valueOf(staticPage.getId()), this.urlFrom(staticPage));
    }

    private String nameFrom(final StaticPage staticPage)
    {
        return "Static Page - " + staticPage.getName();
    }

    private String urlFrom(final StaticPage staticPage)
    {
        return "/page/" + staticPage.getId();
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("staticPageRepository", this.staticPageRepository).toString();
    }
}
