package pl.fastus.sdaspringnowy.domain.account;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Tom - 18.04.2021
 */
@Data
@Accessors(chain = true)
public class CreateBankAccountRequest {

    private String pesel;
    private String owner;
    private String email;
}
