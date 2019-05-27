package com.jumia.service;

import com.jumia.entity.Customer;
import com.jumia.repository.CustomerRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Override
  public Optional<Customer> read(Long id) {
    return customerRepository.findById(id);
  }

  @Override
  public Iterable<Customer> readAll() {
    return customerRepository.findAll();
  }

}
