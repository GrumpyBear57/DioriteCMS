package org.diorite.web.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.diorite.web.cms.models.StaticPage;

@Repository
public interface StaticPageRepository extends JpaRepository<StaticPage, Integer>
{
}
