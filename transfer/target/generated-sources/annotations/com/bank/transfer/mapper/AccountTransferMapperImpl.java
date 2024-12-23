package com.bank.transfer.mapper;

import com.bank.transfer.dto.AccountTransferDTO;
import com.bank.transfer.entity.AccountTransfer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T19:37:24+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class AccountTransferMapperImpl implements AccountTransferMapper {

    @Override
    public AccountTransferDTO accountTransferToAccountTransferDTO(AccountTransfer accountTransfer) {
        if ( accountTransfer == null ) {
            return null;
        }

        AccountTransferDTO.AccountTransferDTOBuilder accountTransferDTO = AccountTransferDTO.builder();

        accountTransferDTO.id( accountTransfer.getId() );
        accountTransferDTO.accountNumber( accountTransfer.getAccountNumber() );
        accountTransferDTO.amount( accountTransfer.getAmount() );
        accountTransferDTO.purpose( accountTransfer.getPurpose() );
        accountTransferDTO.accountDetailsId( accountTransfer.getAccountDetailsId() );

        return accountTransferDTO.build();
    }

    @Override
    public AccountTransfer accountTransferDTOToAccountTransfer(AccountTransferDTO accountTransferDTO) {
        if ( accountTransferDTO == null ) {
            return null;
        }

        AccountTransfer.AccountTransferBuilder accountTransfer = AccountTransfer.builder();

        accountTransfer.id( accountTransferDTO.getId() );
        accountTransfer.accountNumber( accountTransferDTO.getAccountNumber() );
        accountTransfer.amount( accountTransferDTO.getAmount() );
        accountTransfer.purpose( accountTransferDTO.getPurpose() );
        accountTransfer.accountDetailsId( accountTransferDTO.getAccountDetailsId() );

        return accountTransfer.build();
    }

    @Override
    public List<AccountTransferDTO> accountTransferListToDTOList(List<AccountTransfer> accountTransfers) {
        if ( accountTransfers == null ) {
            return null;
        }

        List<AccountTransferDTO> list = new ArrayList<AccountTransferDTO>( accountTransfers.size() );
        for ( AccountTransfer accountTransfer : accountTransfers ) {
            list.add( accountTransferToAccountTransferDTO( accountTransfer ) );
        }

        return list;
    }
}
