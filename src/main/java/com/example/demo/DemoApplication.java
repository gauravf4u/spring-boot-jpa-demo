package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class DemoApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext
				applicationContext = new SpringApplicationBuilder(DemoApplication.class).
																																										properties(
																																												"spring.config.location:classpath:fip-application-default.properties,optional:classpath:fip-application.properties,classpath:application.properties,optional:classpath:fip-application-override.properties,optional:file:${fip.config.dir}/fip-application.properties")
																																								.build()
																																								.run(args);

	}
}
