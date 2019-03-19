package com.cenkc.petclinic;

import com.cenkc.petclinic.model.Owner;
import com.cenkc.petclinic.service.PetClinicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PetclinicApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PetClinicService petClinicService;

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private RestTemplate restTemplate;
    private String baseUrl;

    @Before
    public void setup() {
        restTemplate = restTemplateBuilder.build();
        baseUrl = "http://localhost:" + port + "/rest/";
    }

    @Test
    public void testCreateOwner(){
        Owner o = new Owner();
        o.setEmail("foo@bar");
        o.setFirstName("Foo");
        o.setLastName("Bar");
        Long id = restTemplate.postForObject(baseUrl + "owner", o, Long.class);

        String response = restTemplate.getForObject(baseUrl + "owner/" + id,
                String.class);

        System.out.println(">>>" + response);
    }

    @Test
    public void contextLoads() {
    }
}
