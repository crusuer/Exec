package com.jumia.util;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CountryUtilitiesTest {

  @Test
  public void getCameroonCountryByPhoneCode() {
    String phone = "(237) XXXXXXXXXX";
    String country = CountryUtilities.getPhoneCountry(phone);
    assertEquals("Cameroon", country);
  }

  @Test
  public void getEthiopiaCountryByPhoneCode() {
    String phone = "(251) XXXXXXXXXX";
    String country = CountryUtilities.getPhoneCountry(phone);
    assertEquals("Ethiopia", country);
  }

  @Test
  public void getMoroccoCountryByPhoneCode() {
    String phone = "(212) XXXXXXXXXX";
    String country = CountryUtilities.getPhoneCountry(phone);
    assertEquals("Morocco", country);
  }

  @Test
  public void getMozambiqueCountryByPhoneCode() {
    String phone = "(258) XXXXXXXXXX";
    String country = CountryUtilities.getPhoneCountry(phone);
    assertEquals("Mozambique", country);
  }

  @Test
  public void getUgandaCountryByPhoneCode() {
    String phone = "(256) XXXXXXXXXX";
    String country = CountryUtilities.getPhoneCountry(phone);
    assertEquals("Uganda", country);
  }

  @Test
  public void getInvalidCountryByPhoneCode() {
    String phone = "(999) XXXXXXXXXX";
    String country = CountryUtilities.getPhoneCountry(phone);
    assertEquals("", country);
  }

  @Test
  public void validateCorrectCameroonPhone() {
    String country = "Cameroon";
    String phone = "(237) 699999999";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertTrue(valid);
  }

  @Test
  public void validateIncorrectCameroonPhone() {
    String country = "Cameroon";
    String phone = "(237) 799999999";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertFalse(valid);
  }

  @Test
  public void validateCorrectEthiopiaPhone() {
    String country = "Ethiopia";
    String phone = "(251) 988888888";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertTrue(valid);
  }

  @Test
  public void validateIncorrectEthiopiaPhone() {
    String country = "Ethiopia";
    String phone = "(251) 688888888";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertFalse(valid);
  }

  @Test
  public void validateCorrectMoroccoPhone() {
    String country = "Morocco";
    String phone = "(212) 699999999";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertTrue(valid);
  }

  @Test
  public void validateIncorrectMoroccoPhone() {
    String country = "Morocco";
    String phone = "(212) 6999999999";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertFalse(valid);
  }

  @Test
  public void validateCorrectMozambiquePhone() {
    String country = "Mozambique";
    String phone = "(258) 847999999";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertTrue(valid);
  }

  @Test
  public void validateIncorrectMozambiquePhone() {
    String country = "Mozambique";
    String phone = "(258) 8479999999";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertFalse(valid);
  }

  @Test
  public void validateCorrectUgandaPhone() {
    String country = "Uganda";
    String phone = "(256) 719999999";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertTrue(valid);
  }

  @Test
  public void validateIncorrectUgandaPhone() {
    String country = "Uganda";
    String phone = "(256) 719999A999";

    boolean valid = CountryUtilities.validatePhone(phone, country);
    assertFalse(valid);
  }
}