package ru.gb.example1_sem6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.example1_sem6.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
