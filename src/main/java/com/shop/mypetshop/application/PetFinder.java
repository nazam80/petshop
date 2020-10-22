package com.shop.mypetshop.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.mypetshop.domain.Breed;
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

	List<PetDTO> petsResult = new ArrayList<PetDTO>();

	List<Pet> petsFound = repo.findAll();

//	 petsResult = petsFound.stream().map( p -> {
//	     PetDTO pet = new PetDTO(p.getId(), p.getName(), p.getBreed().getName(), p.getBreed().getSpecie().getName())
//	     return pet;
//	 }).collect(Collectors.toList());

	for (Pet petFound : petsFound) {
	    Breed petBreed = petFound.getBreed();
	    PetDTO petResult = new PetDTO(petFound.getId(), petFound.getName(), petBreed.getName(),
		    petBreed.getSpecie().getName());
	    petsResult.add(petResult);
	}

	return petsResult;
    }
}
