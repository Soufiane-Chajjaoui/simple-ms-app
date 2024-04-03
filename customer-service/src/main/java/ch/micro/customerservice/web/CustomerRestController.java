package ch.micro.customerservice.web;

import ch.micro.customerservice.entities.Customer;
import ch.micro.customerservice.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerRepo customerRepo;
    @GetMapping
    public List<Customer> customerList(){
        return customerRepo.findAll();
    }
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id ){
        return customerRepo.findById(id).get();
    }
}
