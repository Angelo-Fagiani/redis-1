package it.develhope.redis1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan
public class Redis1Application {

	public static void main(String[] args) {
		SpringApplication.run(Redis1Application.class, args);
	}

}
