package org.diorite.web.cms.controllers;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.diorite.web.cms.dao.StaticPageRepository;

@Controller
@RequestMapping("/admin")
@PreAuthorize("isAuthenticated() and principal.hasPermission('access.acp')")
public class AdminController
{
    @Autowired
    private StaticPageRepository staticPageRepository;

    @RequestMapping(path = {"", "/"})
    public String root()
    {
        return "redirect:/admin/home";
    }

    @RequestMapping("/home")
    public String home()
    {
        return "admin/home";
    }

    @RequestMapping("/pages")
    public String staticPages(final Model model)
    {
        model.addAttribute("pages", this.staticPageRepository.findAll());
        return "admin/static_pages_list";
    }

    @RequestMapping(value = "/pages/{id}", method = RequestMethod.GET)
    public String editStaticPage(final @PathVariable Integer id)
    {
        return "admin/static_pages_edit";
    }

    @RequestMapping(value = "/pages/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStaticPage(final @PathVariable Integer id)
    {
        this.staticPageRepository.delete(id);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).toString();
    }
}
