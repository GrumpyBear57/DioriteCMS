package org.diorite.web.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController
{
    @RequestMapping("/")
    public String home()
    {
        return "error";
    }
}
