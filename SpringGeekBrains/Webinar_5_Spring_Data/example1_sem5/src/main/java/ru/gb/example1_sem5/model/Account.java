package ru.gb.example1_sem5.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@Data
public class Account {
    @Id
    private Long id;
    private String name;
    private BigDecimal amount;
}
