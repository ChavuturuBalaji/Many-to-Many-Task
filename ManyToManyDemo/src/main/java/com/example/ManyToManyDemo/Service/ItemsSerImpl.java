package com.example.ManyToManyDemo.Service;

import com.example.ManyToManyDemo.Entity.ItemsEntity;
import com.example.ManyToManyDemo.Entity.RestaurantEntity;
import com.example.ManyToManyDemo.Model.ItemsModel;
import com.example.ManyToManyDemo.Model.RestaurantModel;
import com.example.ManyToManyDemo.Repository.ItemsRepository;
import com.example.ManyToManyDemo.Repository.RestaurantRepository;
import com.example.ManyToManyDemo.Service.Inter.ItemSerInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemsSerImpl implements ItemSerInterface {

    @Autowired
    ItemsRepository itemsRepo;

    @Autowired
    RestaurantRepository restaurantRepo;

    @Override
    public String add(ItemsModel itemsModel){
        if(itemsModel.getName().isBlank() || itemsModel.getCategory().isBlank() || itemsModel.getCuisine().isBlank()){
            return "nullValues";
        } else if (itemsRepo.findAll().stream().anyMatch(i -> i.getName().equalsIgnoreCase(itemsModel.getName()))) {
            return "duplicateItem";
        }
        ItemsEntity itemsEntity = new ItemsEntity();
        BeanUtils.copyProperties(itemsModel,itemsEntity);
        itemsRepo.save(itemsEntity);
        return "itemAdded";
    }

    @Override
    public List<RestaurantModel> viewRestaurants(){
        List<RestaurantEntity> restaurantEntities= restaurantRepo.findAll();
        List<RestaurantModel> restaurantModels = new ArrayList<>();
        for(RestaurantEntity rest : restaurantEntities){
            RestaurantModel model = new RestaurantModel();
            model.setRestaurantID(rest.getRestaurantID());
            model.setName(rest.getName());
            model.setType(rest.getType());
            model.setLocation(rest.getLocation());
            restaurantModels.add(model);
        }
        return restaurantModels;
    }

    @Override
    public List<ItemsModel> viewItems(){
        List<ItemsEntity> itemsEntities= itemsRepo.findAll();
        List<ItemsModel> itemsModels = new ArrayList<>();
        for(ItemsEntity item : itemsEntities){
            ItemsModel model = new ItemsModel();
            model.setItemID(item.getItemID());
            model.setName(item.getName());
            model.setCategory(item.getCategory());
            model.setCuisine(item.getCuisine());
            itemsModels.add(model);
        }
        return itemsModels;
    }


    @Override
    public void addNewRestaurantToItems(int id, RestaurantModel restaurantModel){
        ItemsEntity itemsEntity = itemsRepo.findById(id).get();
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        BeanUtils.copyProperties(restaurantModel,restaurantEntity);
        Set<RestaurantEntity> restaurants = new HashSet<>();
        restaurants.addAll(itemsEntity.getRestaurantEntity());
        restaurants.add(restaurantEntity);
        itemsEntity.setRestaurantEntity(restaurants);
        restaurantRepo.save(restaurantEntity);
        itemsRepo.save(itemsEntity);
    }


    @Override
    public void addExistRestaurantToItem(int restId, int itemId){
        RestaurantEntity restaurantEntity = restaurantRepo.findById(restId).get();
        ItemsEntity itemsEntity = itemsRepo.findById(itemId).get();
        Set<RestaurantEntity> restaurants = new HashSet<>();
        restaurants.addAll(itemsEntity.getRestaurantEntity());
        restaurants.add(restaurantEntity);
        itemsEntity.setRestaurantEntity(restaurants);
        System.out.println("123:- " + itemsEntity.getRestaurantEntity());
        itemsRepo.save(itemsEntity);
    }

    @Override
    @Transactional
    public void deleteItem(int id){
        itemsRepo.deleteItemsAndMappings(id);
    }
}

