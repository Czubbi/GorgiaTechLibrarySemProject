package GTL_API.Controllers;

import GTL_API.Services.BookReturnService.IBookReturnService;
import GTL_API.Services.NotReturnedService.INotReturnedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gtl/return")
public class BookReturnController {

    private IBookReturnService iBookReturnService;

    private INotReturnedService iNotReturnedService;

    @Autowired
    public void setINotReturnedService(INotReturnedService iNotReturnedService) {
        this.iNotReturnedService = iNotReturnedService;
    }

    @Autowired
    public void setBookReturnService(IBookReturnService iBookReturnService) {
        this.iBookReturnService = iBookReturnService;
    }

    @RequestMapping(value = "/{bookCatalogId}/{cardNumber}", method = RequestMethod.POST)
    public ResponseEntity<?> returnBook(@PathVariable int bookCatalogId, @PathVariable int cardNumber) {
        return new ResponseEntity<>(iBookReturnService.returnBook(bookCatalogId, cardNumber), new HttpHeaders(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getListPeopleWhoDidNotReturnedBooks() {
        return new ResponseEntity<>(iNotReturnedService.getListPeopleWhoDidNotReturnedBooks(), new HttpHeaders(), HttpStatus.FOUND);
    }


}
