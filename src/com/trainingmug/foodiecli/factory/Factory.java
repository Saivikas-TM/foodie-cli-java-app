package com.trainingmug.foodiecli.factory;

import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.controller.RestaurantController;
import com.trainingmug.foodiecli.repository.CustomerRepository;
import com.trainingmug.foodiecli.repository.RestaurantRepository;
import com.trainingmug.foodiecli.service.CustomerServiceImp;
import com.trainingmug.foodiecli.service.RestaurantService;
import com.trainingmug.foodiecli.service.RestaurantServiceImp;
import com.trainingmug.foodiecli.util.CsvReader;

public class Factory {
    public static CsvReader getCsvReader(){
        return new CsvReader();
    }
    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }

    public static CustomerServiceImp getCustomerService(){
        return new CustomerServiceImp(getCustomerRepository());
    }

    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerService());
    }

    public static RestaurantRepository getRestaurantRepository(){
        return new RestaurantRepository();
    }

    public static RestaurantServiceImp getRestaurantService(){
        return new RestaurantServiceImp(getRestaurantRepository());
    }

    public static RestaurantController getRestaurantController(){
        return new RestaurantController(getRestaurantService());
    }
}
