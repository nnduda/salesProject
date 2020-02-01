package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.model.Product;
import pl.edu.wszib.service.impl.ProductServiceImpl;
import pl.edu.wszib.service.impl.ShoppingCartServiceImpl;

import java.util.List;

@Controller
public class ProductController {
@Autowired
ProductServiceImpl productService;
ShoppingCartServiceImpl shoppingCartService;
Product product = new Product();

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAllProducts(Model model, @RequestParam(required = false) String fieldName){
        System.out.println(fieldName);
    List<Product> allProducts = productService.getAllSortedProducts(fieldName);
    model.addAttribute("products", allProducts);
      return "products";

    }

}
