package GTL_API.Repositories;

import GTL_API.Exceptions.UnknownException;
import GTL_API.MainApplicationClass;
import GTL_API.Models.Entities.BookReturnEntity;
import GTL_API.Repositories.BookReturnRespository.IBookReturnRepository;
import GTL_API.Repositories.BookReturnRespository.IBookReturnRepositoryCustom;
import GTL_API.TestDataSourceConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplicationClass.class, TestDataSourceConfig.class})
public class BookReturnRepositoryTest {

    @Autowired
    private IBookReturnRepositoryCustom iBookReturnRepositoryCustom;

    @Autowired
    private IBookReturnRepository iBookReturnRepository;


    private boolean createBookReturnRecord(){
        BookReturnEntity br = new BookReturnEntity();

        Calendar c = Calendar.getInstance();
        Date estimatedDate = new Date(c.getTime().getTime());

        br.setEstimatedReturnDate(estimatedDate);
        br.setStatus(false);
        br.setPayment(0D);

        BookReturnEntity result = iBookReturnRepository.save(br);
        if(result!=null){
            return true;
        }
        else{
            return false;
        }
    }

    @Test
    public void testReturningBookWithValidData_ShouldReturnTrue(){
        boolean inserted = createBookReturnRecord();
        if(inserted){
            List<BookReturnEntity> records = iBookReturnRepository.findAll();
            int id = records.get(0).getId();
            boolean result = iBookReturnRepositoryCustom.returnBookAndChangeStatus(id);
            Assert.assertTrue(result);
        }else{
            Assert.fail();
        }
        iBookReturnRepository.deleteAllInBatch();
    }

    @Test
    public void testReturningBookWithInvalidData_ShouldThrowException(){
        boolean inserted = createBookReturnRecord();
        if(inserted){
            List<BookReturnEntity> records = iBookReturnRepository.findAll();
            int id = records.get(0).getId();
            try{
                boolean result = iBookReturnRepositoryCustom.returnBookAndChangeStatus(-1);
                Assert.fail();
            } catch (UnknownException ex){
                Assert.assertTrue(true);
            }

        }else{
            Assert.fail();
        }
        iBookReturnRepository.deleteAllInBatch();
    }
}
