package com.example.client.web_ui;

import com.example.client.model.AccountDto;
import com.example.client.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    private AccountService accountService;

    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String list (Model model)  {
        var allAccounts = accountService.readAll();
        model.addAttribute("listOfAccounts", allAccounts);
        return "accounts";
    }

    @GetMapping("/edit")
    public String showForm(@RequestParam Long id, Model model){
        accountService.setCurrentUser(id);
        var account = accountService.readOne();
        model.addAttribute("account", account);
        return "editAccount";
    }

    @PostMapping("/edit")
    public String submitForm(Model model, @ModelAttribute AccountDto accountDto, RedirectAttributes redirectAttributes) {
        accountService.setCurrentUser(accountDto.getAccountId());
        try{
            accountService.updateCurrentUser(accountDto);
        }catch(HttpClientErrorException.MethodNotAllowed e) {
            model.addAttribute("error_snh", true);
        }
        redirectAttributes.addFlashAttribute("message", "Form submitted successfully!");
        return "redirect:/index.html";
    }
}
