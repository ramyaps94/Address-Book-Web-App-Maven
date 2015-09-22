package com.webapp.Model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountryTest {
    @Test
    public void shouldBeAbleToReturnCountry() {
        Country country = new Country("India");
        assertEquals("India", country.getName());
    }
}
