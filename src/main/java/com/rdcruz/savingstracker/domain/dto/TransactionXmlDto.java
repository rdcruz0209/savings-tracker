package com.rdcruz.savingstracker.domain.dto;

import com.rdcruz.savingstracker.domain.adapter.LocalDateTimeAdapter;
import com.rdcruz.savingstracker.domain.enums.TransactionCategoryEnum;
import com.rdcruz.savingstracker.domain.enums.TypeEnum;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement(name = "transaction")
//@XmlType (propOrder = {"id","amount","type","description","transactionCategory","user"})
@XmlType (propOrder = {"id","amount","type","description","transactionDate","transactionCategory","user"})
public class TransactionXmlDto {
    private String id;
    private BigDecimal amount;
    private TypeEnum type;
    private String description;

    private LocalDateTime transactionDate;
    private TransactionCategoryEnum transactionCategory;
    private UserXmlDto user;

    @XmlElement(name = "transactionDate", required = true)
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
