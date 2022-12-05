package com.cydeo.banksimulation.service.impl;

import com.cydeo.banksimulation.dto.AccountDTO;
import com.cydeo.banksimulation.dto.TransactionDTO;
import com.cydeo.banksimulation.service.TransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TransactionDTO makeTransfer(BigDecimal amount, Date creationDate, AccountDTO sender, AccountDTO receiver, String message) {
        return null;
    }

    @Override
    public List<TransactionDTO> findAll() {
        return null;
    }

    @Override
    public List<TransactionDTO> retrieveLastTransactions() {
        return null;
    }

    @Override
    public List<TransactionDTO> findTransactionListByAccountId(Long id) {
        return null;
    }
}
