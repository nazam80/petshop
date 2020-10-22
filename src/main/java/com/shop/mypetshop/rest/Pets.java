package com.shop.mypetshop.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.mypetshop.domain.Pet;
import com.shop.mypetshop.repo.PetRepository;


/**
 * Rest controller used to expose REST endpoints for operations with {@link Pet} objects.
 */
@CrossOrigin
@RestController
@RequestMapping("/pets")
public class Pets
{
    private final PetRepository repo;

    public Pets(final PetRepository repo)
    {
        this.repo = repo;
    }

    @GetMapping
    public List<Pet> getAll()
    {
        return repo.findAll();
    }
}
