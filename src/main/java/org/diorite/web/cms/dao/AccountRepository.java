package org.diorite.web.cms.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.diorite.web.cms.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>
{
    @Cacheable("accounts")
    Account findByUserName(String userName);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM accounts a WHERE LOWER(a.userName) = LOWER(:userName)")
    boolean existsByUserName(@Param("userName") String userName);
}
