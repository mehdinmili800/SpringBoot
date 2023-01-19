package com.ecommerce.customer.controller;

import com.ecommerce.library.dto.CategoryDto;
import com.ecommerce.library.model.Product;
import com.ecommerce.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String products(Model model){
        List<Product> products = productService.getAllProducts();
        List<Product> listViewproducts = productService.getAllProducts();
        model.addAttribute("viewProducts" , listViewproducts);
        model.addAttribute("products" , products);
        return "shop";
    }
}
