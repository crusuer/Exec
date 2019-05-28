package com.jumia.service;

import com.jumia.dto.CountryProperties;
import com.jumia.dto.CustomerDTO;
import com.jumia.entity.Customer;
import com.jumia.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  private Map<String, CountryProperties> countries = new HashMap<>();

  public CustomerServiceImpl() {
    CountryProperties cameroonProperties = new CountryProperties("(237)",
        "\\(237\\)\\ ?[2368]\\d{7,8}$");
    countries.put("Cameroon", cameroonProperties);

    CountryProperties ethiopiaProperties = new CountryProperties("(251)",
        "\\(251\\)\\ ?[1-59]\\d{8}$");
    countries.put("Ethiopia", ethiopiaProperties);

    CountryProperties moroccoProperties = new CountryProperties("(212)",
        "\\(212\\)\\ ?[5-9]\\d{8}$");
    countries.put("Morocco", moroccoProperties);

    CountryProperties mozambiqueProperties = new CountryProperties("(258)",
        "\\(258\\)\\ ?[28]\\d{7,8}$");
    countries.put("Mozambique", mozambiqueProperties);

    CountryProperties ugandaProperties = new CountryProperties("(256)",
        "\\(256\\)\\ ?\\d{9}$");
    countries.put("Uganda", ugandaProperties);
  }

  @Override
  public Optional<Customer> read(Long id) {
    return customerRepository.findById(id);
  }

  @Override
  public Iterable<Customer> readAll() {
    return customerRepository.findAll();
  }

  public List<CustomerDTO> work() {
    Iterable<Customer> customers = customerRepository.findAll();
    List<CustomerDTO> customersDTO = new ArrayList<>();
    for (Customer customer : customers) {
      CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(),
          customer.getPhone());
      for (Map.Entry<String, CountryProperties> entry : countries.entrySet()) {
        if (customerDTO.getPhone().startsWith(entry.getValue().getCountryCode())) {
          customerDTO.setCountry(entry.getKey());
          customerDTO.setValid(customerDTO.getPhone().matches(entry.getValue().getCountryRegex()));
          customersDTO.add(customerDTO);
        }
      }
    }
    return customersDTO;
  }

}
