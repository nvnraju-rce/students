package com.northstar.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.northstar.banking.auth.DigitalUser;
import com.northstar.banking.auth.DigitalUserRepository;

@SpringBootApplication
@EntityScan(basePackageClasses = DigitalUser.class)
@EnableJpaRepositories(basePackageClasses = DigitalUserRepository.class)
public class BankingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankingApplication.class, args);
    }
}
