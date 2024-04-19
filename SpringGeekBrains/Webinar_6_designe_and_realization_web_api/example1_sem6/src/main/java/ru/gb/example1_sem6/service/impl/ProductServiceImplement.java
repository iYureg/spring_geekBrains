package ru.gb.example1_sem6.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.example1_sem6.model.Product;
import ru.gb.example1_sem6.repository.ProductRepository;
import ru.gb.example1_sem6.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService {
    private final ProductRepository productRepo;


    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productById = getProductById(product.getId());

        /*productById.setCount(product.getCount());*/
        productById.setTitle(product.getTitle());
        productById.setQuantity(product.getQuantity());


        return productRepo.save(productById);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product productById = getProductById(id);
        productRepo.delete(productById);
    }
}
