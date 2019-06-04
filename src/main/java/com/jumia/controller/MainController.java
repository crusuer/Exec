package com.jumia.controller;

import com.jumia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class MainController {

  @Autowired
  CustomerService customerService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("customers", customerService.getCustomers());
    return "index";
  }
}
