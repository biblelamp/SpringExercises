package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public void add(Person person) {
        personRepository.save(person);
    }
}
