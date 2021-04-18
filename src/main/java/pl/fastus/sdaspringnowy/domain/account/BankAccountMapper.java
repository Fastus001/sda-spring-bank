package pl.fastus.sdaspringnowy.domain.account;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by Tom - 18.04.2021
 */
@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    @Mapping(source = "owner", target = "owner")
    BankAccount mapToBankAccount(CreateBankAccountRequest request);

    @Mapping(source = "owner", target = "owner")
    AccountListView mapBankAccountToAccountListView(BankAccount bankAccount);
}
