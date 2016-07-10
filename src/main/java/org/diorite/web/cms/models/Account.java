package org.diorite.web.cms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.web.cms.permissions.PermissionsHolder;

@Entity(name = "accounts")
public class Account implements PermissionsHolder
{
    @Id
    @GeneratedValue
    private int    id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(unique = true)
    private String displayName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToOne
    private Group  group;

    public Account()
    {
    }

    public Account(final String userName, final String displayName, final String email, final String password, final Group group)
    {
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
        this.group = group;
    }

    public int getId()
    {
        return this.id;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(final String userName)
    {
        this.userName = userName;
    }

    public String getDisplayName()
    {
        return this.displayName;
    }

    public void setDisplayName(final String displayName)
    {
        this.displayName = displayName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public Group getGroup()
    {
        return this.group;
    }

    public void setGroup(final Group group)
    {
        this.group = group;
    }

    @Override
    public Set<Permission> getPermissions()
    {
        return this.group.getPermissions();
    }

    @Override
    public boolean hasPermission(final Permission permission)
    {
        return this.group.hasPermission(permission);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("id", this.id).append("userName", this.userName).append("displayName", this.displayName).append("password", this.password).append("group", this.group).toString();
    }
}
