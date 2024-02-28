package com.rdcruz.savingstracker.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rdcruz.savingstracker.domain.enums.TransactionCategoryEnum;
import com.rdcruz.savingstracker.domain.enums.TypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false, length = 36)
    @GenericGenerator(name = "uuid.generator.name", strategy = "uuid.generator.strategy")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
//  CREDIT OR DEBIT
    private TypeEnum type;

    @Column(name = "description")
    private String description;

    @Column(name = "transaction_date")
//    @CreationTimestamp
    private LocalDateTime transactionDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_category", nullable = false)
    private TransactionCategoryEnum transactionCategory;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = true)
    @JsonIgnore
    private User user;
}
