package pl.fastus.sdaspringnowy.domain.account;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Tom - 18.04.2021
 */
@Data
@Accessors(chain = true)
@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String pesel;
    private String owner;
    private String email;
    private BigDecimal balance;
    private Boolean isActive;

    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
