package com.shop.mypetshop.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shop.mypetshop.application.PetDTO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PetsTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_getAll()
    {
        final ResponseEntity<PetDTO[]> response = restTemplate.getForEntity(createBaseUrl() + "/pets", PetDTO[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        final List<PetDTO> responsePets = Arrays.asList(response.getBody());        
        responsePets.forEach(entity -> {
            assertNotNull(entity.getId());
            assertNotNull(entity.getName());
            assertNotNull(entity.getBreed());
            assertNotNull(entity.getSpecie());
        });
    }
    
    
    @Test
    public void test_addPet()
    {
	final PetDTO request = new PetDTO("My Pet", "Chihuahua", "Canis");
        final ResponseEntity<Object> response = restTemplate.postForEntity(createBaseUrl() + "/pets", request, Object.class);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().getLocation());
    }
    
   

    private String createBaseUrl()
    {
        return String.format("http://localhost:%s", port);
    }
}
