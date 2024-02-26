package com.example.ManyToManyDemo.Controller;

import com.example.ManyToManyDemo.Model.ItemsModel;
import com.example.ManyToManyDemo.Model.RestaurantModel;
import com.example.ManyToManyDemo.Repository.RestaurantRepository;
import com.example.ManyToManyDemo.Service.RestaurantSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantSerImpl restaurantSer;

    public int restaurantID;
    public int itemID;

    @RequestMapping("/add")
    public String add(ModelMap model){
        RestaurantModel restaurantModel = new RestaurantModel();
        model.put("restaurantModel",restaurantModel);
        return "addRestaurant";
    }

    @PostMapping("/added")
    public String restaurantAdded(@ModelAttribute("restaurantModel") RestaurantModel restaurantModel){
        return restaurantSer.add(restaurantModel);
    }

    @RequestMapping("/view")
    public String view(ModelMap model){
        List<RestaurantModel> restaurants = restaurantSer.viewRestaurants();
        model.put("restaurants",restaurants);
        return "viewRestaurants";
    }

    @GetMapping("/addNewItem")
    public String addItemToRestaurant(@RequestParam("restaurantId") int id, ModelMap model){
        ItemsModel itemModel = new ItemsModel();
        model.put("itemModel",itemModel);
        restaurantID = id;
        return "addItemInRestaurant";
    }

    @PostMapping("/itemadded")
    public String itemAdded(@ModelAttribute("itemModel") ItemsModel itemsModel){
        restaurantSer.addNewItemsToRestaurant(restaurantID,itemsModel);
        return "itemAdded";
    }

    @GetMapping("/addExistItem")
    public String addExistItem(@RequestParam("restaurantId") int id,ModelMap model){
        restaurantID = id;
        List<ItemsModel> items = restaurantSer.viewItems();
        model.put("items",items);
        return "ViewItems";
    }

    @GetMapping("/existItemAdded")
    public String existItemAddedd(@RequestParam("itemId") int id){
        itemID = id;
        restaurantSer.addExistItemsToRestaurant(restaurantID,itemID);
        return "itemAdded";
    }

    @GetMapping("/update")
    private String update(@RequestParam("restaurantId") int id, ModelMap model){
        RestaurantModel restaurantModel = restaurantSer.getRestaurant(id);
        model.put("restaurantModel",restaurantModel);
        return "restaurantUpdate";
    }

    @PostMapping("/updated")
    private String restuarantUpdated(@ModelAttribute("restaurantModel") RestaurantModel restaurantModel){
        restaurantSer.restaurantUpdate(restaurantModel);
        return "redirect:/restaurant/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("restaurantId") int id){
        restaurantSer.deleteRestaurant(id);
        return "redirect:/restaurant/view";
    }

    @GetMapping("/viewItems")
    public String viewItems(@RequestParam("restaurantId") int id, ModelMap model){
        restaurantID = id;
        List<ItemsModel> items = restaurantSer.viewRestaurantItems(id);
        model.put("items",items);
        return "restaurantItems";
    }

    @GetMapping("/itemRemove")
    public String itemRemove(@RequestParam("itemId") int itemId){
        restaurantSer.itemRemove(restaurantID,itemId);
        return "redirect:/restaurant/viewItems?restaurantId=" + restaurantID;
    }
}
