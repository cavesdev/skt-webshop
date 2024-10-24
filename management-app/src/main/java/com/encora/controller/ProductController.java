package com.encora.controller;

import com.encora.common.model.Product;
import com.encora.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "listProducts";
    }

    @PostMapping("/create")
    public RedirectView createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/products/create", true);
        Product savedProduct = productService.createProduct(product);
        redirectAttributes.addFlashAttribute("savedProduct", savedProduct);
        redirectAttributes.addFlashAttribute("addProductSuccess", true);
        return redirectView;
    }

    @GetMapping("/create")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }
}
