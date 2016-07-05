package org.diorite.web.cms.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("isAuthenticated() and principal.hasPermission('access.acp')")
public class AdminController
{
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
}
