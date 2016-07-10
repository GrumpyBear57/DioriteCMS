package org.diorite.web.cms.pages;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Page
{
    private final String name;
    private final String argument;
    private final String url;

    public Page(final String name, final String argument, final String url)
    {
        this.name = name;
        this.argument = argument;
        this.url = url;
    }

    public Page(final String name, final String url)
    {
        this(name, null, url);
    }

    public String getName()
    {
        return this.name;
    }

    public String getArgument()
    {
        return this.argument;
    }

    public String getUrl()
    {
        return this.url;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("name", this.name).append("url", this.url).toString();
    }
}
