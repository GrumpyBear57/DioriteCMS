package org.diorite.web.cms.services;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.diorite.web.cms.core.DioriteCms;
import org.diorite.web.cms.models.Permission;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DioriteCms.class)
public class PermissionsServiceTest
{
    @Autowired
    private PermissionsService permissionsService;

    @Test
    public void generalTest()
    {
        assertEquals(1, this.permissionsService.getAllPermissions().size());
        assertEquals("access.acp", this.permissionsService.getAllPermissions().iterator().next().getName());
    }

    @Test
    public void resolvingTest()
    {
        final Permission permission = new Permission("access.acp");
        assertEquals("access.acp", permission.getName());
        assertEquals(null, permission.getDisplayName());

        final Permission permission1 = this.permissionsService.get(permission);
        assertEquals("access.acp", permission1.getName());
        assertEquals("test", permission1.getDisplayName());

        final Permission permission2 = this.permissionsService.get("access.acp");
        assertEquals("access.acp", permission2.getName());
        assertEquals("test", permission2.getDisplayName());
    }
}
