package ch.micro.accountservice.clients;

import ch.micro.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerAccount  {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService" , fallbackMethod = "getDefualtCustomer" )
    Customer getCustomer(@PathVariable Long id);

    default Customer getDefualtCustomer(Long id , Exception exception){

        Customer customer = new Customer();
        customer.setId(id);
        customer.setEmail("Defualt Email");
        customer.setFirstName("defualt FirstName");
        customer.setLastName("defualt LastName");
        return customer;
    }
}
