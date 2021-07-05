package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement // enable transaction management in application
@EnableJpaRepositories(
    basePackages = "com.example.demo",
    entityManagerFactoryRef = "multiEntityManager",
    transactionManagerRef = "multiTransactionManager"
)
public class DatabaseConfiguration {

  private final String PACKAGE_SCAN = "com.example.demo";
  @Autowired
  private AppConfigImpl appConfig;

  @Bean(name = "multiRoutingDataSource")
  public DataSource multiRoutingDataSource() {
    //multirouting datasource extends AbstractRouting datasource and is a means to route between databases when application makes use of n number of databases
    List<DBInfo> dbInfoList = appConfig.findConfiguredDataSources();
    Map<Object, Object> targetDataSources = new HashMap<>();
    dbInfoList.stream().forEach(dbInfo -> {
                                  targetDataSources.put(dbInfo.getClientName(),
                                                        buildDataSource(dbInfo.getUrl(), dbInfo.getUserName(), dbInfo.getDbPassword()));
                                }

        );
    MultiRoutingDataSource multiRoutingDataSource = new MultiRoutingDataSource();
    Object commonDataSource = targetDataSources.get("COMMONS");
    multiRoutingDataSource.setDefaultTargetDataSource(
        commonDataSource);
    multiRoutingDataSource.setTargetDataSources(targetDataSources);
    return multiRoutingDataSource;
  }

  @Bean(name = "multiEntityManager")
  public LocalContainerEntityManagerFactoryBean multiEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(multiRoutingDataSource());
    em.setPackagesToScan(PACKAGE_SCAN);
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    em.setJpaProperties(hibernateProperties());
    return em;
  }

  @Bean(name = "multiTransactionManager")
  public PlatformTransactionManager multiTransactionManager() {
    JpaTransactionManager transactionManager
        = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(
        multiEntityManager().getObject());
    return transactionManager;
  }

  @Primary
  @Bean(name = "dbSessionFactory")
  public LocalSessionFactoryBean dbSessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(multiRoutingDataSource());
    sessionFactoryBean.setPackagesToScan(PACKAGE_SCAN);
    sessionFactoryBean.setHibernateProperties(hibernateProperties());
    return sessionFactoryBean;
  }
  public DataSource buildDataSource(String url, String userName, String password){
    //dynamic creation of datasource configurations read from app configuration
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    dataSourceBuilder.url(url);
    dataSourceBuilder.username(userName);
    dataSourceBuilder.password(password);
    return dataSourceBuilder.build();
  }
  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.show_sql", true);
    properties.put("hibernate.format_sql", true);
    properties.put("hibernate.dialect","org.hibernate.dialect.SQLServer2012Dialect");
    return properties;
  }

  private Properties loadProperties(){
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("fip-application.properties");
    Properties prop = new Properties();
    if(inputStream == null){
      System.out.println("App property file not available");
      return prop;
    }
    try {
      prop.load(inputStream);
    }
    catch(Exception e){
      throw new RuntimeException(e);
    }
    prop.putAll(System.getProperties());
    return  prop;
  }


}
