package com.shop.mypetshop.rest;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shop.mypetshop.application.PetCreator;
import com.shop.mypetshop.application.PetDTO;
import com.shop.mypetshop.application.PetFinder;
import com.shop.mypetshop.domain.Pet;


/**
 * Rest controller used to expose REST endpoints for operations with {@link Pet} objects.
 */
@CrossOrigin
@RestController
@RequestMapping("/pets")
public class Pets
{
    private final PetFinder finder;
    private final PetCreator creator;

    public Pets(final PetFinder finder, final PetCeator creator)
    {
        this.finder = finder;
        this.creator = creator;
    }

    @GetMapping
    public List<PetDTO> getAll()
    {
        return finder.findAll();
    }
    
    @PostMapping
    public ResponseEntity<Object> addPet(@RequestBody PetDTO body)
    {
	Long petCreated = creator.create(body);
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(petCreated).toUri();

	return ResponseEntity.created(location).build();
    }
}
