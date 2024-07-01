package com.trainingmug.foodiecli.repository;

import com.trainingmug.foodiecli.factory.Factory;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.service.CustomerService;
import com.trainingmug.foodiecli.util.CsvReader;

import java.lang.management.OperatingSystemMXBean;
import java.security.PublicKey;
import java.util.List;
import java.util.Optional;


public class RestaurantRepository {
    private List<Restaurant> restaurantList;

    public RestaurantRepository() {
        this.restaurantList = Factory.getCsvReader().readRestaurantsFromCsv();
    }

    public List<Restaurant> getAllResturants() {
        return this.restaurantList;
    }

    public Restaurant saveResturant(Restaurant resturant) {
        this.restaurantList.add(resturant);
        return resturant;
    }

    public Optional<Restaurant> findRestaurantById(String id) {
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }

    public Restaurant updateRestaurant(Restaurant updatedrestaurant) {
        for (int i=0; i<restaurantList.size(); i++){
            Restaurant restaurant = this.restaurantList.get(i);
            if(restaurant.getId().equals(updatedrestaurant.getId())){
                //update
//                restaurant.setId(updatedrestaurant.getId());//ID updation does not requried
                restaurant.setName(updatedrestaurant.getName());
                restaurant.setAddress(updatedrestaurant.getAddress());
                restaurant.setMenu(updatedrestaurant.getMenu());
                return restaurant;
            }
        }
        return null;
    }


    public void deleteRestaurant(Restaurant restaurant){
        for (int i=0; i<restaurantList.size(); i++){
            if(restaurantList.get(i).equals(restaurant.getId())){
                restaurantList.remove(i);
                break;
            }
        }
    }
}