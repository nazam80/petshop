package com.shop.mypetshop.application;

import java.util.Objects;

public class PetDTO {
    

    private Long id;

    private String name;
    
    private String breed;
    
    private String specie;
    
    public PetDTO() {	
    }

    public PetDTO(String name, String breed, String specie) {
	this(null, name, breed, specie);
    }
    
    public PetDTO(Long id, String name, String breed, String specie) {
	super();
	this.id = id;
	this.name = name;
	this.breed = breed;
	this.specie = specie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	PetDTO other = (PetDTO) obj;
	return Objects.equals(id, other.id);
    }

    
    
}
