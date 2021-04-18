package pl.fastus.sdaspringnowy.domain.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tom - 18.04.2021
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountController {

    private final BankAccountService service;


    @PutMapping("/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void addBalanceToAccount(@PathVariable Long id, @RequestBody String amount){
        log.info("Received request to add money to the account id {}",id);
        service.addBalanceToBankAccount(id, BigDecimal.valueOf(Double.parseDouble(amount)));
    }

    @GetMapping("/active")
    private List<AccountListView> allActiveBankAccounts(){
        log.info("Received request for all active accounts");
        return service.findAllActiveAccounts();
    }
}
