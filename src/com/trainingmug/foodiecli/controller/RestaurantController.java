package com.trainingmug.foodiecli.controller;

import com.trainingmug.foodiecli.exceptions.RestaurantExistException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.service.RestaurantServiceImp;

import java.util.List;

public class RestaurantController {
    RestaurantServiceImp restaurantService;

    public RestaurantController(RestaurantServiceImp restaurantService){
        this.restaurantService = restaurantService;
    }


    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantExistException {
        return restaurantService.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants(){
        return this.restaurantService.getAllRestaurant();
    }

    public Restaurant findRestaurantById(String id) throws RestaurantNotFoundException {
        return this.restaurantService.findRestaurantById(id);
    }

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException{
        return this.restaurantService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(String id) throws RestaurantNotFoundException{
        this.restaurantService.deleteRestaurant(id);
    }
}
