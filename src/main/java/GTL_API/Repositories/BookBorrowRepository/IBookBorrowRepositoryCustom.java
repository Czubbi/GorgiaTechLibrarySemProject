package GTL_API.Repositories.BookBorrowRepository;

import GTL_API.Models.Entities.BookBorrowEntity;
import GTL_API.Models.ReturnModels.BookBorrowReturn;

public interface IBookBorrowRepositoryCustom {
    BookBorrowReturn createBookBorrow(BookBorrowEntity bookBorrowEntity, int bookReturnId);
}
