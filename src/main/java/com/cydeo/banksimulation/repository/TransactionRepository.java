package com.cydeo.banksimulation.repository;

import com.cydeo.banksimulation.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    public List<Transaction> retrieveLastTransactions() {
//        return transactionList
//                .stream()
//                .sorted(Comparator.comparing(Transaction::getCreationDate))
//                .limit(10)
//                .collect(Collectors.toList());
//    }
//
//    public List<Transaction> findTransactionListById(UUID id) {
//        return transactionList
//                .stream()
//                .filter(transaction -> transaction.getSender().equals(id) || transaction.getReceiver().equals(id))
//                .collect(Collectors.toList());
//    }

}
