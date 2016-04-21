package com.jinpalhawang.jambudvipa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface ApplicationRepository extends MongoRepository<Application, String> {

  public Application findByName(@Param("name") String name);

}
