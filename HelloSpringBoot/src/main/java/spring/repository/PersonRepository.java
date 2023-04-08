package spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
