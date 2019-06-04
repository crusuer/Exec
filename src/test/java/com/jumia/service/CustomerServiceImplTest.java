package com.jumia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;
import com.jumia.repository.CustomerRepository;
import com.jumia.service.fixture.CustomerFixture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

  @InjectMocks
  CustomerServiceImpl customerService;
  @Mock
  CustomerRepository customerRepository;

  @Test
  public void shouldReturnTheCustomerDTOList() {
    List<Customer> customers = new ArrayList<>();
    final Customer customer1 = CustomerFixture.get().complete().setPhone("(258) 849999999").build();
    final Customer customer2 = CustomerFixture.get().complete().setId(2L).setPhone("(256) 799999999").build();
    final Customer customer3 = CustomerFixture.get().complete().setId(3L).setPhone("(251) 9999999999").build();

    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);

    when(customerRepository.findAll())
        .thenReturn(customers);

    Iterable<CustomerDTO> result = customerService.getCustomers();
    assertEquals(3, ((Collection<?>) result).size());
    Iterator<CustomerDTO> iterator = result.iterator();
    assertEquals(1L, iterator.next().getId());
    assertEquals(2L, iterator.next().getId());
    assertEquals(3L, iterator.next().getId());
  }

  @TestConfiguration
  static class CustomerServiceImplTestContextConfiguration {

    @Bean
    public CustomerService customerService() {
      return new CustomerServiceImpl();
    }
  }
}