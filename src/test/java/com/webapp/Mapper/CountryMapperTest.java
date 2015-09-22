package com.webapp.Mapper;

import com.webapp.Model.Country;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryMapperTest {

    private ResultSet rs = mock(ResultSet.class);
    Country country;

    @Test
    public void ableToMapToACountry() throws SQLException {
        CountryMapper mapper = new CountryMapper();
        when(rs.getString("name")).thenReturn("India");
        country = mapper.mapRow(rs, 1);
        assertEquals("India" , country.getName());
    }
}
