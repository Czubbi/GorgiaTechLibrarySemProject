package GTL_API.Controllers;

import GTL_API.Services.BookReturnService.IBookReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gtl/card")
public class BookReturnController {

    private IBookReturnService bookReturnService;

    @Autowired
    public void setBookReturnService(IBookReturnService bookReturnService) {
        this.bookReturnService = bookReturnService;
    }


}
