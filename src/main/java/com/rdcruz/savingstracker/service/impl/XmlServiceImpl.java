package com.rdcruz.savingstracker.service.impl;

import com.rdcruz.savingstracker.domain.dto.TransactionXmlDto;
import com.rdcruz.savingstracker.domain.entity.Transaction;
import com.rdcruz.savingstracker.service.XmlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;

@Service
@Slf4j
public class XmlServiceImpl implements XmlService {

    @Override
    public String createXml(Transaction transaction) throws JAXBException {
        TransactionXmlDto transactionXmlDto = transactionEntityXmlMapper(transaction);
        JAXBContext jaxbContext = JAXBContext.newInstance(TransactionXmlDto.class);
        Marshaller mar = jaxbContext.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter stringWriter = new StringWriter();
        mar.marshal(transactionXmlDto, stringWriter);
        log.info("transactionXmlDto details: id:{}, date:{}", transactionXmlDto.getUser(), transactionXmlDto.getTransactionDate());
        return stringWriter.toString();
    }

    private TransactionXmlDto transactionEntityXmlMapper(Transaction transaction) {
        return TransactionXmlDto.builder()
                                .id(transaction.getId())
                                .amount(transaction.getAmount())
                                .type(transaction.getType())
                                .user(transaction.getUser())
                                .transactionCategory(transaction.getTransactionCategory())
                                .transactionDate(transaction.getTransactionDate())
                                .description(transaction.getDescription())
                                .build();
    }
}
