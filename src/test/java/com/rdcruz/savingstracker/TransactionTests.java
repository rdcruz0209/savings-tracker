package com.rdcruz.savingstracker;

import com.rdcruz.savingstracker.domain.entity.Transaction;
import com.rdcruz.savingstracker.domain.enums.TypeEnum;
import com.rdcruz.savingstracker.service.TransactionService;
import org.assertj.core.api.Assertions;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class TransactionTests {
    @Autowired
    @Mock
    TransactionService transactionService;

    @Test
    void getTransactionById() {
        String transactionId = "random-uuid123456789010";
        Transaction transactionObject = transactionService.findById(transactionId);

        Assertions.assertThat(Objects.isNull(transactionObject));
        assertEquals(transactionService.findById("12345678-1234-1234-1234-123456789abc").getType(), TypeEnum.CREDIT);
    }

}
