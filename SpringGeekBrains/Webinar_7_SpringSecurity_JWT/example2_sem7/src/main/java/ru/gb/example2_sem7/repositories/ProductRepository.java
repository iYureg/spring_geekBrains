package ru.gb.example2_sem7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.example2_sem7.entitys.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
