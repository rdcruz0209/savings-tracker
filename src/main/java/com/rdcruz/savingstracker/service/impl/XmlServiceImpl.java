package com.rdcruz.savingstracker.service.impl;

import com.rdcruz.savingstracker.controller.dto.TransactionXmlDto;
import com.rdcruz.savingstracker.domain.entity.Transaction;
import com.rdcruz.savingstracker.service.XmlService;
import com.rdcruz.savingstracker.service.mapper.TransactionXmlDTOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Service
@Slf4j
public class XmlServiceImpl implements XmlService {

    private final TransactionXmlDTOMapper transactionXmlDTOMapper;

    public XmlServiceImpl(TransactionXmlDTOMapper transactionXmlDTOMapper) {
        this.transactionXmlDTOMapper = transactionXmlDTOMapper;
    }

    @Override
    public String createXml(Transaction transaction) throws JAXBException {
        try {
            TransactionXmlDto transactionXmlDto = transactionXmlDTOMapper.map(transaction);
            JAXBContext jaxbContext = JAXBContext.newInstance(TransactionXmlDto.class);
            Marshaller mar = jaxbContext.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter stringWriter = new StringWriter();
            mar.marshal(transactionXmlDto, stringWriter);
            log.info("transactionXmlDto details: id:{}", transactionXmlDto.getUser());
            return stringWriter.toString();
        } catch (JAXBException e) {
            log.error("Error occurred while marshalling TransactionXmlDto", e);
            throw new JAXBException("Error has occurred with cause" + e.getCause());
        }
    }

}
