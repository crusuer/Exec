package com.jumia.service;

import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;
import com.jumia.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Override
  public Iterable<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public List<CustomerDTO> getCustomers() {
    List<CustomerDTO> customersDTO = new ArrayList<>();
    findAll().forEach(customer -> customersDTO.add(new CustomerDTO(customer)));
    return customersDTO;
  }

}
