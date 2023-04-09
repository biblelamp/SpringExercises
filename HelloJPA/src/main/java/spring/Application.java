package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.domain.Person;
import spring.service.PersonService;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("spring");
        context.refresh();

        PersonService personService = (PersonService) context.getBean("personService");

//        Person person = new Person("Sidor", "Sidorov");
//        personService.add(person);

        Iterable<Person> persons = personService.findAll();
        System.out.println(persons);
    }
}
