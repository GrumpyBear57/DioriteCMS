package org.diorite.web.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/**
 * This controller handles all requests to static pages
 */
public class PageController
{
    @RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
    public String page(final @PathVariable Integer id, final Model model)
    {
        model.addAttribute("static_page_content", "dupa " + id);
        return "static_page";
    }
}
