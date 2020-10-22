package com.shop.mypetshop.application;

import org.springframework.stereotype.Service;

import com.shop.mypetshop.domain.Breed;
import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.domain.Specie;
import com.shop.mypetshop.repo.PetRepository;

@Service
public class PetCreator {
    private final PetRepository repo;

    public PetCreator(final PetRepository repo) {
	this.repo = repo;
    }

    
    public Long create(PetDTO pet) {
	Specie specie = new Specie();
	specie.setName(pet.getSpecie());
	Breed breed = new Breed(pet.getBreed(), specie);
		
	Pet petToCreate = new Pet(pet.getName(), breed);
	
	Pet result = repo.save(petToCreate);
	return result.getId();
    }
}
