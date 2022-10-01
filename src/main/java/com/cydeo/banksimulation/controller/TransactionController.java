package com.cydeo.banksimulation.controller;

import com.cydeo.banksimulation.model.Transaction;
import com.cydeo.banksimulation.service.AccountService;
import com.cydeo.banksimulation.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TransactionController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public TransactionController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @GetMapping("/make-transfer")
    public String retrieveTransactionForm(Model model) {
        model.addAttribute("accounts", accountService.listAllAccount());
        model.addAttribute("transaction", Transaction.builder().build());
        model.addAttribute("lastTransactionList", transactionService.retrieveLastTransaction());

        return "transaction/make-transfer";
    }

}
