package dev.will.ecommerce.shopcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableCaching
@SpringBootApplication
public class ShopcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopcartApplication.class, args);
	}

}
