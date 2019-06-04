package com.jumia.dto;

import com.jumia.entity.Customer;
import com.jumia.util.CountryUtilities;
import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO extends Customer implements Serializable {

  private String country;
  private boolean valid;

  public CustomerDTO(Customer customer) {
    super.setId(customer.getId());
    super.setName(customer.getName());
    super.setPhone(customer.getPhone());
    this.country = CountryUtilities.getPhoneCountry(getPhone());
    this.valid = CountryUtilities.validatePhone(getPhone(), getCountry());
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
    return isValid() == that.isValid() &&
        Objects.equals(getId(), that.getId()) &&
        Objects.equals(getName(), that.getName()) &&
        Objects.equals(getPhone(), that.getPhone()) &&
        Objects.equals(getCountry(), that.getCountry());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getPhone(), getCountry(), isValid());
  }
}
