package pckg.configuration;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "pckg")
@EnableWebMvc
@EnableTransactionManagement
public class SpringConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/standard?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactory =
				new LocalContainerEntityManagerFactoryBean();
		containerEntityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		containerEntityManagerFactory.setDataSource(dataSource());
		containerEntityManagerFactory.setPersistenceUnitName("itemUnit");
		containerEntityManagerFactory.setPackagesToScan("pckg");
		return containerEntityManagerFactory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
