package pl.edu.wszib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pl.edu.wszib.model.Product;
import pl.edu.wszib.repository.InMemoryRepository;
import pl.edu.wszib.repository.ProductRepository;
import pl.edu.wszib.service.ShoppingCartService;

import java.util.*;


@Service

    public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ProductRepository productRepository;

    private Map<Product, Integer> products = new HashMap<>();
    private List<Product> productsInCart = new ArrayList<>();

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    @Autowired
    InMemoryRepository inMemoryRepository;


    public void addProduct(Long product) {
        productsInCart.add(inMemoryRepository.findById(product).get());
    }


    @Override
    public void removeProduct(Long id) {
        for (int i = 0; i < productsInCart.size(); i++) {
            if (id.equals(productsInCart.get(i).getId())) {
                productsInCart.remove(i);
                break;
            }
        }

    }
}