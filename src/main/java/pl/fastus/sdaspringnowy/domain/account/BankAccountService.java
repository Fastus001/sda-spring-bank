package pl.fastus.sdaspringnowy.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Created by Tom - 18.04.2021
 */
@RequiredArgsConstructor
@Service
public class BankAccountService {

    private final BankAccountMapper mapper;
    private final BankAccountRepository repository;

    public void createBankAccount(CreateBankAccountRequest request){
        final BankAccount accountToSave = mapper.mapToBankAccount(request);
        accountToSave.setIsActive(Boolean.TRUE)
                .setBalance(BigDecimal.ZERO);

        repository.save(accountToSave);
    }

    @Transactional
    public void addBalanceToBankAccount(Long id, BigDecimal amount){
        final BankAccount bankAccount = repository.findById(id)
                                                .orElseThrow(NoSuchElementException::new);
        final BigDecimal balance = bankAccount.getBalance().add(amount);
        bankAccount.setBalance(balance);
    }

    public List<AccountListView> findAllActiveAccounts() {
        return repository
                .findAllByIsActive(true)
                .stream()
                .map(mapper::mapBankAccountToAccountListView)
                .collect(Collectors.toList());
    }
}
