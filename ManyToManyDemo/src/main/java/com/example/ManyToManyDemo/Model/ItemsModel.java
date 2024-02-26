package com.example.ManyToManyDemo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ItemsModel {
    private int itemID;
    private String name;
    private String category;
    private String cuisine;
    private RestaurantModel restaurantModel;

    public ItemsModel(String name, String category, String cuisine) {
        this.name = name;
        this.category = category;
        this.cuisine = cuisine;
    }
}
