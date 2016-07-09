package org.diorite.web.cms.pages;

import java.util.Set;

public interface IPagesProvider
{
    Set<Page> getPages();

    Page getPage(String arg);

    default String getName()
    {
        return this.getClass().getName();
    }
}
