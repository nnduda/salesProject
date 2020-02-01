package pl.edu.wszib.repository;

import org.springframework.stereotype.Component;
import pl.edu.wszib.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryRepository implements IProductRepository {
    List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        Product p1 = new Product("napoje", "sok", 1L);
        Product p2 = new Product("pieczywo", "chleb", 2L);
        Product p3 = new Product("slodyczne", "czekolada", 3L);
        Product p4 = new Product("alkohol", "wino", 4L);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
    }

    @Override
    public List<Product> getAllProducts() {


        return products;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

}
