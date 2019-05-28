package com.jumia.dto;

public class CountryProperties {

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
}
