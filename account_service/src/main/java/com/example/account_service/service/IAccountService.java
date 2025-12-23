package com.example.account_service.service;

import com.example.account_service.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getListAccounts();
}
