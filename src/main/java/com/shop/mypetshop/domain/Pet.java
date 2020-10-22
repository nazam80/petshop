package com.shop.mypetshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * Pet entity definition. It defines the pets characteristics stored into the database.
 */
@Entity
public class Pet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Breed breed;

    public Pet()
    {
    }

    public Pet(final String name, final Breed breed)
    {
        this.name = name;
        this.breed = breed;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Breed getBreed()
    {
        return breed;
    }

    public void setBreed(final Breed breed)
    {
        this.breed = breed;
    }
}
