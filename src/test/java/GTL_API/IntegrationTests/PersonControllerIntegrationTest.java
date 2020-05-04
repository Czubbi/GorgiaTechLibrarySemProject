package GTL_API.IntegrationTests;

import GTL_API.MainApplicationClass;
import GTL_API.TestDataSourceConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplicationClass.class, TestDataSourceConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PersonControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    private String token;

    @Before
    public void login() throws Exception{
        MvcResult result = mvc.perform(post("/gtl/auth/login")
                .content("{\"login\": \"loginMaster\", \"password\": \"password\"}")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        token = result.getResponse().getContentAsString();
    }

    @Test
    public void findPersonBySsn() throws Exception {
        mvc.perform(get("/gtl/person/findbyssn/000-71-3764")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"ssn\": \"000-71-3764\",\n" +
                        "    \"firstName\": \"Bart\",\n" +
                        "    \"middleName\": \"Aaron Prince\",\n" +
                        "    \"lastName\": \"Bennet\",\n" +
                        "    \"homeAddressId\": 3052,\n" +
                        "    \"campusAddressId\": 3052,\n" +
                        "    \"loanDuration\": 21,\n" +
                        "    \"cardNumberId\": 1209995103,\n" +
                        "    \"personTypeId\": 102084}"));
    }

    @Test
    public void findPersonWhichDoesNotExistBySsn() throws Exception {
        mvc.perform(get("/gtl/person/findbyssn/1")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Person with ssn: 1 was not found"));
    }

    @Test
    public void findPersonByName() throws Exception {
        mvc.perform(get("/gtl/person/findbyname/Bart/Bennet")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"ssn\": \"000-71-3764\",\n" +
                        "    \"firstName\": \"Bart\",\n" +
                        "    \"middleName\": \"Aaron Prince\",\n" +
                        "    \"lastName\": \"Bennet\",\n" +
                        "    \"homeAddressId\": 3052,\n" +
                        "    \"campusAddressId\": 3052,\n" +
                        "    \"loanDuration\": 21,\n" +
                        "    \"cardNumberId\": 1209995103,\n" +
                        "    \"personTypeId\": 102084}"));
    }

    @Test
    public void findPersonByCard() throws Exception {
        mvc.perform(get("/gtl/person/findbycard/1209995103")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"ssn\": \"000-71-3764\",\n" +
                        "    \"firstName\": \"Bart\",\n" +
                        "    \"middleName\": \"Aaron Prince\",\n" +
                        "    \"lastName\": \"Bennet\",\n" +
                        "    \"homeAddressId\": 3052,\n" +
                        "    \"campusAddressId\": 3052,\n" +
                        "    \"loanDuration\": 21,\n" +
                        "    \"cardNumberId\": 1209995103,\n" +
                        "    \"personTypeId\": 102084}"));
    }
}
