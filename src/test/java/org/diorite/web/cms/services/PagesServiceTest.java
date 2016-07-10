package org.diorite.web.cms.services;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.diorite.web.cms.core.DioriteCms;
import org.diorite.web.cms.pages.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DioriteCms.class)
public class PagesServiceTest
{
    @Autowired
    private PagesService pagesService;

    @Test
    public void countTest()
    {
        assertEquals(3, this.pagesService.getAllPages().size());
    }

    @Test
    public void resolvingTest()
    {
        final Page page1 = this.pagesService.getPage("org.diorite.web.cms.pages.providers.StaticPagesProvider", "1");

        assertEquals("Static Page - test page 1", page1.getName());
        assertEquals("/page/1", page1.getUrl());
        assertEquals("1", page1.getArgument());
    }
}
