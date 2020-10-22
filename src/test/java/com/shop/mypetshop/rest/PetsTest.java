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

import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.domain.Specie;


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
        final ResponseEntity<Pet[]> response = restTemplate.getForEntity(createBaseUrl() + "/pets", Pet[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        final List<Pet> responsePets = Arrays.asList(response.getBody());
        assertEquals(11, responsePets.size());
        responsePets.forEach(entity -> {
            assertNotNull(entity.getId());
            assertNotNull(entity.getName());
            assertNotNull(entity.getBreed());

            final Specie specie = entity.getBreed().getSpecie();
            assertNotNull(specie);
            assertNotNull(specie.getName());
        });
    }

    private String createBaseUrl()
    {
        return String.format("http://localhost:%s", port);
    }
}
