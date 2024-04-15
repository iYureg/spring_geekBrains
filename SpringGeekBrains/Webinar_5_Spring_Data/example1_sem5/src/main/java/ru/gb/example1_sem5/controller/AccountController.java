package ru.gb.example1_sem5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.example1_sem5.dto.TransferRequest;
import ru.gb.example1_sem5.model.Account;
import ru.gb.example1_sem5.service.TransferService;


/**
 * Account controller.
 * @author <screwglennycoder>
 */
@RestController
@AllArgsConstructor
public class AccountController {

    private final TransferService transferService;

    /**
     * Transfer money from one account to another.
     *
     * @param request transfer money request
     */
    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    /**
     * Get all accounts.
     *
     * @param name name of the account
     */
    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return transferService.findAllAccounts();
        } else {
            return transferService.findAllAccountsByName(name);
        }
    }
}
