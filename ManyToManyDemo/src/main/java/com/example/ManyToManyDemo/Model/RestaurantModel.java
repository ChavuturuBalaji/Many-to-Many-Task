package com.example.ManyToManyDemo.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class RestaurantModel {
    private int restaurantID;
    private String name;
    private String type;
    private String location;
    private List<ItemsModel> items;

    public RestaurantModel(String name, String type, String location, List<ItemsModel> items) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.items = items;
    }



}
