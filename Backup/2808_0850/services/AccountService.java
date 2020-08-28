package lab.smk.services;

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

