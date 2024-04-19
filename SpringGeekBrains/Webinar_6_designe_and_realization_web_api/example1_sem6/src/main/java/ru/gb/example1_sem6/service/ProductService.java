package ru.gb.example1_sem6.service;

import org.springframework.stereotype.Repository;
import ru.gb.example1_sem6.model.Product;
import ru.gb.example1_sem6.repository.ProductRepository;

import java.util.List;




public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Product product);

    Product createProduct(Product product);

    void deleteProduct(Long id);
}
