package org.diorite.web.cms.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.diorite.web.cms.pages.providers.StaticPagesProvider;
import org.diorite.web.cms.services.PagesService;

@Component
public final class DefaultProvidersRegister
{
    @Autowired
    private StaticPagesProvider staticPagesProvider;

    public void register(final PagesService pagesService)
    {
        pagesService.registerProvider(this.staticPagesProvider);
    }
}
