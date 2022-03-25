package com.super13.accountservice.controller;

import com.super13.accountservice.domain.Account;
import com.super13.accountservice.domain.User;
import com.super13.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Account getAccountByName(@PathVariable String name) {
        return accountService.findByName(name);
    }

    @GetMapping("/current")
    public Account getCurrentAccount(Principal principal) {
        return accountService.findByName(principal.getName());
    }

    @PostMapping("/current")
    public void saveCurrentAccount(Principal principal, @Valid @RequestBody Account account) {
        accountService.saveChanges(principal.getName(), account);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Account createNewAccount(@Valid @RequestBody User user) {
        return accountService.create(user);
    }
}
