package org.diorite.web.cms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity(name = "groups")
public class Group
{
    @Id
    @GeneratedValue
    private int              id;
    private String           fancyName;
    @ManyToMany
    private List<Permission> permissions;

    public Group()
    {
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

    public List<Permission> getPermissions()
    {
        return this.permissions;
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
