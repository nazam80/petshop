package com.shop.mypetshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * Spring data repository used to handle SQL interactions based on {@link Breed} entities.
 *
 * https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 */
@Entity
public class Breed
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Specie specie;

    public Breed()
    {

    }

    public Breed(final String name, final Specie specie)
    {
        this.name = name;
        this.specie = specie;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Specie getSpecie()
    {
        return specie;
    }

    public void setSpecie(final Specie specie)
    {
        this.specie = specie;
    }
}
