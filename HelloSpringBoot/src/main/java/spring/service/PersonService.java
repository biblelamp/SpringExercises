package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> persons;

    public PersonService() {
        persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov"));
        persons.add(new Person("Petr", "Petrov"));
    }

    public List<Person> findAll() {
        return persons;
    }

    public Person findById(Integer id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void add(Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        persons.add(newPerson);
    }

    public void update(Person person) {
        Person updatePerson = findById(person.getId());
        if (updatePerson != null) {
            updatePerson.setFirstName(person.getFirstName());
            updatePerson.setLastName(person.getLastName());
        }
    }

    public void delete(Integer id) {
        Person deletePerson = findById(id);
        if (deletePerson != null) {
            persons.remove(deletePerson);
        }
    }
}
