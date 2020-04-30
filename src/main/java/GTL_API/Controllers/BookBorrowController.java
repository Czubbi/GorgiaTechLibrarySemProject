package GTL_API.Controllers;

import GTL_API.Services.BookBorrowService.IBookBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gtl/card")
public class BookBorrowController {

    private IBookBorrowService bookBorrowService;

    @Autowired
    public void setBookBorrowService(IBookBorrowService bookBorrowService) {
        this.bookBorrowService = bookBorrowService;
    }
}
