package pl.edu.wszib.service;

import pl.edu.wszib.model.Product;

import java.util.List;


public interface ShoppingCartService {
    void addProduct(Long product);

    void removeProduct(Long id);

    List<Product> getProductsInCart();


}
