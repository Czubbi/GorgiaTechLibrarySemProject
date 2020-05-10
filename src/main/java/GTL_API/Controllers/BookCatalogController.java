package GTL_API.Controllers;

import GTL_API.Models.CreationModels.BookCatalogCreation;
import GTL_API.Models.UpdateModels.BookCatalogUpdate;
import GTL_API.Services.BookCatalogService.IBookCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gtl/bookCatalog")
public class BookCatalogController {

    private IBookCatalogService iBookCatalogService;

    @Autowired
    public void setIBookCatalogService(IBookCatalogService iBookCatalogService) {
        this.iBookCatalogService = iBookCatalogService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getBooksCatalog() {
        return new ResponseEntity<>(iBookCatalogService.getBooksCatalog(), new HttpHeaders(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookCatalog(@PathVariable int id) {
        return new ResponseEntity<>(iBookCatalogService.getBookCatalog(id), new HttpHeaders(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> addBookCatalog(@RequestBody @Validated BookCatalogCreation bookCatalogCreation) {
        return new ResponseEntity<>(iBookCatalogService.addBookCatalog(bookCatalogCreation), new HttpHeaders(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateBookCatalog(@RequestBody @Validated BookCatalogUpdate bookCatalogUpdate) {
        return new ResponseEntity<>(iBookCatalogService.updateBookCatalog(bookCatalogUpdate), new HttpHeaders(), HttpStatus.FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBookCatalog(@PathVariable int id) {
        return new ResponseEntity<>(iBookCatalogService.removeBookCatalog(id), new HttpHeaders(), HttpStatus.FOUND);
    }
}
