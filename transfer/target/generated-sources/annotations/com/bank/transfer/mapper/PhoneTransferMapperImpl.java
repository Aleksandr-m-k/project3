package com.bank.transfer.mapper;

import com.bank.transfer.dto.PhoneTransferDTO;
import com.bank.transfer.entity.PhoneTransfer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T17:18:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class PhoneTransferMapperImpl implements PhoneTransferMapper {

    @Override
    public PhoneTransferDTO phoneTransferToPhoneTransferDTO(PhoneTransfer phoneTransfer) {
        if ( phoneTransfer == null ) {
            return null;
        }

        PhoneTransferDTO.PhoneTransferDTOBuilder phoneTransferDTO = PhoneTransferDTO.builder();

        phoneTransferDTO.id( phoneTransfer.getId() );
        phoneTransferDTO.phoneNumber( phoneTransfer.getPhoneNumber() );
        phoneTransferDTO.amount( phoneTransfer.getAmount() );
        phoneTransferDTO.purpose( phoneTransfer.getPurpose() );
        phoneTransferDTO.accountDetailsId( phoneTransfer.getAccountDetailsId() );

        return phoneTransferDTO.build();
    }

    @Override
    public PhoneTransfer phoneTransferDTOToPhoneTransfer(PhoneTransferDTO phoneTransferDTO) {
        if ( phoneTransferDTO == null ) {
            return null;
        }

        PhoneTransfer.PhoneTransferBuilder phoneTransfer = PhoneTransfer.builder();

        phoneTransfer.id( phoneTransferDTO.getId() );
        phoneTransfer.phoneNumber( phoneTransferDTO.getPhoneNumber() );
        phoneTransfer.amount( phoneTransferDTO.getAmount() );
        phoneTransfer.purpose( phoneTransferDTO.getPurpose() );
        phoneTransfer.accountDetailsId( phoneTransferDTO.getAccountDetailsId() );

        return phoneTransfer.build();
    }

    @Override
    public List<PhoneTransferDTO> phoneTransferListToDTOList(List<PhoneTransfer> phoneTransfers) {
        if ( phoneTransfers == null ) {
            return null;
        }

        List<PhoneTransferDTO> list = new ArrayList<PhoneTransferDTO>( phoneTransfers.size() );
        for ( PhoneTransfer phoneTransfer : phoneTransfers ) {
            list.add( phoneTransferToPhoneTransferDTO( phoneTransfer ) );
        }

        return list;
    }
}
