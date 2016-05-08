package com.jinpalhawang.jambudvipa.accountmiddle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends MongoRepository<Account, String> {

  public Account findByFirstName(@Param("firstName") String firstName);

  public Account findByLastName(@Param("lastName") String lastName);

}
