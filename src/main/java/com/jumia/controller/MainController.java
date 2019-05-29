package com.jumia.controller;

import com.jumia.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class MainController {

  @Autowired
  CustomerServiceImpl customerService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("customers", customerService.getCustomers());
    return "index";
  }
}
