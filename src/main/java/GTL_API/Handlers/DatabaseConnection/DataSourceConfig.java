package GTL_API.Handlers.DatabaseConnection;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    private final String PACKAGE_SCAN = "GTL_API.Handlers";

    @Primary
    @Bean(name = "mainDataSource")
    public DataSource dataSourceMain() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;database=Giorgia_Tech_Library");
        dataSource.setUsername("sa");
        dataSource.setPassword("90809988Qwe");
        return dataSource;
    }

    @Bean(name = "librarianDataSource")
    public static DataSource dataSourceLibrarian(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;database=Giorgia_Tech_Library");
        dataSource.setUsername("librarian");
        dataSource.setPassword("userOnePassword");
        return dataSource;
    }

    @Bean(name = "studentDataSource")
    public DataSource dataSourceStudent(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;database=Giorgia_Tech_Library");
        dataSource.setUsername("student");
        dataSource.setPassword("studentPassword");
        return dataSource;
    }

    @Bean(name = "chefLibrarianDataSource")
    public DataSource dataSourceChefLibrarian(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\\\MSSQLSERVER:1433;database=Giorgia_Tech_Library");
        dataSource.setUsername("chefLibrarian");
        dataSource.setPassword("chefLibrarianPassword");
        return dataSource;
    }

    @Bean(name="multiRoutingDataSource")
    public DataSource multiRoutingDataSource(){
        Map<Object, Object> targetDataSource= new HashMap<>();
        targetDataSource.put(DBTypeEnum.MAIN,dataSourceMain());
        targetDataSource.put(DBTypeEnum.LIBRARIAN, dataSourceLibrarian());
        targetDataSource.put(DBTypeEnum.STUDENT, dataSourceStudent());
        targetDataSource.put(DBTypeEnum.CHEF_LIBRARIAN, dataSourceChefLibrarian());
        RoutingDataSource routingDataSource = new RoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(dataSourceMain());
        routingDataSource.setTargetDataSources(targetDataSource);
        return routingDataSource;
    }

    @Bean(name="multiEntityManager")
    public LocalContainerEntityManagerFactoryBean multiEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(multiRoutingDataSource());
        em.setPackagesToScan(PACKAGE_SCAN);
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    @Bean(name="multiTransactionManager")
    public PlatformTransactionManager multiTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(multiEntityManager().getObject());
        return transactionManager;
    }

    @Primary
    @Bean(name = "dbSessionFactory")
    public LocalSessionFactoryBean dbSessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(multiRoutingDataSource());
        sessionFactoryBean.setPackagesToScan(PACKAGE_SCAN);
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }


    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        return properties;
    }
    @Bean
    @Primary
    public EntityManager entityManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GiorgiaTechLibrary_Persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
