package com.akash.banking.service.impl;

import com.akash.banking.dto.AccountDto;
import com.akash.banking.entity.Account;
import com.akash.banking.mapper.AccountMapper;
import com.akash.banking.repository.AccountRepository;
import com.akash.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveedAccount);
    }
}
