package com.example.shop.db;

import com.example.shop.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Db {
    public static List<User> users= new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static  List<OrderProduct> orderProducts = new ArrayList<>();
    public static  List<Korzinka> korzinka = new ArrayList<>();

    public static void init(){
        users.addAll(List.of(
                ));
        categories.addAll(List.of(
                new Category(
                        UUID.randomUUID(),
                        "Ichimliklar"
                ),
                new Category(
                        UUID.randomUUID(),
                        "Yeguliklar"
                ),
                new Category(
                        UUID.randomUUID(),
                        "Sabzavot"
                )
        ));
        products.addAll(List.of(
                new Product(
                        UUID.randomUUID(),
                        categories.get(0).getId(),
                        11000.0,
                        "Coco-Cola"
                ), new Product(
                        UUID.randomUUID(),
                        categories.get(0).getId(),
                        11000.0,
                        "Fanta"
                ),new Product(
                        UUID.randomUUID(),
                        categories.get(0).getId(),
                        11000.0,
                        "Nestle"
                ),new Product(
                        UUID.randomUUID(),
                        categories.get(0).getId(),
                        11000.0,
                        "Flash"
                ),
                new Product(
                        UUID.randomUUID(),
                        categories.get(0).getId(),
                        11000.0,
                        "Pepsi"
                ),
                new Product(
                        UUID.randomUUID(),
                        categories.get(1).getId(),
                        45000.0,
                        "Tort"
                ),
                new Product(
                        UUID.randomUUID(),
                        categories.get(2).getId(),
                        15000.0,
                        "Sabzi"
                ),
                new Product(
                        UUID.randomUUID(),
                        categories.get(0).getId(),
                        12.0,
                        "fanta"
                )
        ));

      users.addAll(
List.of(
        new User(UUID.randomUUID(),"Amir","123",12,"amir@gmail.com","122222222",Role.ROLE_ADMIN),
        new User(UUID.randomUUID(),"Ozod","123",12,"ozod@gmail.com","111111111",Role.ROLE_USER)

)      );
    }
}
