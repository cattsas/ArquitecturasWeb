package com.client.util;


import com.client.model.Client;
import com.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(@Qualifier("clientRepository") ClientRepository clientRepository) {
        return args -> {
            log.info("Preloading"+ clientRepository.save(new Client("Juan", "Gomez")));
            log.info("Preloading"+ clientRepository.save(new Client("Carlos", "Perez")));


        };
    }
}
