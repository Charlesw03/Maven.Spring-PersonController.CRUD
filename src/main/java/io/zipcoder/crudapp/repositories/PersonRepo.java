package io.zipcoder.crudapp.repositories;

import io.zipcoder.crudapp.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person,Long> {

}
