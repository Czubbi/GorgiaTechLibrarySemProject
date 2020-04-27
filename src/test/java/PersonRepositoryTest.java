import GTL_API.MainApplicationClass;
import GTL_API.Models.ReturnModels.PersonReturn;
import GTL_API.Repositories.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplicationClass.class)
public class PersonRepositoryTest {

    private PersonReturn personReturn;

    @Autowired
    private Person personRepository;


    @Test
    public void whenFindBySsn_thenReturnPersonReturn(){

        PersonReturn found = personRepository.findPersonBySsn("000-71-3764");

        Assert.assertEquals("000-71-3764", found.getSsn());
    }
}
