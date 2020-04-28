package GTL_API.Repositories;

import GTL_API.MainApplicationClass;
import GTL_API.Models.ReturnModels.CoverTypeReturn;
import GTL_API.TestDataSourceConfig;
import GTL_API.Repositories.CoverTypeRepository.ICoverTypeRepositoryCustom;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplicationClass.class, TestDataSourceConfig.class})
public class CoverTypeRepositoryTest {

    @Autowired
    private ICoverTypeRepositoryCustom coverTypeRepository;

    @Test
    public void findCoverTypeByName_thenReturnCoverTypeReturn(){
        CoverTypeReturn found = coverTypeRepository.findCoverTypeByName("Paperback");

        Assert.assertEquals("Paperback", found.getCoverType());
    }


}
