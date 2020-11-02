package com.shop.mypetshop.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.repo.PetRepository;

@Service
public class PetFinder {
    private final PetRepository repo;

    public PetFinder(final PetRepository repo) {
	this.repo = repo;
    }

    /**
     * @return
     */
    public List<PetDTO> findAll() {

	List<Pet> petsFound = repo.findAll();

	return petsFound.stream()
		.map( pet -> new PetDTO(pet.getId(), pet.getName(), pet.getBreed().getName(), pet.getBreed().getSpecie().getName()))
		.collect(Collectors.toList());
	
    }
}
