package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.service.PersonService;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("spring");
        appContext.refresh();

        PersonService personService = (PersonService) appContext.getBean("personService");
        personService.add("first", "second");

        appContext.close();
    }
}
