package com.rdcruz.savingstracker.service;

import com.rdcruz.savingstracker.domain.entity.Transaction;

import javax.xml.bind.JAXBException;

public interface XmlService {

    String createXml(Transaction transaction) throws JAXBException;
}
