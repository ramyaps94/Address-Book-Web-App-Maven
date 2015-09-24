package com.webapp.Controller;


import com.webapp.DAO.AddressDAO;
import com.webapp.Model.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressDAO addressDAO;

    @RequestMapping(value = "/listAddress", headers = "Accept=application/json",
            method = RequestMethod.GET)
    public List<AddressBook> listAddress() throws IOException {
        return addressDAO.list();
    }

    @RequestMapping(value = "/saveAddress", headers = "Content-type=application/json", method = RequestMethod.POST)
    public String saveAddress(@RequestBody AddressBook address) {
       String result = addressDAO.create(address);
        return result;
    }
}
