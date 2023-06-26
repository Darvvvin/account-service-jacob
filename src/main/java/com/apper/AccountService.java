package com.apper;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private final List<Account> accounts = new ArrayList<>();

    public Account create(String firstName, String lastName, String username, String clearPassword) {
        Account account = new Account();

        String id = UUID.randomUUID().toString();
        System.out.println("Generated id: " + id);

        account.setId(id);
        account.setBalance(1_000.0);

        LocalDateTime now = LocalDateTime.now();
        account.setCreationDate(now);
        account.setLastUpdated(now);

        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setUsername(username);
        account.setClearPassword(clearPassword);
        account.setVerificationCode("QW345T");

        accounts.add(account);

        return account;
    }

    public Account get(String accountId) {
        for (Account account : accounts) {
            if (account.getId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }

    public List<Account> getAll() {
        return accounts;
    }

    public Account update(String firstName, String lastName, String username, String clearPassword, String accountId) {
        Account account = new Account();

        LocalDateTime now = LocalDateTime.now();
        account.setLastUpdated(now);

        // Update
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setUsername(username);
        account.setClearPassword(clearPassword);

        // Get from previous
        account.setBalance(get(accountId).getBalance());
        account.setCreationDate(get(accountId).getCreationDate());
        account.setId(accountId);

        accounts.set(accounts.indexOf(get(accountId)), account);

        return account;
    }
}
