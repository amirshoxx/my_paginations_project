package com.example.shop.controller;

import com.example.shop.db.Db;
import com.example.shop.dto.KorzinkaDto;
import com.example.shop.entity.Korzinka;
import com.example.shop.entity.OrderProduct;
import com.example.shop.entity.Product;
import com.example.shop.repository.OrderProductRepo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/orderProduct")
public class OrderController {
//    @PostMapping
//    public void addOrderProduct(@RequestParam(defaultValue = "") UUID userId, @RequestParam(defaultValue = "") UUID productId) {
//  Db.orderProducts.add(
//          new OrderProduct(
//                  UUID.randomUUID(),
//                  userId,
//                  productId
//          )
//  );
//    }
    @GetMapping
    public List<OrderProductRepo> getOrderProduct(@RequestParam(defaultValue = "") UUID userId){
        List<OrderProductRepo> orderProductRepos = new ArrayList<>();
        for (OrderProduct orderProduct : Db.orderProducts) {
            if (orderProduct.getUserId().equals(userId)){
                Product product = findProductByProductId(orderProduct.getProductId());
                OrderProductRepo orderProductRepo = new OrderProductRepo(
                        UUID.randomUUID(),
                        product.getName(),
                        product.getPrice()
                );
                orderProductRepos.add(orderProductRepo);
            }
        }
        return orderProductRepos;
    }

    private Product findProductByProductId(UUID productId) {
        for (Product product : Db.products) {
            if (product.getId().equals(productId)){
                return product;
            }
        }
        return null;
    }


    @PostMapping
    public String saveProduct(@RequestBody KorzinkaDto dto , @RequestParam UUID userId){
        Korzinka korzinka = new Korzinka(
                UUID.randomUUID(),
                LocalDateTime.now(),
                userId,
               dto.getProducts()
        );
      Db.korzinka.add(korzinka);
      return "Added Successfully";
    }


    @GetMapping("/shopping")
    public List<Korzinka> getKorzinka(){
        return Db.korzinka;
    }


}
