package com.shop.mypetshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.mypetshop.domain.Breed;


/**
 * Spring data repository used to handle SQL interactions based on {@link Breed} entities.
 *
 * https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 */
@Repository
public interface BreedRepository extends JpaRepository<Breed, Long>
{
    Breed findByName(String name);
}
