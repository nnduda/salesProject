package pl.edu.wszib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.model.Product;
import pl.edu.wszib.repository.IProductRepository;
import pl.edu.wszib.service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    IProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(IProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productRepository.getAllProducts());

    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }


    @Override
    public List<Product> getAllSortedProducts(String fieldName) {
        List<Product> allProducts = productRepository.getAllProducts();
        return allProducts.stream().sorted(Comparator.comparing(product->{
            if("category".equals(fieldName)){
                return product.getCategory();
            }else{
                return product.getName();
            }
        })).collect(Collectors.toList());
    }


}



