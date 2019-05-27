package com.jumia.service;

import com.jumia.entity.Customer;
import java.util.Optional;

public interface CustomerService {

  Optional<Customer> read(Long id);

  Iterable<Customer> readAll();

}
