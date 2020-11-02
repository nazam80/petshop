package com.shop.mypetshop.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetCreatorTest {

    @Autowired
    private PetCreator petCreator;

    @Test
    void testCreateWithoutIdUnexistingBreedAndSpecie() {
	final PetDTO pet = new PetDTO("Name1", "Breed1", "Spec1");

	Long response = petCreator.create(pet);

	assertNotNull(response);
    }

    @Test
    void testCreateExistingBreedAndSpec() {
	final PetDTO pet = new PetDTO("Name4", "Husky", "Canis");

	Long response = petCreator.create(pet);

	assertNotNull(response);
    }

    @Test
    void testCreateExistingOnlySpec() {
	final PetDTO pet = new PetDTO("Name3", "My Breed", "Canis");

	Long response = petCreator.create(pet);

	assertNotNull(response);
    }

}
