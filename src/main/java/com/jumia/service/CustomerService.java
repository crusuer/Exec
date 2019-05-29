package com.jumia.service;

import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;

public interface CustomerService {

  Iterable<Customer> findAll();

  Iterable<CustomerDTO> getCustomers();
}
