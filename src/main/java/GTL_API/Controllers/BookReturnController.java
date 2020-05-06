package GTL_API.Controllers;

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

    @RequestMapping(value = "/{bookCatalogId}/{cardNumber}", method = RequestMethod.POST)
    public ResponseEntity<?> returnBook(@PathVariable int bookCatalogId, @PathVariable int cardNumber) {
        return new ResponseEntity<>(bookReturnService.returnBook(bookCatalogId, cardNumber), new HttpHeaders(), HttpStatus.FOUND);
    }


}
