package com.jumia.dto;

import java.io.Serializable;
import java.util.Objects;

public class CountryProperties implements Serializable {

  private String countryCode;
  private String countryRegex;

  public CountryProperties(String countryCode, String countryRegex) {
    this.countryCode = countryCode;
    this.countryRegex = countryRegex;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getCountryRegex() {
    return countryRegex;
  }

  public void setCountryRegex(String countryRegex) {
    this.countryRegex = countryRegex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountryProperties that = (CountryProperties) o;
    return Objects.equals(countryCode, that.countryCode) &&
        Objects.equals(countryRegex, that.countryRegex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode, countryRegex);
  }
}
