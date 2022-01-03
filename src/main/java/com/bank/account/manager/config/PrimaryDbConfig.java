package com.bank.account.manager.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "PrimaryDbEntityManagerFactory", 
transactionManagerRef = "PrimaryDBTransactionManager",basePackages = {"${primary.datasource.repobasepackage}" })
public class PrimaryDbConfig {
	

	@Value("${primary.datasource.username}")
	private String dbUserName;
	@Value("${primary.datasource.password}")
	private String dbPassword;
	@Value("${primary.datasource.url}")
	private String dbUrl;
	@Value("${primary.datasource.driver-class-name}")
	private String dbDriverClass;
	@Value("${primary.datasource.maxActive}")
	private int maxActive;
	@Value("${primary.datasource.maxIdle}")
	private int maxIdle;
	@Value("${primary.datasource.minIdle}")
	private int minIdle;
	@Value("${primary.datasource.initialSize}")
	private int initialSize;
	@Value("${primary.datasource.maxWait}")
	private int maxWait;
	@Value("${primary.datasource.entityClassPackage}")
	private String entityClassPackage;
	@Value("${primary.datasource.showSQL}")
	private String showSql;
	
	private EntityManager entityManager;
	
	/**
	 * Primary because if we have activated embedded databases, we do not want
	 * the application to connect to an external database.
	 * 
	 * @return dataSource which is object of DataSource
	 */
	@Bean(name = "PrimaryDbSource")
	@ConditionalOnProperty(value="primary.datasource.required",  havingValue = "Y", matchIfMissing = false)
	@Primary
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dbDriverClass);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		dataSource.setMaxTotal(maxActive);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMinIdle(minIdle);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxWaitMillis(maxWait);
		return dataSource;
	}

	/**
	 * Description: This method manages data sources
	 * 
	 * @param builder
	 *            EntityManagerFactoryBuilder object
	 * @param dataSource
	 *            DataSource object
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean(name = "PrimaryDbEntityManagerFactory")
	@ConditionalOnProperty(value="primary.datasource.required",  havingValue = "Y", matchIfMissing = false)
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("PrimaryDbSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages(entityClassPackage)
				.persistenceUnit("PersistanceUnit").properties(jpaProperties()).build();
	}

	/**
	 * Description: This method performs database transactions
	 * 
	 * @param PrimaryDbEntityManagerFactory
	 *            EntityManagerFactory object
	 * @return PlatformTransactionManager
	 */
	@Primary
	@Bean(name = "PrimaryDBTransactionManager")
	@ConditionalOnProperty(value="primary.datasource.required",  havingValue = "Y", matchIfMissing = false)
	public PlatformTransactionManager transactionManager(
			@Qualifier("PrimaryDbEntityManagerFactory") EntityManagerFactory dbEntityManagerFactory) {
		this.entityManager = dbEntityManagerFactory.createEntityManager();
		return new JpaTransactionManager(dbEntityManagerFactory);
	}

	private Map<String, String> jpaProperties() {
		Map<String, String> jpaPropertiesMap = new HashMap<>();
		jpaPropertiesMap.put("show.sql", showSql);
		return jpaPropertiesMap;
	}

	
	/**
	 * @return EntityManager
	 */
	public EntityManager getEntityManager(){
		return this.entityManager;
	}

}
