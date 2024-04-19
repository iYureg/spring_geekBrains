package ru.gb.example1_sem6.model;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long quantity;
}
