package GTL_API.Services.BookBorrowService;

import GTL_API.Models.CreationModels.BookBorrowCreation;
import GTL_API.Models.ReturnModels.BookBorrowReturn;

import java.util.List;

public interface IBookBorrowService {
    BookBorrowReturn borrowBook(BookBorrowCreation bookBorrowCreation);

    List<Integer> findBookBorrows(int bookCatalogId, String ssn);
}
