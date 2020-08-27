package lab.smk.services;

import lab.smk.models.system.Account;
import lab.smk.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }
}

