package com.bank.transfer.mapper;

import com.bank.transfer.dto.CardTransferDTO;
import com.bank.transfer.entity.CardTransfer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T17:18:01+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class CardTransferMapperImpl implements CardTransferMapper {

    @Override
    public CardTransferDTO cardTransferToCardTransferDTO(CardTransfer cardTransfer) {
        if ( cardTransfer == null ) {
            return null;
        }

        CardTransferDTO.CardTransferDTOBuilder cardTransferDTO = CardTransferDTO.builder();

        cardTransferDTO.id( cardTransfer.getId() );
        cardTransferDTO.cardNumber( cardTransfer.getCardNumber() );
        cardTransferDTO.amount( cardTransfer.getAmount() );
        cardTransferDTO.purpose( cardTransfer.getPurpose() );
        cardTransferDTO.accountDetailsId( cardTransfer.getAccountDetailsId() );

        return cardTransferDTO.build();
    }

    @Override
    public CardTransfer cardTransferDTOToCardTransfer(CardTransferDTO cardTransferDTO) {
        if ( cardTransferDTO == null ) {
            return null;
        }

        CardTransfer.CardTransferBuilder cardTransfer = CardTransfer.builder();

        cardTransfer.id( cardTransferDTO.getId() );
        cardTransfer.cardNumber( cardTransferDTO.getCardNumber() );
        cardTransfer.amount( cardTransferDTO.getAmount() );
        cardTransfer.purpose( cardTransferDTO.getPurpose() );
        cardTransfer.accountDetailsId( cardTransferDTO.getAccountDetailsId() );

        return cardTransfer.build();
    }

    @Override
    public List<CardTransferDTO> cardTransferListToDTOList(List<CardTransfer> cardTransfers) {
        if ( cardTransfers == null ) {
            return null;
        }

        List<CardTransferDTO> list = new ArrayList<CardTransferDTO>( cardTransfers.size() );
        for ( CardTransfer cardTransfer : cardTransfers ) {
            list.add( cardTransferToCardTransferDTO( cardTransfer ) );
        }

        return list;
    }
}
