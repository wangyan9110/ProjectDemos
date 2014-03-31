package org.yywang;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

public class DataSourceTest {

	@Test
	public void testDataSource(){
		ClassPathXmlApplicationContext cpxac=new ClassPathXmlApplicationContext("classpath:config/applicationContext_datasource.xml");
		JdbcTemplate jdbcTemplate=(JdbcTemplate)cpxac.getBean("jdbcTemplate");
		String insertSql="insert into test(id,name) values(1,'test')";
		jdbcTemplate.execute(insertSql);
	}
	
}
