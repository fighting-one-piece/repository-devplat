package org.cisiondata.modules.bootstrap.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.CustomSqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:mybatis/mybatis.properties")
@EnableTransactionManagement
@AutoConfigureAfter(DataBaseConfiguration.class)
//@MapperScan(basePackages = "org.cisiondata.modules.**.dao") 
public class MyBatisConfiguration implements EnvironmentAware {
	
	@Resource(name = "dataSource")
	private DataSource dataSource = null;
	
	private RelaxedPropertyResolver propertyResolver = null;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");  
	}  
	
	/** DataSource配置 */  
	/**
    @Bean  
    @ConfigurationProperties(prefix="spring.datasource")  
    public DataSource dataSource() {
        return new org.apache.tomcat.jdbc.pool.DataSource();  
    } 
    **/
    
    /** SqlSeesion配置 */  
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {  
        SqlSessionFactoryBean sqlSessionFactoryBean = new CustomSqlSessionFactoryBean();  
        sqlSessionFactoryBean.setDataSource(dataSource);  
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(); 
        DefaultResourceLoader loader = new DefaultResourceLoader();
        sqlSessionFactoryBean.setConfigLocation(loader.getResource(propertyResolver.getProperty("configLocation")));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(propertyResolver.getProperty("mapperLocations")));  
        /**
        sqlSessionFactoryBean.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
        **/
        return sqlSessionFactoryBean.getObject();  
    }  
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean  
    public PlatformTransactionManager transactionManager() {  
        return new DataSourceTransactionManager(dataSource);  
    }
	
}
