package pl.edu.wszib.repository;

import pl.edu.wszib.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAllProducts();
    List<Product> getProductsByName(String name);
    List<Product> getProductsByCategory(String category);
    Optional<Product> findById(Long id);



}
