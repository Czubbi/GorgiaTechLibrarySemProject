package GTL_API.Services.BookBorrowService;

import GTL_API.Exceptions.NotFoundException;
import GTL_API.Models.CreationModels.BookBorrowCreation;
import GTL_API.Models.CreationModels.BookReturnCreation;
import GTL_API.Models.Entities.BookBorrowEntity;
import GTL_API.Models.ReturnModels.*;
import GTL_API.Repositories.BookBorrowRepository.IBookBorrowRepositoryCustom;
import GTL_API.Services.AvailableBooksService.IAvailableBooksService;
import GTL_API.Services.BookCatalogService.IBookCatalogService;
import GTL_API.Services.BookReturnService.IBookReturnService;
import GTL_API.Services.BookService.IBookService;
import GTL_API.Services.PersonService.IPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookBorrowService implements IBookBorrowService {

    private IBookReturnService bookReturnService;

    private IBookService iBookService;

    private IAvailableBooksService iAvailableBooksService;

    private IBookCatalogService iBookCatalogService;

    private IBookBorrowRepositoryCustom bookBorrowRepositoryCustom;

    private ModelMapper modelMapper;

    private IPersonService personService;

    @Autowired
    public void setIAvailableBooksService(IAvailableBooksService iAvailableBooksService) {
        this.iAvailableBooksService = iAvailableBooksService;
    }

    @Autowired
    public void setIBookService(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @Autowired
    public void setIBookCatalogService(IBookCatalogService iBookCatalogService) {
        this.iBookCatalogService = iBookCatalogService;
    }

    @Autowired
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

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
    @Transactional(rollbackFor = Exception.class)
    public BookBorrowReturnView borrowBook(BookBorrowCreation bookBorrowCreation) {
        String isbn = iBookCatalogService.getBookCatalog(bookBorrowCreation.getBookCatalogId()).getIsbn();
        AvailableBooksReturn availableBooksReturn = iAvailableBooksService.findAvailableByCatalogId(bookBorrowCreation.getBookCatalogId());
        if(iBookService.findBook(isbn).getAvailableBooksNumber() > 0){
            if(availableBooksReturn == null){
                throw new NotFoundException(String.format("The book with ISBN: %s, is not available", availableBooksReturn.getIsbn()));
            }
            UserDetails user =  (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            PersonReturn foundPerson = personService.findPersonByCardNumberId(Integer.parseInt(user.getUsername()));
            String ssn = foundPerson.getSsn();
            BookReturnReturn result = bookReturnService.createBookReturn(
                    new BookReturnCreation(), ssn
            );

            iBookService.borrowingBookDecrease(isbn);
            int bookReturnId = result.getId();
            bookBorrowCreation.setSsn(ssn);
            bookBorrowRepositoryCustom.createBookBorrow(
                    modelMapper.map(bookBorrowCreation, BookBorrowEntity.class),
                    bookReturnId
            );
            BookReturn bookReturn = iBookService.findBook(isbn);
            BookBorrowReturnView bookBorrowReturnView = modelMapper.map(bookReturn, BookBorrowReturnView.class);
            bookBorrowReturnView.setCatalogId(bookBorrowCreation.getBookCatalogId());
            return bookBorrowReturnView;
        }else{
            throw new NotFoundException(String.format("There is not available book copies with ISBN: %s", isbn));
        }

    }

    @Override
    public List<Integer> findBookBorrows(int bookCatalogId, String ssn) {
        return bookBorrowRepositoryCustom.findBorrowedBook(bookCatalogId, ssn);
    }
}
