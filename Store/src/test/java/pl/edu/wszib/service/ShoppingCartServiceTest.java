package pl.edu.wszib.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pl.edu.wszib.model.Product;
import pl.edu.wszib.repository.InMemoryRepository;
import pl.edu.wszib.repository.ProductRepository;
import pl.edu.wszib.service.impl.ShoppingCartServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {
    @InjectMocks
    ShoppingCartServiceImpl shoppingCartService;
    @Mock
    ProductRepository productRepository;
    @Mock
    InMemoryRepository inMemoryRepository;
    @Test
    public void shouldAddProduct(){
        Product product = new Product("owoce", "kiwi", 1L);
        Mockito.when(inMemoryRepository.findById(1L)).thenReturn(Optional.of(product));
        shoppingCartService.addProduct(1L);
        List<Product> productsInCart = shoppingCartService.getProductsInCart();
        assertThat(productsInCart.size()).isEqualTo(1);
    }

    @Test
    public void shouldNotAddProduct(){
        Mockito.when(inMemoryRepository.findById(1L)).thenReturn(Optional.empty());
        assertThatThrownBy(()->shoppingCartService.addProduct(1L)).isInstanceOf(NoSuchElementException.class);
    }

}
