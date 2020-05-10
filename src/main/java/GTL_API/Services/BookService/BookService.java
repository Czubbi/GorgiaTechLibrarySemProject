package GTL_API.Services.BookService;

import GTL_API.Models.CreationModels.BookCreation;
import GTL_API.Models.Entities.BookEntity;
import GTL_API.Models.ReturnModels.BookReturn;
import GTL_API.Models.UpdateModels.BookUpdate;
import GTL_API.Repositories.BookCatalogRepository.IBookCatalogRepositoryCustom;
import GTL_API.Repositories.BookRepository.IBookRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService implements IBookService {

    private IBookRepositoryCustom iBookRepositoryCustom;

    private IBookCatalogRepositoryCustom iBookCatalogRepositoryCustom;

    private ModelMapper modelMapper;

    @Autowired
    public void setIBookCatalogRepositoryCustom(IBookCatalogRepositoryCustom iBookCatalogRepositoryCustom) {
        this.iBookCatalogRepositoryCustom = iBookCatalogRepositoryCustom;
    }

    @Autowired
    public void setIBookRepositoryCustom(IBookRepositoryCustom iBookRepositoryCustom) {
        this.iBookRepositoryCustom = iBookRepositoryCustom;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookReturn> getAllBooks() {
        return iBookRepositoryCustom.getAllBooks();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BookReturn addBook(BookCreation bookEntity) {
        BookReturn added = iBookRepositoryCustom.addBook(modelMapper.map(bookEntity, BookEntity.class));
        return added;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BookReturn updateBook(BookUpdate bookEntity) {
        BookReturn updated = iBookRepositoryCustom.updateBook(modelMapper.map(bookEntity, BookEntity.class));
        return updated;
    }

    @Override
    public BookReturn findBook(String isbn) {
        return iBookRepositoryCustom.findBook(isbn);
    }

    @Override
    public List<BookReturn> findBooksByTitle(String title) {
        return iBookRepositoryCustom.findBooksByTitle(title);
    }

    @Override
    public List<BookReturn> findBooksByAuthor(String author) {
        return iBookRepositoryCustom.findBooksByAuthor(author);
    }

    @Override
    public boolean borrowingBookDecrease(String isbn) {
        return iBookRepositoryCustom.borrowingBookDecrease(isbn);
    }

    @Override
    public boolean returningBookIncrease(String isbn) {
        return iBookRepositoryCustom.returningBookIncrease(isbn);
    }

}
