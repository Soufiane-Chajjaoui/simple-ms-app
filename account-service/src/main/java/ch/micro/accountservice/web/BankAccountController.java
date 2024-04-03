package ch.micro.accountservice.web;

import ch.micro.accountservice.clients.CustomerAccount;
import ch.micro.accountservice.entities.BankAccount;
import ch.micro.accountservice.models.Customer;
import ch.micro.accountservice.repository.BankAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class BankAccountController {
    public final CustomerAccount customerAccount;
    public final BankAccountRepo bankAccountRepo;
    @GetMapping
    public List<BankAccount> getAccounts(){
        return this.bankAccountRepo.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getAccount(@PathVariable Long id){
        BankAccount bankAccount = this.bankAccountRepo.findById(id).get();

        Customer customer = this.customerAccount.getCustomer(bankAccount.getCustomerID());

        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
