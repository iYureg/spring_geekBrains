package ru.gb.example3_sem4.repository;

import org.springframework.stereotype.Repository;
import ru.gb.example3_sem4.model.Product;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {
    List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }

    public List<Product> getProducts(){
        return  productList;
    }
}
