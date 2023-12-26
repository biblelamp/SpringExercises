package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.Person;
import spring.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void add(String firstName, String secondName) {
        Person person = new Person(firstName, secondName);
        personRepository.save(person);
    }
}
