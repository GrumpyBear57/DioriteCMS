package org.diorite.web.cms.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.diorite.web.cms.dao.AccountRepository;
import org.diorite.web.cms.dao.GroupRepository;
import org.diorite.web.cms.models.Account;

@Controller
@RequestMapping(value = "/auth")
public class AuthController
{
    @Autowired
    private GroupRepository   groupRepository;
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(final Model model, final Principal principal, final @RequestParam(required = false, defaultValue = "false") Boolean failed)
    {
        if (principal != null)
        {
            return "redirect:/";
        }
        model.addAttribute("failed", failed);
        return "form_login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(final Model model, final Principal principal)
    {
        if (principal != null)
        {
            return "redirect:/";
        }
        return "form_register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(final Model model, final Principal principal, final @RequestParam String user, final @RequestParam String email, final @RequestParam String password)
    {
        if (principal != null)
        {
            return "redirect:/";
        }
        final Account account = new Account(user, null, password, this.groupRepository.findById(0));
        this.accountRepository.saveAndFlush(account);

        return "redirect:/";
    }
}
