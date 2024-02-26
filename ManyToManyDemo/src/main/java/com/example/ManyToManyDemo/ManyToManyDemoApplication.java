package com.example.ManyToManyDemo;

import com.example.ManyToManyDemo.Entity.ItemsEntity;
import com.example.ManyToManyDemo.Entity.RestaurantEntity;
import com.example.ManyToManyDemo.Repository.ItemsRepository;
import com.example.ManyToManyDemo.Repository.RestaurantRepository;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ManyToManyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyDemoApplication.class, args);
	}

//	@Autowired
//	RestaurantRepository restaurantRepo;
////
////	@Autowired
//	ItemsRepository itemsRepo;

//	@Override
//	public void run(String... args) throws Exception {
//		RestaurantEntity restaurantEntity = new RestaurantEntity();
//		restaurantEntity.setName("Taj");
//		restaurantEntity.setType("Non-Veg");
//		restaurantEntity.setLocation("Hyderabad");
//		restaurantRepo.save(restaurantEntity);

//		RestaurantEntity restaurantEntity = restaurantRepo.findById(6).get();
//		ItemsEntity itemsEntity = itemsRepo.findById(9).get();

//		ItemsEntity itemsEntity = new ItemsEntity();
//		itemsEntity.setName("Black Forest");
//		itemsEntity.setCategory("Desert");
//		itemsEntity.setCuisine("Italian");


//		Set<ItemsEntity> items = new HashSet<>();
//		items.addAll(restaurantEntity.getItems());
//		items.add(itemsEntity);
//		restaurantEntity.setItems(items);

//		System.out.println("before:- " +restaurantEntity.getItems());
//		restaurantEntity.getItems().add(itemsEntity);
//		System.out.println("After:- " +restaurantEntity.getItems());


//		restaurantRepo.save(restaurantEntity);

//		Set<RestaurantEntity> restaurants = new HashSet<>();
//		restaurants.addAll(itemsEntity.getRestaurantEntity());
//		restaurants.add(restaurantEntity);
//		itemsEntity.setRestaurantEntity(restaurants);
//
//		itemsRepo.save(itemsEntity);


//	}
}
