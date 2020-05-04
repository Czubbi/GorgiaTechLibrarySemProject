package GTL_API.Controllers;

import GTL_API.Models.CreationModels.BookReturnCreation;
import GTL_API.Services.BookReturnService.IBookReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gtl/return")
public class BookReturnController {

    private IBookReturnService bookReturnService;

    @Autowired
    public void setBookReturnService(IBookReturnService bookReturnService) {
        this.bookReturnService = bookReturnService;
    }

    @RequestMapping(value = "/{ssn}", method = RequestMethod.GET)
    public ResponseEntity<?> findCardByNumber(@PathVariable String ssn, @RequestBody BookReturnCreation bookReturn) {
        return new ResponseEntity<>(bookReturnService.createBookReturn(bookReturn, ssn), new HttpHeaders(), HttpStatus.FOUND);
    }


}
