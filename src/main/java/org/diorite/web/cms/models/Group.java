package org.diorite.web.cms.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.Set;

import com.google.common.collect.Sets;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

import org.diorite.web.cms.permissions.PermissionsHolder;

@Entity(name = "groups")
public class Group implements GrantedAuthority, PermissionsHolder
{
    @Id
    @GeneratedValue
    private int             id;
    private String          fancyName;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Permission> permissions;

    public Group()
    {
    }

    @Override
    public String getAuthority()
    {
        return String.valueOf(this.id);
    }

    public String getFancyName()
    {
        return this.fancyName;
    }

    public void setFancyName(final String fancyName)
    {
        this.fancyName = fancyName;
    }

    public int getId()
    {
        return this.id;
    }

    @Override
    public Set<Permission> getPermissions()
    {
        return Sets.newCopyOnWriteArraySet(this.permissions);
    }

    @Override
    public boolean hasPermission(final Permission permission)
    {
        return this.permissions.contains(permission);
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || this.getClass() != o.getClass())
        {
            return false;
        }

        final Group group = (Group) o;

        return this.id == group.id && (this.fancyName != null ? this.fancyName.equals(group.fancyName) : group.fancyName == null && this.permissions.equals(group.permissions));

    }

    @Override
    public int hashCode()
    {
        int result = this.id;
        result = 31 * result + (this.fancyName != null ? this.fancyName.hashCode() : 0);
        result = 31 * result + this.permissions.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("id", this.id).append("fancyName", this.fancyName).append("permissions", this.permissions).toString();
    }
}
