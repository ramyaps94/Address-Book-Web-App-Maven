package com.webapp.DAO;

import com.webapp.Model.AddressBook;

import java.util.List;

public interface AddressDAO {


    public String create(AddressBook address);

    public List<AddressBook> list();
}
