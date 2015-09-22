package java.com.webapp.Controller;


import com.webapp.DAO.CountryDAO;
import com.webapp.Model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "classpath:resources/test-mvc-dispatcher-servlet.xml")
public class CountryControllerTest {

    private static final String COUNTRY = "/country";

    @Autowired
    private CountryDAO countryDAO;
    private MockMvc mockMvc;

    @Test
    public void shouldBeAbleToGetTheCountryList() throws Exception {
        List countryList = Arrays.asList(new Country("India"), new Country("Australia"));

        when(countryDAO.listCountries()).thenReturn(countryList);


        this.mockMvc.perform(get(COUNTRY)).andExpect(status().isOk()).andExpect(content().string("[{\"name\":\"India\"},{\"name\":\"Australia\"}]"));

    }


}



