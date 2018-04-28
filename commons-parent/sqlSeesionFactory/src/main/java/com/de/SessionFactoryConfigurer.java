package com.de;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**  
 *
 * @author jensen 
 * @description   ibatis 配置
 * @date 2018/4/29 1:32
 * @param
 * @return 
 */ 
@Configuration
@EnableTransactionManagement
public class SessionFactoryConfigurer implements TransactionManagementConfigurer {

	@Autowired
	private DataSource dataSource;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		@SuppressWarnings("resource")
		ResourcePatternResolver resourcePatternResolver = new ClassPathXmlApplicationContext();
		Resource[] resources = resourcePatternResolver.getResources("classpath*:com/de/**/mybatis/*.xml");
		sqlSessionFactoryBean.setMapperLocations( resources );
		sqlSessionFactoryBean.setDataSource( dataSource );

		Interceptor plugin = new PageInterceptor();
		Properties helperProperties = new Properties();
		helperProperties.setProperty("helperDialect", "mysql");
		plugin.setProperties( helperProperties );
		sqlSessionFactoryBean.setPlugins(new Interceptor[] { plugin } );
		
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
