package com.shop.mypetshop.application;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shop.mypetshop.domain.Breed;
import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.domain.Specie;
import com.shop.mypetshop.repo.BreedRepository;
import com.shop.mypetshop.repo.PetRepository;
import com.shop.mypetshop.repo.SpecieRepository;

@Service
public class PetCreator {
    private final SpecieRepository specieRepo;
    private final BreedRepository breedRepo;
    private final PetRepository petRepo;

    public PetCreator(final SpecieRepository specieRepo, final BreedRepository breedRepo, final PetRepository petRepo) {
	this.specieRepo = specieRepo;
	this.breedRepo = breedRepo;
	this.petRepo = petRepo;
    }

    @Transactional
    public Long create(PetDTO pet) {
	final Breed breed = getOrCreateBreed(pet);
	
	final Pet petToCreate = new Pet();
	petToCreate.setId(pet.getId());
	petToCreate.setName(pet.getName());
	petToCreate.setBreed(breed);
	
	
	final Pet result = petRepo.save(petToCreate);
	return result.getId();
    }

    private Breed getOrCreateBreed(PetDTO pet) {
	Breed breed = breedRepo.findByName(pet.getBreed());
	return breed!= null ? breed : createBreed(pet);
    }

    
    private Breed createBreed(PetDTO pet) {
	final Specie specie = specieRepo.findByName(pet.getSpecie()); 
	if( specie==null ) {
	    final Specie specieCreated = createSpecieWithBreed(pet);
	    return specieCreated.getBreeds().stream().findFirst().orElse(null);
	}
	Breed breed = new Breed(pet.getBreed(), specie);
	return breedRepo.save(breed);	
    }
    
    private Specie createSpecieWithBreed(PetDTO pet) {
	final Specie specie = new Specie();
	specie.setName(pet.getSpecie());	
	
	specie.setBreeds(Arrays.asList(new Breed(pet.getBreed(), specie)));
	
	return specieRepo.save(specie);
    }

}
