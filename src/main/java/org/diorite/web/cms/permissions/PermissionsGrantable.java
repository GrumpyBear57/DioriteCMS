package org.diorite.web.cms.permissions;

import org.diorite.web.cms.models.Permission;

public interface PermissionsGrantable
{
    void grantPermission(Permission permission);

    default void grantPermission(final String permission)
    {
        this.grantPermission(new Permission(permission));
    }

    default void grantPermissions(final Permission... permissions)
    {
        for (final Permission permission : permissions)
        {
            this.grantPermission(permission);
        }
    }

    default void grantPermissions(final String... permissions)
    {
        for (final String permission : permissions)
        {
            this.grantPermission(permission);
        }
    }

    void removePermission(Permission permission);

    default void removePermission(final String permission)
    {
        this.removePermission(new Permission(permission));
    }
}
