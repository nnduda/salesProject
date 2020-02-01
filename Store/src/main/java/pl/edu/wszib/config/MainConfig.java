package pl.edu.wszib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.edu.wszib.repository.IProductRepository;
import pl.edu.wszib.repository.InMemoryRepository;
import pl.edu.wszib.repository.ProductRepository;

@Configuration
public class MainConfig {

    @Bean
    @Primary
    IProductRepository createInMemoryRepository(){
        IProductRepository repo = new InMemoryRepository();
        return repo;
    }
    @Bean
    IProductRepository createInProductRepository(){
        IProductRepository repo = new ProductRepository();
        return repo;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
