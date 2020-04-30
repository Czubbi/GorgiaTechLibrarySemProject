package GTL_API.Repositories.BookBorrowRepository;

import GTL_API.Models.Entities.BookBorrowEntity;
import GTL_API.Models.ReturnModels.BookBorrowReturn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

@Component
public class BookBorrowRepository implements IBookBorrowRepositoryCustom {

    private IBookBorrowRepository iBookBorrowRepository;

    private ModelMapper modelMapper;

    @Autowired
    public void setIBookBorrowRepository(IBookBorrowRepository iBookBorrowRepository) {
        this.iBookBorrowRepository = iBookBorrowRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookBorrowReturn createBookBorrow(BookBorrowEntity bookBorrowEntity, int bookReturnId) {
        bookBorrowEntity.setBookReturnId(bookReturnId);
        bookBorrowEntity.setBorrowDate(new Date(Calendar.getInstance().getTime().getTime()));
        BookBorrowEntity savedBookBorrow = iBookBorrowRepository.save(bookBorrowEntity);
        return modelMapper.map(savedBookBorrow, BookBorrowReturn.class);
    }
}
