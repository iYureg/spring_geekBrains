package ru.gb.example1_sem5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.example1_sem5.exception.AccountNotFoundException;
import ru.gb.example1_sem5.model.Account;
import ru.gb.example1_sem5.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;


/**
 * Transfer money between accounts.
 *
 * @author <NAME>
 * Created on: 14.04.2018
 */
@Service
@AllArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;

    /**
     * Transfer money from one account to another.
     *
     * @param senderAccountId   ID of the sender account
     * @param receiverAccountId ID of the receiver account
     * @param amount            amount of money to transfer
     * @throws AccountNotFoundException if one of the accounts is not found
     */
    @Transactional
    public void transferMoney(Long senderAccountId, Long receiverAccountId, BigDecimal amount) {
        Account senderAccount = accountRepository.findById(senderAccountId)
                .orElseThrow(() -> new AccountNotFoundException("sender ID: " + senderAccountId));

        Account receiverAccount = accountRepository.findById(receiverAccountId)
                .orElseThrow(() -> new AccountNotFoundException("receiver ID: " + receiverAccountId));

        BigDecimal senderNewAmount = senderAccount.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiverAccount.getAmount().add(amount);

        accountRepository.changeAmount(senderAccountId, senderNewAmount);
        accountRepository.changeAmount(receiverAccountId, receiverNewAmount);
    }

    /**
     * Find all accounts.
     *
     * @return list of all accounts
     */
    public Iterable<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    /**
     * Find all accounts by name.
     *
     * @param name name of the account
     * @return list of all accounts with the given name
     */
    public List<Account> findAllAccountsByName(String name) {
        return accountRepository.findAccountByName(name);
    }
}
