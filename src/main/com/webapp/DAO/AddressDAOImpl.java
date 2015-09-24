package com.webapp.DAO;

import com.webapp.Model.AddressBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {

    private JdbcTemplate jdbcTemplate;

    public AddressDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String create(final AddressBook address) {
        String sql1 = "SELECT emailid FROM addressdetails";
        List<String> emailids = jdbcTemplate.query(sql1, new RowMapper<String>() {
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                AddressBook addressBook = new AddressBook();
                addressBook.setEmail(resultSet.getString("emailid"));
                return addressBook.getEmail();
            }
        });
        for (int i = 0; i < emailids.size(); i++)
            if (address.getEmail().equals(emailids.get(i))) {
                return "Record already exists";
            }
        String sql = "INSERT INTO addressdetails (name, addressline1, addressline2, city, state, country, pincode, emailid)"
                + " VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
        jdbcTemplate.update(sql, address.getName(), address.getAddressLine1(), address.getAddressLine2(), address.getCity(), address.getState()
                , address.getCountry(), address.getPincode(), address.getEmail());
        return "Succesfully created";


    }

    public List<AddressBook> list() {
        String sql = "SELECT * FROM addressdetails";
        List<AddressBook> listOfAddress = jdbcTemplate.query(sql, new RowMapper<AddressBook>() {

            public AddressBook mapRow(ResultSet rs, int rowNum) throws SQLException {
                AddressBook address = new AddressBook();

                address.setName(rs.getString("name"));
                address.setAddressLine1(rs.getString("addressline1"));
                address.setAddressLine2(rs.getString("addressline2"));
                address.setCity(rs.getString("city"));
                address.setState(rs.getString("state"));
                address.setCountry(rs.getString("country"));
                address.setPincode(rs.getString("pincode"));
                address.setEmail(rs.getString("emailid"));

                return address;
            }

        });

        return listOfAddress;
    }
}
