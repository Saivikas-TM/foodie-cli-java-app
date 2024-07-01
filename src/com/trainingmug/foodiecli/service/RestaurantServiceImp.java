package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.RestaurantExistException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.model.Restaurant;
import com.trainingmug.foodiecli.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

public class RestaurantServiceImp implements RestaurantService{

    public RestaurantRepository restaurantRepository;

    public RestaurantServiceImp(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }
    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantExistException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if (restaurantById.isPresent()){
            throw new RestaurantExistException("this Restaurant is already exists with the ID :" + restaurant.getId());
        }
        return this.restaurantRepository.saveResturant(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return this.restaurantRepository.getAllResturants();
    }

    @Override
    public Restaurant findRestaurantById(String id) throws RestaurantNotFoundException {
      Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
      if (restaurantById.isEmpty())
          throw new RestaurantNotFoundException("No Restaurant fount with thid ID:" + id);
      return restaurantById.get();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if (restaurantOptional.isEmpty()){
            throw new RestaurantNotFoundException("Restaurant Does not Exist with this ID: " + restaurant.getId());
        }
        return this.restaurantRepository.updateRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findRestaurantById(id);
        if (optionalRestaurant.isEmpty())
            throw new RestaurantNotFoundException("Restaurant does not exist with this id:" + id);
        this.restaurantRepository.deleteRestaurant(optionalRestaurant.get());
    }


}
