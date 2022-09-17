package org.jee.ecommerce.database.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

import java.util.Properties;
import java.util.TimeZone;

@Configuration
public class DatabaseConfiguration {

    @Value("${database.url}")
    String url;

    @Value("${database.driver}")
    String driver;

    @Value("${database.host}")
    String host;

    @Value("${database.port}")
    Long port;

    @Value("${database.name}")
    String name;

    @Value("${database.username}")
    String username;

    @Value("${database.schema}")
    String schema;

    @Value("${database.password}")
    String password;

    @Value("${database.timezone}")
    String timezone;

    @Value("${database.hibernate.ddl}")
    boolean ddl;

    @Value("${database.hibernate.showsql}")
    boolean showSQL;

    @Value("${database.connexion.max.active}")
    Integer active;

    @Value("${database.connexion.min.idle}")
    Integer idle;

    @Value("${database.connexion.init.size}")
    Integer size;

    @Bean(name = "dataSource")
    public DataSource serviceDataSource() {
        DriverManagerDataSource ds = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
		ds.setPassword(password);
        TimeZone tzone = TimeZone.getTimeZone(timezone);
        TimeZone.setDefault(tzone);
        return ds;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean serviceEntityManagerFactory(DataSource dataSource,
                                                                              JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("org.jee.ecommerce");
        Properties props = new Properties();
        props.put("hibernate.enable_lazy_load_no_trans", "true");
        props.put("hibernate.id.new_generator_mappings", "true");
        props.put("hibernate.default_schema", schema);
        if (ddl) {
            props.put("hibernate.hbm2ddl.auto", "update");
        }
        lef.setJpaProperties(props);
        return lef;
    }

    @Bean
    public JpaVendorAdapter serviceJPAVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(showSQL);
        hibernateJpaVendorAdapter.setGenerateDdl(ddl);
        hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                serviceEntityManagerFactory(serviceDataSource(), serviceJPAVendorAdapter()).getObject());
        return transactionManager;
    }
}
