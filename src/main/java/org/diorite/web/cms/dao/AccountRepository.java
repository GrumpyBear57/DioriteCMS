package org.diorite.web.cms.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.diorite.web.cms.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>
{
    @Cacheable("accounts")
    Account findById(Integer id);

    @Cacheable("accounts")
    Account findByUserName(String userName);
}
