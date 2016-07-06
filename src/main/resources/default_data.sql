-- Permissions
INSERT INTO permissions (name, display_name) VALUES ("access.acp", "Can access Administration Control Panel");

-- Groups
INSERT INTO groups (fancy_name, is_special) VALUES ("Administrator", true);

-- Administrator permissions
INSERT INTO groups_permissions (groups_id, permissions_name) VALUES (1, "access.acp");