package demo.product;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import demo.product.model.Product;
import demo.product.repo.ProductRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductApplication {


	@Bean
	CommandLineRunner runner(ProductRepository repo) {
		return args -> {
			Arrays.asList("iPhone 6S, Galaxy S7, Moto X Play, Macbook Pro'13".split(","))
					.forEach(x -> repo.save(new Product(x)));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}