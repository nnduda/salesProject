package pl.edu.wszib.repository;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
// tutaj bede pobierac z bazy narazie z palca
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> getAllProducts() {
        // pobieranie  z bazy
        return null;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        // pobieranie z bazy select name from DB
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        // pobieranie z bazy select category from DB
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }
}

