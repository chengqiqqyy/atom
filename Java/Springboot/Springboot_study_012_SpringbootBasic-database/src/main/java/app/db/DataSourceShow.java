package app.db;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;

@Component
// n实现 Spring Bean 生命周期接口 ApplicationContextAware
public class DataSourceShow implements ApplicationContextAware{
	ApplicationContext ac = null;
	
	//Spring会自动调用这个方法，注入 Spring IOC 容器
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ac = applicationContext;
		DataSource dataSource = ac.getBean(DataSource.class);
		System.out.println("【" + this.getClass().getSimpleName() + "】 Database Type: " + dataSource.getClass().getName() + " ---------- " + dataSource.getClass().getSimpleName());
		HikariConfig hc = new HikariConfig();
		System.out.println("DataSourceClassName: " + hc.getDataSourceClassName());
		System.out.println("DriverClassName: " + hc.getDriverClassName());
		System.out.println("JdbcUrl: " + hc.getJdbcUrl());
		System.out.println("Username: " + hc.getUsername());
		System.out.println("Password: " + hc.getPassword());
		System.out.println("PoolName: " + hc.getPoolName());
		System.out.println("Schema: " + hc.getSchema());
		System.out.println("MinimumIdle: " + hc.getMinimumIdle());
		System.out.println("MaximumPoolSize: " + hc.getMaximumPoolSize());
		System.out.println("MaxLifetime: " + hc.getMaxLifetime());
		System.out.println("ValidationTimeout: " + hc.getValidationTimeout());
		System.out.println("ConnectionTimeout: " + hc.getConnectionTimeout());
		System.out.println("IdleTimeout: " + hc.getIdleTimeout());
		System.out.println("InitializationFailTimeout: " + hc.getInitializationFailTimeout());
		System.out.println("ConnectionInitSql: " + hc.getConnectionInitSql());
		System.out.println("ConnectionTestQuery: " + hc.getConnectionTestQuery());
		System.out.println("DataSourceJNDI: " + hc.getDataSourceJNDI());
		System.out.println("LeakDetectionThreshold: " + hc.getLeakDetectionThreshold());
		System.out.println("DataSourceProperties: " + hc.getDataSourceProperties().toString());
	}
	
}
