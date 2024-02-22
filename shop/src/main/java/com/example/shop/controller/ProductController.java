package com.example.shop.controller;

import com.example.shop.db.Db;
import com.example.shop.dto.CategoryDto;
import com.example.shop.dto.ProductDto;
import com.example.shop.entity.Category;
import com.example.shop.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/product")
public class ProductController {
    @GetMapping
    public List<Product> getProduct(@RequestParam(defaultValue = "") UUID categoryId){
        List<Product> products = new ArrayList<>();
        for (Product product : Db.products) {
            if (product.getCategoryId().equals(categoryId)){
                products.add(product);
            }
        }

        return products;
    }

    @DeleteMapping
    public String deleteProduct(@RequestParam(defaultValue = "" ) UUID productId){
        for (Product product : Db.products) {
            if (product.getId().equals(productId)){
                Db.products.remove(product);
            }
        }
        return "Deleted Product";
    }
    @PostMapping
    public String addProduct(@RequestBody ProductDto productDto){
        Product product = new Product(
                UUID.randomUUID(),
             productDto.getCategoryId(),
                productDto.getPrice(),
                productDto.getName()

        );
        for (Category category : Db.categories) {
            if(category.getId().equals(productDto.getCategoryId())){
                Db.products.add(product);
            }

        }
        return "Add Product";
    }

}
