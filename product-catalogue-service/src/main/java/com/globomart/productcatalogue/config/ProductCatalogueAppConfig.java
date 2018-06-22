/**
 * @author Iswar
 */

package com.globomart.productcatalogue.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ProductCatalogueAppConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	/* public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
	        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

	        ObjectMapper mapper = new ObjectMapper();
	        
	//Registering Hibernate4Module to support lazy objects
	        
	        mapper.registerModule(new Hibernate4Module());

	        messageConverter.setObjectMapper(mapper);
	        return messageConverter;

	    }

	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        //Here we add our custom-configured HttpMessageConverter
	        converters.add(jacksonMessageConverter());
	        super.configureMessageConverters(converters);
	    }*/
	/*@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}*/
	
	/*@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
		bean.setDatabase(Database.H2);
		bean.setGenerateDdl(true);
		return bean;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setJpaVendorAdapter(jpaVendorAdapter);
		bean.setPackagesToScan("com.globomart.productcatalogue");
		return bean;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
}*/
}
