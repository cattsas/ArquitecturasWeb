package com.venta.util;


import com.venta.model.Sale;
import com.venta.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(@Qualifier("saleRepository") SaleRepository saleRepository) {
        return args -> {
            log.info("Preloading"+ saleRepository.save(new Sale(1, 2, "2022/11/10", 10.0, 5)));
            log.info("Preloading"+ saleRepository.save(new Sale(1, 2, "2022/11/11", 10.0, 4)));
            log.info("Preloading"+ saleRepository.save(new Sale(1, 2, "2022/11/12", 10.0, 3)));
            log.info("Preloading"+ saleRepository.save(new Sale(1, 2, "2022/11/12", 10.0, 1)));



        };
    }
}
