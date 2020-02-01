package pl.edu.wszib.service;

import pl.edu.wszib.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> findById(Long id);
    List<Product> getAllSortedProducts(String fieldName);
}
