package com.rdcruz.savingstracker.service.mapper;

import com.rdcruz.savingstracker.controller.dto.TransactionXmlDto;
import com.rdcruz.savingstracker.domain.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionXmlDTOMapper implements Function<Transaction, TransactionXmlDto> {

    private final UserXmlDTOMapper userXmlDTOMapper;

    public TransactionXmlDTOMapper(UserXmlDTOMapper userXmlDTOMapper) {
        this.userXmlDTOMapper = userXmlDTOMapper;
    }

    public TransactionXmlDto map(Transaction transaction){
       return this.apply(transaction);
    }

    @Override
    public TransactionXmlDto apply(Transaction transaction) {
        return TransactionXmlDto.builder()
                                .id(transaction.getId())
                                .amount(transaction.getAmount())
                                .type(transaction.getType())
                                .user(userXmlDTOMapper.map(transaction.getUser()))
                                .transactionCategory(transaction.getTransactionCategory())
                                .transactionDate(transaction.getTransactionDate())
                                .description(transaction.getDescription())
                                .build();
    }
}
