package com.rdcruz.savingstracker.domain.dto;

import com.rdcruz.savingstracker.domain.entity.User;
import com.rdcruz.savingstracker.domain.enums.TransactionCategoryEnum;
import com.rdcruz.savingstracker.domain.enums.TypeEnum;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.rdcruz.savingstracker.domain.entity.Transaction}
 */
@Data
@Value
public class TransactionDto implements Serializable {
    String id;
    BigDecimal amount;
    TypeEnum type;
    String description;
    LocalDateTime transactionDate;
    TransactionCategoryEnum transactionCategory;
    User user;
}