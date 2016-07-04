package org.diorite.web.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.diorite.web.cms.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>
{
    Group findById(Integer id);
}
