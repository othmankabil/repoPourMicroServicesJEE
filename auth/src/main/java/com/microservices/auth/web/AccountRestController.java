package com.microservices.auth.web;

import com.microservices.auth.entities.AppUser;
import com.microservices.auth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    @Autowired
   private  AccountService accountService;
    @GetMapping(path = "/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AppUser> appUsers() {
        return accountService.allUsers();
    }
}
