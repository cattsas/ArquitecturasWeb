package com.producto.util;


import com.producto.model.Product;
import com.producto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(@Qualifier("productRepository") ProductRepository productRepository) {
        return args -> {
            log.info("Preloading"+ productRepository.save(new Product("Telefono", 2000)));
            log.info("Preloading"+ productRepository.save(new Product("PC", 2500)));


        };
    }
}
