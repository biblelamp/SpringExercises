package spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.domain.Person;
import spring.service.PersonService;

import java.util.List;

@SpringBootTest
public class PersonServiceTest {

    @Autowired
    PersonService personService;

    static final String FIRST_NAME = "Ivan";
    static final String LAST_NAME = "Ivanov";

    @Test
    public void testAdd() {
        List<Person> persons = personService.findAll();
        int count = persons.size();

        Person person = new Person(FIRST_NAME, LAST_NAME);
        person = personService.add(person);

        persons = personService.findAll();
        Assertions.assertTrue(persons.size() - count == 1);
        Assertions.assertTrue(person.getFirstName().equals(FIRST_NAME));
        Assertions.assertTrue(person.getLastName().equals(LAST_NAME));
    }
}
