package GTL_API.Repositories.BookReturnRespository;

import GTL_API.Exceptions.CreationException;
import GTL_API.Exceptions.NotFoundException;
import GTL_API.Exceptions.UnknownException;
import GTL_API.Models.Entities.BookReturnEntity;
import GTL_API.Models.ReturnModels.BookReturnReturn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

@Component
public class BookReturnRepository implements IBookReturnRepositoryCustom {

    private IBookReturnRepository iBookReturnRepository;

    private ModelMapper modelMapper;

    @Autowired
    public void setIBookReturnRepository(IBookReturnRepository iBookReturnRepository) {
        this.iBookReturnRepository = iBookReturnRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookReturnReturn createBookReturn(BookReturnEntity bookReturnEntity) {
        try{
            BookReturnEntity saved = iBookReturnRepository.save(bookReturnEntity);
            return modelMapper.map(saved, BookReturnReturn.class);
        }catch (Exception e){
            throw new CreationException("There was an error while creating a book returning record");
        }
    }
    @Override
    public boolean returnBook(int id) {
        try{
            Optional<BookReturnEntity> found = iBookReturnRepository.findByIdIsAndStatusIsFalse(id);
            if(found.isPresent()){
                BookReturnEntity foundToReturn = found.get();
                foundToReturn.setStatus(true);
                foundToReturn.setPayment(0D);
                Calendar c = Calendar.getInstance();
                foundToReturn.setReturnedDate(new Date(c.getTime().getTime()));
                iBookReturnRepository.save(foundToReturn);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            throw new UnknownException(String.format(
                    "There was an error while finding a book returning record with ID: %d", id));
        }
    }
}
