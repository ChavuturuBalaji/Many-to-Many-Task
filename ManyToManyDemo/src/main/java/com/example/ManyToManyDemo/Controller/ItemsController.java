package com.example.ManyToManyDemo.Controller;

import com.example.ManyToManyDemo.Model.ItemsModel;
import com.example.ManyToManyDemo.Model.RestaurantModel;
import com.example.ManyToManyDemo.Service.ItemsSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemsController {

    @Autowired
    ItemsSerImpl itemsSer;
    public int restaurantID;
    public int itemID;

    @RequestMapping("/add")
    public String add(ModelMap model){
        ItemsModel itemModel = new ItemsModel();
        model.put("itemModel",itemModel);
        return "addItem";
    }

    @PostMapping("/added")
    public String restaurantAdded(@ModelAttribute("itemModel") ItemsModel itemsModel){
        System.out.println(itemsModel.getName());
        return itemsSer.add(itemsModel);
    }

    @RequestMapping("/view")
    public String view(ModelMap model){
        List<ItemsModel> items = itemsSer.viewItems();
        model.put("items",items);
        return "itemsView";
    }

    @GetMapping("/addNewRestaurant")
    public String addNewRestaurant(@RequestParam("itemId") int id, ModelMap model){
        RestaurantModel restaurantModel = new RestaurantModel();
        model.put("restaurantModel",restaurantModel);
        itemID = id;
        return "addRestauarantInItem";
    }
    @PostMapping("/restaurantadded")
    public String restaurantAdded(@ModelAttribute("restaurantModel") RestaurantModel restaurantModel){
        itemsSer.addNewRestaurantToItems(itemID,restaurantModel);
        return "restaurantAdded";
    }
    @GetMapping("/addExistRestaurant")
    public String addExistItem(@RequestParam("itemId") int id,ModelMap model){
        itemID = id;
        List<RestaurantModel> restaurants = itemsSer.viewRestaurants();
        model.put("restaurants",restaurants);
        return "restaurantView";
    }

    @GetMapping("/existRestaurantAdded")
    public String existRestaurantAddedd(@RequestParam("restaurantId") int id){
        restaurantID = id;
        itemsSer.addExistRestaurantToItem(restaurantID,itemID);
        return "restaurantAdded";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int itemId){
        itemsSer.deleteItem(itemId);
        return "redirect:/item/view";
    }

}
