package GTL_API.Controllers;

import GTL_API.Models.ReturnModels.PersonReturn;
import GTL_API.Models.UpdateModels.PersonUpdate;
import GTL_API.Services.PersonService.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("gtl/person")
public class PersonController {
    private IPersonService iPersonService;

    @Autowired
    public void setiPersonService(IPersonService iPersonService){
        this.iPersonService = iPersonService;
    }

    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    public ResponseEntity<?> updatePersonBySsn(@RequestBody PersonUpdate person){
        return new ResponseEntity<>(iPersonService.updatePerson(person), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> createPerson(@RequestBody PersonUpdate person){
        return new ResponseEntity<>(iPersonService.updatePerson(person), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/findbyname/", method = RequestMethod.GET)
    public ResponseEntity<?> findPersonByFirstNameAndLastName(@RequestBody PersonReturn person){
        return new ResponseEntity<>(iPersonService.findPersonByFirstNameAndLastName(person.getFirstName(), person.getLastName()), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/findbycard/", method = RequestMethod.GET)
    public ResponseEntity<?> findPersonByCardNumber(@RequestBody PersonReturn person){
        return new ResponseEntity<>(iPersonService.findPersonByCardNumberId(person.getCardNumberId()), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/findbyssn/", method = RequestMethod.GET)
    public ResponseEntity<?> findPersonBySsn(@RequestBody PersonReturn person){
        return new ResponseEntity<>(iPersonService.findPersonBySsn(person.getSsn()), new HttpHeaders(), HttpStatus.OK);
    }
}
