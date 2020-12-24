package com.microservices.fp;

import com.microservices.fp.entity.Product;
import com.microservices.fp.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class FpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FpApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"Computer Desk Top HP",900));
            productRepository.save(new Product(null,"Printer Epson",80));
            productRepository.save(new Product(null,"MacBook Pro Lap Top",1800));
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
