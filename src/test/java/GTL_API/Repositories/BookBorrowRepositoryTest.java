package GTL_API.Repositories;


import GTL_API.Exceptions.CreationException;
import GTL_API.MainApplicationClass;
import GTL_API.Models.Entities.BookBorrowEntity;
import GTL_API.Models.ReturnModels.BookBorrowReturn;
import GTL_API.Repositories.BookBorrowRepository.IBookBorrowRepository;
import GTL_API.Repositories.BookBorrowRepository.IBookBorrowRepositoryCustom;
import GTL_API.TestDataSourceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplicationClass.class, TestDataSourceConfig.class})
public class BookBorrowRepositoryTest {


    @Autowired
    private IBookBorrowRepositoryCustom iBookBorrowRepositoryCustom;

    @Autowired
    private IBookBorrowRepository iBookBorrowRepository;


    private int bookReturnId = 3509;

    private BookBorrowEntity getValidEntity() {
        BookBorrowEntity bb = new BookBorrowEntity();
        bb.setSsn("000-18-3244");
        bb.setBookCatalogId(1);
        return bb;
    }

    private BookBorrowEntity getEntityWithMissingBookCatalogId() {
        BookBorrowEntity bb = new BookBorrowEntity();
        bb.setSsn("000-18-3244");
        return bb;
    }

    private BookBorrowEntity getEntityWithMissingSsn() {
        BookBorrowEntity bb = new BookBorrowEntity();
        bb.setBookCatalogId(1);
        return bb;
    }

    private BookBorrowEntity getEntityWithInvalidSsn() {
        BookBorrowEntity bb = new BookBorrowEntity();
        bb.setSsn("-1");
        bb.setBookCatalogId(1);
        return bb;
    }

    private BookBorrowEntity getEntityWithInvalidBookCatalogId() {
        BookBorrowEntity bb = new BookBorrowEntity();
        bb.setSsn("000-18-3244");
        bb.setBookCatalogId(-5);
        return bb;
    }

    @Test
    public void testAddingBookBorrowWithValidData_ShouldAdd() {
        BookBorrowReturn result = iBookBorrowRepositoryCustom.createBookBorrow(getValidEntity(), bookReturnId);
        System.out.println(result.getBookReturnId());
        Assert.assertEquals(iBookBorrowRepository.findById(result.getId()).get().getSsn(), "000-18-3244");
        iBookBorrowRepository.deleteById(result.getId());

    }

    @Test
    public void testAddingBookBorrowWithBlankObject_ShouldThrowNullPointerException() {
        try{
            iBookBorrowRepositoryCustom.createBookBorrow(null, bookReturnId);
            Assert.fail();
        }catch (NullPointerException exception){
            Assert.assertTrue(true);
        }
    }


    @Test
    public void testAddingBookBorrowWithObjectMissingSsn_ShouldThrowDataIntegrityViolationException() {
        try {
            iBookBorrowRepositoryCustom.createBookBorrow(getEntityWithMissingSsn(), bookReturnId);
            Assert.fail();
        } catch (CreationException exception) {
            Assert.assertTrue(true);

        }
    }

    @Test
    public void testAddingBookBorrowWithObjectInvalidSsn_ShouldFail() {
        try {
            iBookBorrowRepositoryCustom.createBookBorrow(getEntityWithInvalidSsn(), bookReturnId);
            Assert.fail();
        } catch (CreationException exception) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testAddingBookBorrowWithObjectMissingBookCatalogId_ShouldThrowDataIntegrityViolationException() {
        try {
            iBookBorrowRepositoryCustom.createBookBorrow(getEntityWithMissingBookCatalogId(), bookReturnId);
            Assert.fail();
        } catch (CreationException exception) {
            Assert.assertTrue(true);

        }
    }

    @Test
    public void testAddingBookBorrowWithObjectInvalidBookCatalogId_ShouldThrowDataIntegrityViolationException() {
        try {
            iBookBorrowRepositoryCustom.createBookBorrow(getEntityWithInvalidBookCatalogId(), bookReturnId);
            Assert.fail();
        } catch (CreationException exception) {
            Assert.assertTrue(true);

        }
    }


}
