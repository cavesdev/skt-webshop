package com.encora.controller;

import com.encora.common.model.Product;
import com.encora.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testShowCreateProductForm() throws Exception {
        mockMvc.perform(get("/products/create"))
                .andExpect(status().isOk())  // Expect HTTP 200 OK
                .andExpect(view().name("createProduct"))
                .andExpect(model().attributeExists("product"));
    }

    @Test
    public void testCreateProduct() throws Exception {
        Product product = new Product(1, "Product A", "Description A", 99.9);

        mockMvc.perform(post("/products")
                        .param("name", product.getName())
                        .param("description", product.getDescription())
                        .param("price", String.valueOf(product.getPrice())))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/products"));
    }

    @Test
    public void testListProducts() throws Exception {
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(1, "Product A", "Description A", 100.0));
        mockProducts.add(new Product(2, "Product B", "Description B", 200.0));

        when(productService.getAllProducts()).thenReturn(mockProducts);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())  // Expect HTTP 200 OK
                .andExpect(view().name("listProducts"))
                .andExpect(model().attributeExists("products"))
                .andExpect(model().attribute("products", mockProducts));
    }
}
