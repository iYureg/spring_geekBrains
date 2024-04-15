package ru.gb.example1_sem5.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Data transfer object.
 * Transfer money request.
 */
@Data
public class TransferRequest {
    private long senderAccountId; // sender account id
    private long receiverAccountId; //  account     id of the receiver
    private BigDecimal amount; // amount of money
}
