package com.jumia.service.fixture;

import com.jumia.entity.Customer;

public class CustomerFixture {

  private Customer customer;

  public CustomerFixture() {
    super();
    customer = new Customer();
  }

  public static CustomerFixture get() {
    return new CustomerFixture();
  }

  public Customer build() {
    return this.customer;
  }

  public CustomerFixture setId(Long id) {
    customer.setId(id);
    return this;
  }

  public CustomerFixture setName(String name) {
    customer.setName(name);
    return this;
  }

  public CustomerFixture setPhone(String phone) {
    customer.setPhone(phone);
    return this;
  }

  public CustomerFixture complete() {
    setId(1L);
    setName("XPTO");
    setPhone("(999) 999999999");
    return this;
  }
}
