package com.jumia.controller;

import com.jumia.entity.Customer;
import com.jumia.service.CustomerServiceImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MainController {

  @Autowired
  CustomerServiceImpl customerService;

  @GetMapping(value = "readAll")
  public Iterable<Customer> readAll() {
    return customerService.readAll();
  }

  @GetMapping(value = "read/{id}")
  public Optional<Customer> read(@PathVariable("id") Long id) {
    return customerService.read(id);
  }
}
