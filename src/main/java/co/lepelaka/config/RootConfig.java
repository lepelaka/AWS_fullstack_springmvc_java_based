package co.lepelaka.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.google.gson.Gson;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j;

@Configuration
@ComponentScan({"co.lepelaka.domain", "co.lepelaka.service", "co.lepelaka.task"})
@MapperScan("co.lepelaka.mapper")
@PropertySource({"classpath:/jdbc.properties"})
@Log4j
public class RootConfig {
	
	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.jdbcUrl}")
	private String jdbcUrl;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	
	
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		log.info(config.getDataSourceClassName());
		return config;
	}
	
	@Bean
	public DataSource dataSource() throws IOException {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setTypeAliasesPackage("co.lepelaka.domain");
		return bean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() throws IOException {
		return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public Gson gson() {
		return new Gson();
	}
}
