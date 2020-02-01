package pl.edu.wszib.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.parameters.P;
import pl.edu.wszib.model.Product;
import pl.edu.wszib.repository.IProductRepository;
import pl.edu.wszib.service.impl.ProductServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @InjectMocks
    ProductServiceImpl productService;
    @Mock
    IProductRepository productRepository;
    @Test
    public void shouldReturnEmptyProductList(){
        Mockito.when(productRepository.getAllProducts()).thenReturn(Collections.emptyList());
        List<Product> allProducts = productService.getAllProducts();
        assertThat(allProducts.size()).isEqualTo(0);
    }
    @Test
    public void shouldReturnProductList(){
        Product product = new Product();
        Mockito.when(productRepository.getAllProducts()).thenReturn(Collections.singletonList(product));
        List<Product> allProducts = productService.getAllProducts();
        assertThat(allProducts.size()).isEqualTo(1);
    }
    @Test
    public void shouldBeSortedByName(){
        Product product1 = new Product("owoce", "kiwi", 1L);
        Product product2 = new Product("nabial", "ser", 2L);
        Mockito.when(productRepository.getAllProducts()).thenReturn(Arrays.asList(product1,product2));
        List<Product> sortedList = productService.getAllSortedProducts("name");
        assertThat(sortedList).isSortedAccordingTo(Comparator.comparing(product ->product.getName()));
    }
    @Test
    public void shouldBeSortedByCategory(){
        Product product1 = new Product("owoce", "kiwi", 1L);
        Product product2 = new Product("nabial", "ser", 2L);
        Mockito.when(productRepository.getAllProducts()).thenReturn(Arrays.asList(product1,product2));
        List<Product> sortedList = productService.getAllSortedProducts("category");
        assertThat(sortedList).isSortedAccordingTo(Comparator.comparing(product ->product.getCategory()));
    }



}
