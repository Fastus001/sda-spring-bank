package pl.fastus.sdaspringnowy.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom - 18.04.2021
 */
@RequiredArgsConstructor
@Component
public class BankAccountMockDataInitializer {

    private final BankAccountService service;

    @PostConstruct
    private void initializeData(){
        getBankAccountRequests().forEach(service::createBankAccount);

        service.addBalanceToBankAccount(1L, BigDecimal.valueOf(1250));
    }

    private List<CreateBankAccountRequest> getBankAccountRequests() {
        List<CreateBankAccountRequest> requests = new ArrayList<>();
        requests.add(new CreateBankAccountRequest()
                .setOwner("Tomek")
                .setEmail("tkarczmarzyk@gmail.com")
                .setPesel("80101504996"));

        requests.add(new CreateBankAccountRequest()
                .setOwner("Ika")
                .setEmail("ika@gmail.com")
                .setPesel("83101504996"));

        requests.add(new CreateBankAccountRequest()
                .setOwner("Maja")
                .setEmail("maja@gmail.com")
                .setPesel("15262504996"));
        return requests;
    }
}
