package GTL_API.Handlers;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSourceTest() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;database=Giorgia_Tech_Library");
        dataSource.setUsername("sa");
        dataSource.setPassword("90809988Qwe");
        return dataSource;
    }

    @Bean
    public DataSource dataSourceLibrarian(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;database=Giorgia_Tech_Library");
        dataSource.setUsername("librarian");
        dataSource.setPassword("userOnePassword");
        return dataSource;
    }

    @Bean
    public DataSource dataSourceStudent(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;database=Giorgia_Tech_Library");
        dataSource.setUsername("student");
        dataSource.setPassword("studentPassword");
        return dataSource;
    }

    @Bean
    public DataSource dataSourceChefLibrarian(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;database=Giorgia_Tech_Library");
        dataSource.setUsername("chefLibrarian");
        dataSource.setPassword("chefLibrarianPassword");
        return dataSource;
    }

    @Bean
    @Primary
    public EntityManager entityManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GiorgiaTechLibrary_Persistence-Test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
