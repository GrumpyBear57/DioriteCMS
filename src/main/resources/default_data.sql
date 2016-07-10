-- Permissions
INSERT INTO permissions (name, display_name) VALUES ("access.acp", "Can access Administration Control Panel");

-- Groups
INSERT INTO groups (fancy_name, is_special) VALUES ("User", true);
INSERT INTO groups (fancy_name, is_special) VALUES ("Admin", true);

-- Administrator permissions
INSERT INTO groups_permissions (groups_id, permissions_name) VALUES (2, "access.acp");

-- Default administrator account
INSERT INTO accounts (user_name, email, password, 'group') VALUES ("admin", "admin@diorite", "admin", 2);