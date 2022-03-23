package com.example.springboot;

import java.util.List;

public interface ProductService {

    List<Product> getAll();//getAll()
    void saveProduct(Product product);
    Product getById(Long id);
  void putById(Long id, int amount);
    void deleteById(Long id);
}