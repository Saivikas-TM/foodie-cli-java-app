package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.RestaurantExistException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant save(Restaurant restaurant) throws RestaurantExistException;
    public List<Restaurant> getAllRestaurant();

    public  Restaurant findRestaurantById(String id) throws RestaurantNotFoundException;

    public Restaurant updateRestaurant(Restaurant restaurant)throws RestaurantNotFoundException;

    public void deleteRestaurant(String id)throws RestaurantNotFoundException;

}
