package com.springjpa.demo.generator;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomUUIDGenerator implements IdentifierGenerator {

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object) {
    // Generate a UUID and prepend "1-"
    return "1-" + UUID.randomUUID().toString();
  }
}
