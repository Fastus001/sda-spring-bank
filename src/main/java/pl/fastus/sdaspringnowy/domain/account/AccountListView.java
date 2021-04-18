package pl.fastus.sdaspringnowy.domain.account;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Tom - 18.04.2021
 */
@Data
public class AccountListView {

    private String owner;
    private BigDecimal balance;
}
