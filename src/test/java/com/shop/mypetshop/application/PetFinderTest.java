package com.shop.mypetshop.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetFinderTest {

    @Autowired    
    private PetFinder petFinder;
    
    @Test
    void testFindAll() {
	List<PetDTO> response = petFinder.findAll();

	assertNotNull(response);	

	response.forEach(entity -> {
	    assertNotNull(entity.getId());
	    assertNotNull(entity.getName());
	    assertNotNull(entity.getBreed());
	    assertNotNull(entity.getSpecie());
	});
    }

}
