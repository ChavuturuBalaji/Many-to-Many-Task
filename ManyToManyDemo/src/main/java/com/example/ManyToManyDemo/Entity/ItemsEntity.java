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
@Table(name = "Items")
public class ItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemID;
    private String name;
    private String category;
    private String cuisine;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "restaurant_item_mapping", joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
    private Set<RestaurantEntity> restaurantEntity;

    public ItemsEntity(String name, String category, String cuisine, Set<RestaurantEntity> restaurantEntity) {
        this.name = name;
        this.category = category;
        this.cuisine = cuisine;
        this.restaurantEntity = restaurantEntity;
    }
}
