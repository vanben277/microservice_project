package com.example.account_service.controller;

import com.example.account_service.dto.AccountDto;
import com.example.account_service.entity.Account;
import com.example.account_service.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounts")
public class AccountController {
    private final IAccountService acService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<AccountDto> getListAccounts() {
        List<Account> accountEntities = acService.getListAccounts();
        return modelMapper.map(
                accountEntities,
                new TypeToken<List<AccountDto>>() {
                }.getType());
    }
}
