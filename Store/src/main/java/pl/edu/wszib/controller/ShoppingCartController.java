package pl.edu.wszib.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.edu.wszib.service.ProductService;
import pl.edu.wszib.service.ShoppingCartService;

@Controller
public class ShoppingCartController {


    @Autowired
    ShoppingCartService shoppingCartService;

    private final ProductService productService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("shoppingCart");
        System.out.println(shoppingCartService.getProductsInCart());
        modelAndView.addObject("products", shoppingCartService.getProductsInCart());
        return modelAndView;
    }





    @GetMapping("/shoppingCart/removeProduct/{productId}")
    public String removeProductFromCart(@PathVariable("productId") Long productId) {
    shoppingCartService.removeProduct(productId);
        return "redirect:/shoppingCart";
    }



    @RequestMapping(value = "/shoppingCart/addProduct/{productId}", method = RequestMethod.GET)
    public String addToCart(@PathVariable("productId")Long id){
        shoppingCartService.addProduct(id);
        return "redirect:/shoppingCart";

    }


}
