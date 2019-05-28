package com.jumia.dto;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Serializable {

  private Long id;
  private String name;
  private String phone;
  private String country;
  private boolean valid;

  public CustomerDTO(Long id, String name, String phone) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.valid = false;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTO that = (CustomerDTO) o;
    return valid == that.valid &&
        Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(phone, that.phone) &&
        Objects.equals(country, that.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, country, valid);
  }

  @Override
  public String toString() {
    return "CustomerDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", country='" + country + '\'' +
        ", valid=" + valid +
        '}';
  }
}
