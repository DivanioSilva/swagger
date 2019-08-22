package com.ds.swagger.repository;

import com.ds.swagger.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String personName);

    @Query(value = "SELECT p FROM Person p WHERE p.name = :name")
    Optional<Person> test(@Param("name") String name);


}
