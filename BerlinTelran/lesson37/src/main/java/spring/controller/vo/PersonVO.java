package spring.controller.vo;

import spring.domain.Person;

import javax.validation.constraints.NotBlank;

public class PersonVO {
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public PersonVO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static PersonVO valueOf(Person person) {
        return new PersonVO(person.getId(), person.getFirstName(), person.getLastName());
    }
}
