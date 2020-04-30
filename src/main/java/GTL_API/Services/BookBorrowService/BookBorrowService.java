package GTL_API.Services.BookBorrowService;

import GTL_API.Models.CreationModels.BookBorrowCreation;
import GTL_API.Models.CreationModels.BookReturnCreation;
import GTL_API.Models.Entities.BookBorrowEntity;
import GTL_API.Models.ReturnModels.BookBorrowReturn;
import GTL_API.Models.ReturnModels.BookReturnReturn;
import GTL_API.Repositories.BookBorrowRepository.IBookBorrowRepositoryCustom;
import GTL_API.Services.BookReturnService.IBookReturnService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookBorrowService implements IBookBorrowService {


    private IBookReturnService bookReturnService;

    private IBookBorrowRepositoryCustom bookBorrowRepositoryCustom;

    private ModelMapper modelMapper;

    @Autowired
    public void setBookReturnService(IBookReturnService bookReturnService) {
        this.bookReturnService = bookReturnService;
    }

    @Autowired
    public void setBookBorrowRepositoryCustom(IBookBorrowRepositoryCustom bookBorrowRepositoryCustom) {
        this.bookBorrowRepositoryCustom = bookBorrowRepositoryCustom;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookBorrowReturn borrowBook(BookBorrowCreation bookBorrowCreation) {
        BookReturnReturn result = bookReturnService.createBookReturn(
                new BookReturnCreation(), bookBorrowCreation.getSsn()
        );
        int bookReturnId = result.getId();
        return bookBorrowRepositoryCustom.createBookBorrow(
                modelMapper.map(bookBorrowCreation, BookBorrowEntity.class),
                bookReturnId
        );
    }
}
