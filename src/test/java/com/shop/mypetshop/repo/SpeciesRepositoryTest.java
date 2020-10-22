package com.shop.mypetshop.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.mypetshop.domain.Breed;
import com.shop.mypetshop.domain.Specie;


@SpringBootTest
public class SpeciesRepositoryTest
{
    @Autowired
    SpecieRepository specieRepo;

    @Autowired
    BreedRepository breedRepo;

    @Test
    public void testSaveSpecieCascade()
    {
        final Specie spec = new Specie();
        spec.setName("Spec1");
        spec.setBreeds(Arrays.asList(new Breed("Breed1", spec)));

        final Specie response = specieRepo.save(spec);

        assertNotNull(response);
        assertNotNull(response.getId());
        assertEquals(spec.getName(), response.getName());

        final Optional<Breed> breed = response.getBreeds().stream().findFirst();
        assertTrue(breed.isPresent());
        assertEquals(spec.getBreeds().get(0).getName(), breed.get().getName());
    }
}
