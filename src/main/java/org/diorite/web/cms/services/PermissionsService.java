package org.diorite.web.cms.services;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.diorite.web.cms.core.DioriteCms;
import org.diorite.web.cms.dao.PermissionRepository;
import org.diorite.web.cms.models.Permission;

@Service
public class PermissionsService
{
    private final PermissionRepository permissionRepository;
    private final Set<Permission> allPermissions = new HashSet<>();

    @Autowired
    public PermissionsService(final PermissionRepository permissionRepository)
    {
        this.permissionRepository = permissionRepository;
        this.allPermissions.addAll(this.permissionRepository.findAll());
        DioriteCms.getInstance().getLogger().info("Loaded " + this.allPermissions.size() + " permissions!");
    }

    public Set<Permission> getAllPermissions()
    {
        return Sets.newCopyOnWriteArraySet(this.allPermissions);
    }

    public Permission get(final Permission permission)
    {
        for (final Permission validPermission : this.allPermissions)
        {
            if (permission.equals(validPermission))
            {
                return validPermission;
            }
        }
        return null;
    }

    public Permission get(final String permission)
    {
        return this.get(new Permission(permission));
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("permissionRepository", this.permissionRepository).append("allPermissions", this.allPermissions).toString();
    }
}
