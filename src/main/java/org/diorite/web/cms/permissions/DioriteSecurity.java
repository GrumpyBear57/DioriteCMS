package org.diorite.web.cms.permissions;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DioriteSecurity extends WebSecurityConfigurerAdapter
{
    @Autowired
    private DioriteAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {

        http.formLogin().loginPage("/auth/login").failureUrl("/auth/login?failed=true").defaultSuccessUrl("/").permitAll();
        http.exceptionHandling().accessDeniedPage("/auth/access_denied");

    }

    @Override
    public void configure(final WebSecurity web) throws Exception
    {
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception
    {
        auth.authenticationProvider(this.authenticationProvider);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("authenticationProvider", this.authenticationProvider).toString();
    }
}
