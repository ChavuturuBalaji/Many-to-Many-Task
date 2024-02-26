package com.example.ManyToManyDemo.Service;

import com.example.ManyToManyDemo.Entity.ItemsEntity;
import com.example.ManyToManyDemo.Entity.RestaurantEntity;
import com.example.ManyToManyDemo.Model.ItemsModel;
import com.example.ManyToManyDemo.Model.RestaurantModel;
import com.example.ManyToManyDemo.Repository.ItemsRepository;
import com.example.ManyToManyDemo.Repository.RestaurantRepository;
import com.example.ManyToManyDemo.Service.Inter.RestaurantSerInterface;
import jakarta.persistence.EntityManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RestaurantSerImpl implements RestaurantSerInterface {
    @Autowired
    EntityManager entityManager;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ItemsRepository itemsRepo;

    @Override
    public String add(RestaurantModel restaurantModel){
        if(restaurantModel.getName().isBlank() || restaurantModel.getType().isBlank() || restaurantModel.getLocation().isBlank()){
            return "nullValues";
        } else if (restaurantRepository.findAll().stream().anyMatch(i -> i.getName().equalsIgnoreCase(restaurantModel.getName()) && i.getLocation().equalsIgnoreCase(restaurantModel.getLocation()))) {
            return "duplicateRestaurant";
        }
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        BeanUtils.copyProperties(restaurantModel,restaurantEntity);
        restaurantRepository.save(restaurantEntity);
        return "restaurantAdded";
    }

    @Override
    public void addNewItemsToRestaurant(int id, ItemsModel itemsModel){
        RestaurantEntity restaurantEntity = restaurantRepository.findById(id).get();
        ItemsEntity itemsEntity = new ItemsEntity();
        BeanUtils.copyProperties(itemsModel,itemsEntity);
        Set<ItemsEntity> items = new HashSet<>();
        items.addAll(restaurantEntity.getItems());
        items.add(itemsEntity);
        restaurantEntity.setItems(items);
        itemsRepo.save(itemsEntity);
        restaurantRepository.save(restaurantEntity);
    }

    @Override
    public void addExistItemsToRestaurant(int restId, int itemId){
        RestaurantEntity restaurantEntity = restaurantRepository.findById(restId).get();
        ItemsEntity itemsEntity = itemsRepo.findById(itemId).get();
        Set<ItemsEntity> items = new HashSet<>();
        items.addAll(restaurantEntity.getItems());
        items.add(itemsEntity);
        restaurantEntity.setItems(items);
        restaurantRepository.save(restaurantEntity);
    }

    @Override
    public List<RestaurantModel> viewRestaurants(){
        List<RestaurantEntity> restaurantEntities= restaurantRepository.findAll();
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
    @Transactional
    public void deleteRestaurant(int id){
        restaurantRepository.deleteRestaurantAndMappings(id);
    }

    @Override
    public List<ItemsModel> viewRestaurantItems(int id){
        RestaurantEntity restaurantEntity = restaurantRepository.findById(id).get();
        Set<ItemsEntity> itemsEntities= restaurantEntity.getItems();
        List<ItemsModel> itemsModels = new ArrayList<>();
        for(ItemsEntity item : itemsEntities) {
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
    public void itemRemove(int restaurantID, int itemID){
        RestaurantEntity restaurantEntity = restaurantRepository.findById(restaurantID).get();
        ItemsEntity itemsEntity = itemsRepo.findById(itemID).get();
        restaurantEntity.getItems().remove(itemsEntity);
        restaurantRepository.save(restaurantEntity);
    }
}

