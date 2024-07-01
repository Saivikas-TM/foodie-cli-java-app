package com.trainingmug.foodiecli.ui;

import com.sun.source.tree.TryTree;
import com.trainingmug.foodiecli.controller.RestaurantController;
import com.trainingmug.foodiecli.exceptions.RestaurantExistException;
import com.trainingmug.foodiecli.exceptions.RestaurantNotFoundException;
import com.trainingmug.foodiecli.factory.Factory;
import com.trainingmug.foodiecli.model.Restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RestaurantsMenu extends Menu{

    private RestaurantController restaurantController;

    public RestaurantsMenu(){
        this.restaurantController = Factory.getRestaurantController();
    }


    public void displayMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO RESTAURANT SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Add/save New Restaurant");
                System.out.println("2. View All Restaurants");
                System.out.println("3. Search Restaurant");
                System.out.println("4. Update Restaurant ");
                System.out.println("5. Delete Restaurant");
                System.out.println("6. Exit");

                System.out.println("Please enter your choice (1-6)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> saveRestaurant();
                    case 2 -> displayAllRestaurants();
                    case 3 -> SearchRestaurant();//byId
                    case 4 -> UpdateRestaurant();
                    case 5 -> DeleteRestaurant();
                    case 6 -> {
                        System.out.println("Thank you , See you again !");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");

                }
            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }

    private void DeleteRestaurant() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter the following Details:");
            System.out.println("Enter Id:");
            String id = scanner.nextLine();
            restaurantController.deleteRestaurant(id);
            System.out.println("Restaurant deleted sucessfully");
        }catch (RestaurantNotFoundException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Please try again");
            displayMenu();
        }
    }

    private void UpdateRestaurant() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details");
            System.out.println("Enter Restaurant Id:");
            String id = scanner.nextLine();
            System.out.println("Enter Restaurant Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Restaurant Address");
            String address = scanner.nextLine();
            System.out.println("Enter Menu Dish Items Saperated By :");
            String menu = scanner.nextLine();
            Restaurant restaurant = new Restaurant();
            restaurant.setId(id)
                    .setName(name)
                    .setAddress(address)
                    .setMenu(Arrays.asList(menu.split(":")));
            Restaurant updateRestaurant = restaurantController.updateRestaurant(restaurant);
            System.out.println("update sucessfull");
            //method to call restaurant
            displayRestaurant(updateRestaurant);
        }catch (RestaurantNotFoundException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Please Try Again");
            displayMenu();
        }
    }

    private void SearchRestaurant() {

        try {
            Scanner scanner= new Scanner(System.in);
            System.out.println("Please enter the following details");
            System.out.println("Enter ID:");
            String id = scanner.nextLine();
            Restaurant searchRestaurant = this.restaurantController.findRestaurantById(id);
            //here need a method to display single restaurant details
            displayRestaurant(searchRestaurant);
        } catch (RestaurantNotFoundException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            System.out.println("Please try again");
            displayMenu();
        }
    }


    //displays every restaurant in the list
    private void displayAllRestaurants() {
        List<Restaurant> restaurantList = this.restaurantController.getAllRestaurants();

        for(Restaurant restaurant : restaurantList){
            String id = restaurant.getId();
            String name = restaurant.getName();
            String address = restaurant.getAddress();
            String menu = String.join(":", restaurant.getMenu());

            System.out.println(restaurant);
        }
    }

    private void saveRestaurant() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter the following details\n");
            System.out.println("Enter ID:");
            String id = scanner.nextLine();
            System.out.println("Enter Restaurant Name:");
            String name = scanner.nextLine();
            System.out.println("Please Enter Address");
            String address = scanner.nextLine();
            System.out.println("Enter Dishes for Menu separated by : (D010:D009)");
            String menu = scanner.nextLine();
            Restaurant restaurant = new Restaurant();
            restaurant.setId(id)
                    .setName(name)
                    .setAddress(address)
                    .setMenu(Arrays.asList(menu.split(":")));

            Restaurant saveRestaurant = restaurantController.saveRestaurant(restaurant);

            //here we need  method to displayAllReastaurants
            displayAllRestaurants();

        } catch (RestaurantExistException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Error");
            displayMenu();
        }
    }

    public void displayRestaurant(Restaurant restaurant){
        displayMenuHeader("Customer Details By Id");

        System.out.println("Id                   Name                           Address                                           Menu");
        printDashLine();
        System.out.println(restaurant.getId() + "           " + restaurant.getName() + "                  " + restaurant.getAddress() + "                           " + restaurant.getMenu());
    }

}