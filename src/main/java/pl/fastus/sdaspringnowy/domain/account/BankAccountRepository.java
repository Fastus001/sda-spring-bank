package pl.fastus.sdaspringnowy.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Tom - 18.04.2021
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    List<BankAccount> findAllByIsActiveTrue();
}
