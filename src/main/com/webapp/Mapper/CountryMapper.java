package com.webapp.Mapper;

import com.webapp.Model.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CountryMapper implements RowMapper<Country> {
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        Country country = new Country();
        country.setName(rs.getString("name"));
        return country;
       }
}
