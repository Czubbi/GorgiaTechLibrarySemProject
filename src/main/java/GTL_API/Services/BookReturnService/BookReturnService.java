package GTL_API.Services.BookReturnService;

import GTL_API.Models.CreationModels.BookReturnCreation;
import GTL_API.Models.Entities.BookReturnEntity;
import GTL_API.Models.ReturnModels.BookReturnReturn;
import GTL_API.Repositories.BookReturnRespository.IBookReturnRepositoryCustom;
import GTL_API.Services.BookBorrowService.IBookBorrowService;
import GTL_API.Services.PersonService.IPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class BookReturnService implements IBookReturnService {

    private IPersonService personService;

    private IBookReturnRepositoryCustom iBookReturnRepository;

    private IBookBorrowService bookBorrowService;

    private ModelMapper modelMapper;

    @Autowired
    public void setBookBorrowService(IBookBorrowService bookBorrowService) {
        this.bookBorrowService = bookBorrowService;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public void setIBookReturnRepository(IBookReturnRepositoryCustom iBookReturnRepository) {
        this.iBookReturnRepository = iBookReturnRepository;
    }

    @Override
    public BookReturnReturn createBookReturn(BookReturnCreation bookReturnCreation, String ssn) {
        bookReturnCreation.setPayment(0D);
        bookReturnCreation.setStatus(false);
        int loanDuration = personService.findPersonBySsn(ssn).getLoanDuration();
        Calendar c = Calendar.getInstance();
        c.setTime(new java.util.Date(new java.util.Date().getTime()));
        c.add(Calendar.DATE, loanDuration);
        bookReturnCreation.setEstimatedReturnDate(new Date(c.getTime().getTime()));
        BookReturnReturn result = iBookReturnRepository.createBookReturn(
                modelMapper.map(bookReturnCreation, BookReturnEntity.class)
        );
        return result;
    }

    @Override
    public boolean returnBook(int bookCatalogId, String ssn) {
        List<Integer> bookReturnIds = bookBorrowService.findBookBorrows(bookCatalogId, ssn);
        for(Integer id: bookReturnIds){
            boolean result = iBookReturnRepository.returnBook(id);
            if(result){
                return true;
            }
        }
        return false;
    }
}
