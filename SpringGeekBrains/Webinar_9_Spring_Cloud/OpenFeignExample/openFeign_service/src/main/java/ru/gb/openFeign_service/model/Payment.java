package ru.gb.openFeign_service.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment {

    private String id;
    private BigDecimal amount;

}