package com.super13.accountservice.repository;

import com.super13.accountservice.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    Account findByName(String name);

}
