package com.jumia.service;

import com.jumia.dto.CustomerDTO;

public interface CustomerService {

  Iterable<CustomerDTO> getCustomers();
}
