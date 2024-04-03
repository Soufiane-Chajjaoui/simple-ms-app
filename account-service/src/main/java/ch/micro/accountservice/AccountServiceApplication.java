package ch.micro.accountservice;

import ch.micro.accountservice.entities.BankAccount;
import ch.micro.accountservice.enums.AccountType;
import ch.micro.accountservice.repository.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner lineRunner(BankAccountRepo bankAccountRepository){
		return args -> {
			BankAccount account1 = BankAccount.builder()
					.balance(1000)
					.type(AccountType.CURRENT_ACCOUNT)
					.customerID(4L)
					.build();
			bankAccountRepository.save(account1);

			BankAccount account2 = BankAccount.builder()
					.balance(2000)
					.type(AccountType.SAVING_ACCOUNT)
					.customerID(3L)
					.build();
			bankAccountRepository.save(account2);

			BankAccount account3 = BankAccount.builder()
					.balance(3000)
					.type(AccountType.SAVING_ACCOUNT)
					.customerID(1L)
					.build();
			bankAccountRepository.save(account3);

			BankAccount account4 = BankAccount.builder()
					.balance(4000)
					.customerID(2L)
					.type(AccountType.CURRENT_ACCOUNT)
					.build();
			bankAccountRepository.save(account4);
        };
	}

}
