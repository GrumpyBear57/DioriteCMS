package org.diorite.web.cms.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.diorite.web.cms.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>
{
    @Cacheable("groups")
    Group findById(Integer id);
}
