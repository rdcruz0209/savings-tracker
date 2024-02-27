package com.rdcruz.savingstracker.domain.repository;

import com.rdcruz.savingstracker.domain.dto.TransactionDto;
import com.rdcruz.savingstracker.domain.entity.Transaction;
import com.rdcruz.savingstracker.domain.enums.TypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
//        (collectionResourceRel = "transaction", path = "transaction")
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    Transaction getCreditsByDescription(String description);

    @Query("select t from Transaction t")
    List<Transaction> findAllTransaction();

    List<Transaction> findAllTransactionByType(TypeEnum type);

    @Query("select t from Transaction t where t.user = ?1")
    List<Transaction> findAllByUserId(String user);
}
