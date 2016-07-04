package org.diorite.web.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.diorite.web.cms.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>
{
    Account findById(Integer id);

    Account findByUserName(String userName);
}
