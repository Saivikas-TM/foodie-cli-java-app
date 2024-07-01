package com.trainingmug.foodiecli;

import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.repository.CustomerRepository;
import com.trainingmug.foodiecli.repository.RestaurantRepository;
import com.trainingmug.foodiecli.ui.Menu;
import com.trainingmug.foodiecli.util.CsvReader;

public class Main {
    public static void main(String[] args) {

//        CsvReader csvReader = new CsvReader();
//        System.out.println(csvReader.readCustomersFromCsv());

//        CustomerRepository customerRepository = new CustomerRepository();
//        System.out.println(customerRepository.getAllCustomers());

//        RestaurantRepository restaurantRepository = new RestaurantRepository();
//        System.out.println(restaurantRepository.getAllResturants());


          Menu menu = new Menu();
          menu.displayMenu();



    }
}