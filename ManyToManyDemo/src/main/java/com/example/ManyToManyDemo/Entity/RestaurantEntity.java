package com.example.ManyToManyDemo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantID;
    private String name;
    private String type;
    private String location;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "restaurant_item_mapping", joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<ItemsEntity> items;

    public RestaurantEntity(String name, String type, String location, Set<ItemsEntity> items) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.items = items;
    }
}
