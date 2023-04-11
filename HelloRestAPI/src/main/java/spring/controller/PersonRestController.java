package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import spring.controller.vo.PersonVO;
import spring.domain.Person;
import spring.service.PersonService;

import java.util.List;

@RestController
public class PersonRestController implements SimpleRestApi {

    @Autowired
    private PersonService personService;

    @Override
    public ResponseEntity<PersonVO> add(PersonVO body) {
        PersonVO result = personService.add(body);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<PersonVO> get(Integer id) {
        Person person = personService.findById(id);
        PersonVO result = PersonVO.valueOf(person);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<List<PersonVO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<PersonVO> update(Integer id, PersonVO body) {
        return null;
    }
}
