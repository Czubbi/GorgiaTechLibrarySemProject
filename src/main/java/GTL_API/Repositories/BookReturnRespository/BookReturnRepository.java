package GTL_API.Repositories.BookReturnRespository;

import GTL_API.Exceptions.CreationException;
import GTL_API.Exceptions.NotFoundException;
import GTL_API.Exceptions.UnknownException;
import GTL_API.Models.Entities.BookReturnEntity;
import GTL_API.Models.ReturnModels.BookReturnReturn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public BookReturnReturn returnBook(int id) {
        try{
            Optional<BookReturnEntity> found = iBookReturnRepository.findByIdIs(id);
            if(found.isPresent()){
                return modelMapper.map(found.get(), BookReturnReturn.class);
            }else{
                throw new NotFoundException("Returning record was not found");
            }
        }catch (Exception e){
            throw new UnknownException(String.format(
                    "There was an error while finding a book returning record with ID: %d", id));
        }
    }
}
