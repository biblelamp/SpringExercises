package spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.controller.vo.PersonVO;
import spring.domain.Person;
import spring.domain.Position;
import spring.repository.PersonRepository;
import spring.repository.PositionRepository;

import java.util.List;

@Service
public class PersonService {

    final static Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PositionRepository positionRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).get();
    }

    public PersonVO add(PersonVO person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        newPerson = personRepository.save(newPerson);
        logger.info("Added new Person, personId={}", newPerson.getId());

        return PersonVO.valueOf(newPerson);
    }

    public Person add(Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        //Position position = positionRepository.findById(1).get();
        //newPerson.setPosition(position);
        newPerson = personRepository.save(newPerson);
        logger.info("Added new Person, personId={}", newPerson.getId());

        return newPerson;
    }

    public void update(Person person) {
        personRepository.save(person);
    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
}
