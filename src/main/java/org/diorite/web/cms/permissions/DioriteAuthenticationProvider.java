package org.diorite.web.cms.permissions;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.diorite.web.cms.core.DioriteCms;
import org.diorite.web.cms.dao.AccountRepository;
import org.diorite.web.cms.models.Account;

public class DioriteAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException
    {
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        final Account account = this.accountRepository.findByUserName(username);
        if (account == null)
        {
            throw new UsernameNotFoundException(username);
        }

        if (account.getPassword().equals(password))
        {
            authentication.setAuthenticated(true);
            return new UsernamePasswordAuthenticationToken(account, password, Arrays.asList(new SimpleGrantedAuthority(account.getGroup().getFancyName())));
        }
        else
        {
            throw new BadCredentialsException("Bad password");
        }
    }

    @Override
    public boolean supports(final Class<?> aClass)
    {
        if (UsernamePasswordAuthenticationToken.class.equals(aClass))
        {
            return true;
        }
        DioriteCms.getInstance().getLogger().warning("Unsupported authentication method: " + aClass);
        return false;
    }
}
