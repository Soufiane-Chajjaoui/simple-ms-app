package ch.micro.accountservice.entities;

import ch.micro.accountservice.enums.AccountType;
import ch.micro.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    @CreationTimestamp
    private LocalDateTime createAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;
    private Long customerID;
}
