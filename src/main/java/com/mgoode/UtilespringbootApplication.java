package com.mgoode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtilespringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(UtilespringbootApplication.class, args);
	}


//	@Bean
//	public DataSource dataSource() {
//		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//		DataSource dataSource = dataSourceLookup.getDataSource("jdbc:ucanaccess://C:/Users/michaelgoode/Documents/Utile Engineering/DB/Gases.mdb");
//		return dataSource;
//	}
}