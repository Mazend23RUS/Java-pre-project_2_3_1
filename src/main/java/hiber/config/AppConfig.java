package hiber.config;


import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;



@Configuration
//@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "hiber")
public class AppConfig {

   @Bean
   public DataSource getDataSource() {
      DriverManagerDataSource dm = new DriverManagerDataSource();
      dm.setDriverClassName("org.postgresql.Driver");
      dm.setUrl("jdbc:postgresql://localhost:5432/postgres");
      dm.setUsername("postgres");
      dm.setPassword("root");

      return dm;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean getEntityManagerBean() {
      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
      em.setDataSource(getDataSource());
      em.setPackagesToScan("hiber.models");


      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      em.setJpaVendorAdapter(vendorAdapter);
      em.setJpaProperties(additionalProperties());

      return em;
   }


   @Bean
   public PlatformTransactionManager transactionManager() {
      JpaTransactionManager tm = new JpaTransactionManager();
//      tm.setEntityManagerFactory(emf);
      tm.setEntityManagerFactory(getEntityManagerBean().getObject());

      return tm;
   }

   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
   }


   Properties additionalProperties(){
      Properties properties = new Properties();
      properties.setProperty("hibernate.show_sql", "hibernate.show_sql");
      properties.setProperty("hibernate.hbm2ddl.auto", "validate");
      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
      properties.setProperty("hibernate.transaction.jta.platform", "org.hibernate.service.jta.platform");

      return properties;
   }

   //   @Autowired
//   private Environment env;

//   @Bean
//   public DataSource getDataSource() {
//      DriverManagerDataSource dataSource = new DriverManagerDataSource();
//      dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//      dataSource.setUrl(env.getProperty("spring.datasource.db.url"));
//      dataSource.setUsername(env.getProperty("spring.datasource.db.username"));
//      dataSource.setPassword(env.getProperty("spring.datasource.db.password"));
//      return dataSource;
//   }

//   @Bean
//   public LocalSessionFactoryBean getSessionFactory() {
//      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//      factoryBean.setDataSource(getDataSource());
//
//      Properties props=new Properties();
//      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//
//      factoryBean.setHibernateProperties(props);
////      factoryBean.setAnnotatedClasses(Car.class);
//      return factoryBean;
//   }
//   @Bean
//   public HibernateTransactionManager getTransactionManager() {
//      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//      transactionManager.setSessionFactory(getSessionFactory().getObject());
//      return transactionManager;
//   }

//   public void onStartUp(ServletContext servletContext) {
//      AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//      rootContext.register(ApplicationContext.class);
//
//      servletContext.addListener(new ContextLoaderListener(rootContext));
//   }

//   @Override
//   protected Class<?>[] getRootConfigClasses () {
//      return new Class[0];
//   }
//
//   @Override
//   protected Class<?>[] getServletConfigClasses () {
//      return new Class[0];
//   }
//
//   @Override
//   protected String[] getServletMappings () {
//      return new String[0];
//   }

//   @Autowired
//   private Environment env;
//
//   @Bean
//   public static PropertySourcesPlaceholderConfigurer configurer() {
//      return new PropertySourcesPlaceholderConfigurer();
//   }
//
//   @Bean
//   public DataSource getDataSource() {
//      DriverManagerDataSource dataSource = new DriverManagerDataSource();
//      dataSource.setDriverClassName(env.getProperty("db.driver"));
//      dataSource.setUrl(env.getProperty("db.url"));
//      dataSource.setUsername(env.getProperty("db.username"));
//      dataSource.setPassword(env.getProperty("db.password"));
//      return dataSource;
//   }
//
//   @Bean
//   public LocalSessionFactoryBean getSessionFactory() {
//      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//      factoryBean.setDataSource(getDataSource());
//
//      Properties props=new Properties();
//      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//
//      factoryBean.setHibernateProperties(props);
//      factoryBean.setAnnotatedClasses(Car.class);
//      return factoryBean;
//   }
//
//   @Bean
//   public HibernateTransactionManager getTransactionManager() {
//      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//      transactionManager.setSessionFactory(getSessionFactory().getObject());
//      return transactionManager;
//   }


}
