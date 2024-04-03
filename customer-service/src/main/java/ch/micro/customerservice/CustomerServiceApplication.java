package ch.micro.customerservice;

import ch.micro.customerservice.GlobalConfig.GlobalConfig;
import ch.micro.customerservice.entities.Customer;
import ch.micro.customerservice.repository.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner lineRunner(CustomerRepo customerRepo){
        return args -> {
            Customer customer1 = Customer.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@example.com")
                    .build();
            customerRepo.save(customer1);

            Customer customer2 = Customer.builder()
                    .firstName("Jane")
                    .lastName("Doe")
                    .email("jane.doe@example.com")
                    .build();
            customerRepo.save(customer2);

            Customer customer3 = Customer.builder()
                    .firstName("Alice")
                    .lastName("Smith")
                    .email("alice.smith@example.com")
                    .build();
            customerRepo.save(customer3);

            Customer customer4 = Customer.builder()
                    .firstName("Bob")
                    .lastName("Johnson")
                    .email("bob.johnson@example.com")
                    .build();
            customerRepo.save(customer4);
        } ;
    }

}
