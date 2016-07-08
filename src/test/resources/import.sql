-- Permissions
INSERT INTO permissions VALUES ('perm1', 'test perm 1');
INSERT INTO permissions VALUES ('perm2', 'test perm 2');
INSERT INTO permissions VALUES ('perm3', 'test perm 3');

-- Groups
INSERT INTO groups VALUES (1, 'test group 1', true);
INSERT INTO groups VALUES (2, 'test group 2', true);
INSERT INTO groups VALUES (3, 'test group 3', true);
INSERT INTO groups VALUES (4, 'test group 4', true);

-- test group 1 has all permissions
INSERT INTO groups_permissions VALUES (1, 'perm1');
INSERT INTO groups_permissions VALUES (1, 'perm2');
INSERT INTO groups_permissions VALUES (1, 'perm3');

-- test group 2 permissions
INSERT INTO groups_permissions VALUES (2, 'perm1');
INSERT INTO groups_permissions VALUES (2, 'perm3');

-- test group 3 permissions
INSERT INTO groups_permissions VALUES (3, 'perm2');

-- test group 4 has no permissions