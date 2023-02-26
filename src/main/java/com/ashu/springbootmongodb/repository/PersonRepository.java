package com.ashu.springbootmongodb.repository;

import com.ashu.springbootmongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstNameStartsWith(String name);

//    List<Person> findByAgeBetween(Integer min, Integer max);

    @Query(value = "{'age' : { $gt : ?0, $lt : ?1}}")
    List<Person> findPersonByAgeBetween(Integer min, Integer max);
}
