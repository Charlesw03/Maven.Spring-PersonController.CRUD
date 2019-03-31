package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {

        this.personRepo = personRepo;
    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(personRepo.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(personRepo.findOne(id), HttpStatus.CREATED);
    }

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPersonlist() {
        List<Person> list = new ArrayList<>();
        personRepo.findAll().forEach(x->list.add(x));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Person person) {
        return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        personRepo.delete(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);

    }



}
