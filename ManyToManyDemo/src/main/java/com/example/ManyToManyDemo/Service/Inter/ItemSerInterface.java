package com.example.ManyToManyDemo.Service.Inter;

import com.example.ManyToManyDemo.Model.ItemsModel;
import com.example.ManyToManyDemo.Model.RestaurantModel;

import java.util.List;

public interface ItemSerInterface  {
    public String add(ItemsModel itemsModel);
    public List<RestaurantModel> viewRestaurants();
    public List<ItemsModel> viewItems();
    public void addNewRestaurantToItems(int id, RestaurantModel restaurantModel);
    public void addExistRestaurantToItem(int restId, int itemId);
    public void deleteItem(int id);
    public List<RestaurantModel> viewRestaurantInItems(int id);
    public void restautantRemove(int restaurantID, int itemID);
    public ItemsModel getItem(int id);
    public void itemUpdate(ItemsModel itemsModel);

}
