package com.webapp.Controller;


import com.webapp.DAO.AddressDAO;
import com.webapp.Model.AddressBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "classpath:resources/test-mvc-dispatcher-servlet.xml")
public class AddressControllerTest {

    private static final String ADDRESS = "/listAddress";
    private static final String POSTADDRESS = "/saveAddress";

    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;


    @Test
    public void shouldBeAbleToGetTheAddressList() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        AddressBook address1 = new AddressBook("abc", "no.1 1st cross", "2nd main koramangala", "bangalore", "karnataka", "india", "50098", "abc@mail.com");
        AddressBook address2 = new AddressBook("xyz", "no.1 1st cross", "2nd main koramangala", "bangalore", "karnataka", "india", "50098", "xyz@mail.com");
        List addressList = Arrays.asList(address1, address2);
        when(addressDAO.list()).thenReturn(addressList);


        this.mockMvc.perform(get(ADDRESS))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"name\":\"abc\",\"city\":\"bangalore\",\"state\":\"karnataka\",\"country\":\"india\",\"pincode\":\"50098\",\"addressLine1\":\"no.1 1st cross\",\"addressLine2\":\"2nd main koramangala\",\"email\":\"abc@mail.com\"},{\"name\":\"xyz\",\"city\":\"bangalore\",\"state\":\"karnataka\",\"country\":\"india\",\"pincode\":\"50098\",\"addressLine1\":\"no.1 1st cross\",\"addressLine2\":\"2nd main koramangala\",\"email\":\"xyz@mail.com\"}]"));

    }

    @Test
    public void shouldBeAbleToPostTheAddress() throws Exception {
        AddressBook address = mock(AddressBook.class);
        //String contentData = "[{\"name\":\"abc\",\"city\":\"bangalore\",\"state\":\"karnataka\",\"country\":\"india\",\"pincode\":\"50098\",\"addressLine1\":\"no.1 1st cross\",\"addressLine2\":\"2nd main koramangala\",\"email\":\"abc@mail.com\"}]";
        String contentData = "{\"name\":\"q\" , \"addressline1\":\"no3\" , \"addressline2\":\"jayanagar\" , \"city\":\"bengaluru\" , \"state\":\"kar\" , \"country\":\"india\" , \"pincode\":\"560034\" , \"emailid\":\"q@mail.com\"}";
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        when(addressDAO.create(address)).thenReturn("Successfully created");
        this.mockMvc.perform(post(POSTADDRESS).contentType(MediaType.APPLICATION_JSON).content(contentData))
                .andExpect(status().isOk());
    }
}
