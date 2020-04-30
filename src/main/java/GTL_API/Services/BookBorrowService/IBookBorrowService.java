package GTL_API.Services.BookBorrowService;

import GTL_API.Models.CreationModels.BookBorrowCreation;
import GTL_API.Models.ReturnModels.BookBorrowReturn;

public interface IBookBorrowService {
    BookBorrowReturn borrowBook(BookBorrowCreation bookBorrowCreation);
}
