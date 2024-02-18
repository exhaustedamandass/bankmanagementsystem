package com.example.client.web_ui;

import com.example.client.model.AccountDto;
import com.example.client.model.TransactionDto;
import com.example.client.service.AccountService;
import com.example.client.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionsController {
    private TransactionService transactionService;
    private AccountService accountService;

    public TransactionsController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }
    @GetMapping
    public String list (Model model) {
        var allTransactions = transactionService.readAll();
        model.addAttribute("listOfTransactions", allTransactions);
        return "transactions";
    }

    /*@GetMapping("/byAccount/{accountId}")
    public String listByUser (@PathVariable Long userId, Model model){
        var allTransactions = transactionService.
    }*/

    @GetMapping("/{transactionId}")
    public String singleTransaction (@PathVariable Long transactionId, Model model){
        transactionService.setCurrentUser(transactionId);
        var transaction = transactionService.readOne();
        model.addAttribute("transaction", transaction);
        return "transactionDetails";
    }

    @GetMapping("/newTransaction")
    public String showForm(Model model){
        TransactionDto transactionDto = new TransactionDto();
        model.addAttribute("transaction", transactionDto);
        List<String> listTransactionTypes = Arrays.asList("Withdrawal", "Deposit");
        model.addAttribute("listTransactionTypes", listTransactionTypes);
        return "newTransaction";
    }

    @PostMapping("/newTransaction")
    public String submitForm(Model model, @ModelAttribute TransactionDto transactionDto, RedirectAttributes redirectAttributes){
        transactionDto.setTransactionDate(LocalDateTime.now());
        transactionService.create(transactionDto);
        accountService.setCurrentUser(transactionDto.getClientAccount());
        AccountDto accountDto = new AccountDto();
        accountDto = accountService.readOne();
        double currentAmount = accountDto.getCurrentBalance();
        if(transactionDto.getTransactionType().equals("Withdrawal")) {
            currentAmount -= transactionDto.getAmount();
        }else{
            currentAmount += transactionDto.getAmount();
        }
        accountDto.setCurrentBalance(currentAmount);
        accountService.updateCurrentUser(accountDto);
        redirectAttributes.addFlashAttribute("message", "Your money have been successfully deposited!");
        return "redirect:/index.html";
    }


}
