package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.domain.Person;
import spring.service.PersonService;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("person") Person person) {
        personService.add(person);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable final Integer id) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("person") Person person) {
        personService.update(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable final Integer id) {
        personService.delete(id);
        return "redirect:/";
    }
}
