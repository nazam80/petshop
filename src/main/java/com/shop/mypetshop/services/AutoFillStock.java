package com.shop.mypetshop.services;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.shop.mypetshop.domain.Breed;
import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.domain.Specie;
import com.shop.mypetshop.repo.BreedRepository;
import com.shop.mypetshop.repo.PetRepository;
import com.shop.mypetshop.repo.SpecieRepository;


@Component
public class AutoFillStock implements ApplicationRunner
{

    private final PetRepository petRepo;
    private final BreedRepository breedRepo;
    private final SpecieRepository specieRepo;

    public AutoFillStock(final PetRepository petRepo, final BreedRepository breedRepo, final SpecieRepository specieRepo)
    {
        this.petRepo = petRepo;
        this.breedRepo = breedRepo;
        this.specieRepo = specieRepo;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception
    {

        final List<Specie> species = new LinkedList<>();

        species.add(createDogs());
        species.add(createCats());

        specieRepo.saveAll(species);

        final List<Pet> petStock = new LinkedList<>();

        petStock.add(new Pet("Lucky", findBreedByName("Husky")));
        petStock.add(new Pet("Charlie", findBreedByName("Husky")));
        petStock.add(new Pet("Oscar", findBreedByName("Poodle")));
        petStock.add(new Pet("Milo", findBreedByName("Poodle")));
        petStock.add(new Pet("Archie", findBreedByName("Rottweiler")));

        petStock.add(new Pet("Tom", findBreedByName("Persian")));
        petStock.add(new Pet("Sneaky", findBreedByName("Siamese")));
        petStock.add(new Pet("Luna", findBreedByName("Siamese")));
        petStock.add(new Pet("Bella", findBreedByName("Siamese")));
        petStock.add(new Pet("Zoe", findBreedByName("Siamese")));
        petStock.add(new Pet("Nala", findBreedByName("Siamese")));

        this.petRepo.saveAll(petStock::listIterator);
    }

    private Specie createCats()
    {
        final Specie specie = new Specie();
        specie.setName("Felis");
        specie.setBreeds(Arrays.asList(
            new Breed("Persian", specie),
            new Breed("Siamese", specie),
            new Breed("Birman", specie),
            new Breed("Bengal", specie)
        ));
        return specie;
    }

    private Specie createDogs()
    {
        final Specie specie = new Specie();
        specie.setName("Canis");
        specie.setBreeds(Arrays.asList(
            new Breed("Husky", specie),
            new Breed("Bulldog", specie),
            new Breed("Poodle", specie),
            new Breed("Labrador", specie),
            new Breed("Beagle", specie),
            new Breed("Rottweiler", specie)
        ));
        return specie;
    }

    private Breed findBreedByName(final String name)
    {
        return breedRepo.findByName(name);
    }
}
