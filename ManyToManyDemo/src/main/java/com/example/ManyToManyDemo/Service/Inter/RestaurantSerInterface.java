package com.example.ManyToManyDemo.Service.Inter;

import com.example.ManyToManyDemo.Model.ItemsModel;
import com.example.ManyToManyDemo.Model.RestaurantModel;

import java.util.List;

public interface RestaurantSerInterface {
    public String add(RestaurantModel restaurantModel);
    public List<RestaurantModel> viewRestaurants();
    public void addNewItemsToRestaurant(int id, ItemsModel itemsModel);
    public void addExistItemsToRestaurant(int restId, int itemId);
    public List<ItemsModel> viewItems();
    public void deleteRestaurant(int id);
    public List<ItemsModel> viewRestaurantItems(int id);
    public void itemRemove(int restaurantID, int itemID);
    public RestaurantModel getRestaurant(int id);
    public void restaurantUpdate(RestaurantModel restaurantModel);
}
