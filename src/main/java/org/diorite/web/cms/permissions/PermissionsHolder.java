package org.diorite.web.cms.permissions;

import java.util.Set;

import org.diorite.web.cms.models.Permission;

public interface PermissionsHolder
{
    Set<Permission> getPermissions();

    boolean hasPermission(Permission permission);

    default boolean hasPermission(final String permission)
    {
        return this.hasPermission(new Permission(permission));
    }

    default boolean hasPermissions(String... permissions)
    {
        for (final String permission : permissions)
        {
            if (! this.hasPermission(permission))
            {
                return false;
            }
        }
        return true;
    }

    default boolean hasPermissions(Permission... permissions)
    {
        for (final Permission permission : permissions)
        {
            if (! this.hasPermission(permission))
            {
                return false;
            }
        }
        return true;
    }
}
