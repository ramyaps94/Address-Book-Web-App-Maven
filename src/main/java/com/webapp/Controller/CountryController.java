package com.webapp.Controller;


import com.webapp.DAO.CountryDAO;
import com.webapp.Model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryDAO countryDAO;

    @RequestMapping(value = "/country", headers = "Accept=application/json",
            method = RequestMethod.GET)
    public List<Country> listCountry() throws IOException {
        //model.addObject("listCountry", listCountry);
        //model.setViewName("country");

        return countryDAO.listCountries();

    }

    ArrayList<String> countries = new ArrayList<String>();

    @RequestMapping(value = "/getCountryList", produces = "text/plain", method = RequestMethod.GET)
    public String getCountryList() {
        ArrayList<String> resultList = getCountries();
        String result = "";
        for (int i = 0; i < resultList.size(); i++)
            result = result + "\n" + resultList.get(i);
        return result;
    }

    ArrayList<String> getCountries() {
        countries.add("India");
        countries.add("China");
        return countries;
    }

}
