package com.jumia.util;

import com.jumia.dto.CountryProperties;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class CountryUtilities {

  private static final Map<String, CountryProperties> countries;

  static {
    Map<String, CountryProperties> tempCountries = new HashMap<>();
    CountryProperties cameroonProperties = new CountryProperties("(237)",
        "\\(237\\)\\ ?[2368]\\d{7,8}$");
    tempCountries.put("Cameroon", cameroonProperties);

    CountryProperties ethiopiaProperties = new CountryProperties("(251)",
        "\\(251\\)\\ ?[1-59]\\d{8}$");
    tempCountries.put("Ethiopia", ethiopiaProperties);

    CountryProperties moroccoProperties = new CountryProperties("(212)",
        "\\(212\\)\\ ?[5-9]\\d{8}$");
    tempCountries.put("Morocco", moroccoProperties);

    CountryProperties mozambiqueProperties = new CountryProperties("(258)",
        "\\(258\\)\\ ?[28]\\d{7,8}$");
    tempCountries.put("Mozambique", mozambiqueProperties);

    CountryProperties ugandaProperties = new CountryProperties("(256)",
        "\\(256\\)\\ ?\\d{9}$");
    tempCountries.put("Uganda", ugandaProperties);
    countries = Collections.unmodifiableMap(tempCountries);
  }

  private CountryUtilities() {
    throw new IllegalStateException("Utility class");
  }

  public static String getPhoneCountry(String phone) {
    for (Map.Entry<String, CountryProperties> entry : countries.entrySet()) {
      if (phone.startsWith(entry.getValue().getCountryCode())) {
        return entry.getKey();
      }
    }
    return "";
  }

  public static boolean validatePhone(String phone, String country) {
    return phone.matches(countries.get(country).getCountryRegex());
  }
}
