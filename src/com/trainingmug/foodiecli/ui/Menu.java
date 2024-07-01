package com.trainingmug.foodiecli.ui;
import java.util.Scanner;

public class Menu {

    public Menu(){

    }

    public void displayMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO FOODIE APP");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Customer Section");
                System.out.println("2. Restaurant Section");
                System.out.println("3. Dishes Section");
                System.out.println("4. Order Section ");
                System.out.println("5. Exit");
                System.out.println("Please enter your choice (1-5)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> new CustomerMenu().displayMenu();
                    case 2 -> new RestaurantsMenu().displayMenu();
                    case 3 -> new DishesMenu().displayMenu();
                    case 4 -> new OrdersMenu().displayMenu();
                    case 5 -> {
                        System.out.println("Thanks for choosing Foodie App, See you again !");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");

                }
            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            e.printStackTrace();
            displayMenu();
        }
    }
    public void displayMenuHeader(String menuHeader) {
        printDashLine();
        String spaces = new String(new char[70]).replace('\0', ' ');
        System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
        printDashLine();
    }

    public void printDashLine(){
        String dashesLine = new String(new char[150]).replace('\0', '-');
        System.out.println(dashesLine);
    }






























//    private RestaurantController restaurantController;
//    private CustomerController customerController;
//
//    public Menu(){
//        this.customerController = Factory.getCustomerController();
//    }
//
//    public void displayMainMenu() {
//        try {
//            Scanner scanner = new Scanner(System.in);
//            while (true) {
//                displayMenuHeader("WELCOME TO FOODIE APP");
//                System.out.println();
//                System.out.println("Please select the option !");
//                System.out.println("--------------------------");
//                System.out.println("1. Register (New Customer)");
//                System.out.println("2. Login  (Existing Customer)");
//                System.out.println("3. View Restaurants");
//                System.out.println("4. View Dishes ");
//                System.out.println("5. Add Restaurant");
//                System.out.println("6. Add Dish");
//                System.out.println("7. Place Order");
//                System.out.println("8. View Orders");
//                System.out.println("9. Exit");
//
//                System.out.println("Please enter your choice (1-7)");
//
//                int input = scanner.nextInt();
//                switch (input) {
//                    case 1:
//                        customerRegisterForm();
//                        break;
//                    case 3:
//                        displayRestaurants();
//                        break;
//                    case 4:
//                        displayDishes();
//                        break;
//                    case 5:
//                        newRestaurantForm();
//                        break;
//                    case 6:
//                        newDishForm();
//                        break;
//                    case 7:
//
//                    case 9:
//                        System.out.println("Thanks for choosing Foodie App, See you again !");
//                        System.exit(0);
//                        break;
//
//                    default:
//                        System.out.println("Invalid Input. Please enter the valid input from(1-7)");
//
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Some internal error occurred. Please try again !");
//            e.printStackTrace();
//            displayMainMenu();
//        }
//    }
//
//    private void newDishForm() {
//    }
//
//    private void newRestaurantForm() {
//    }
//
//    private void displayDishes() {
//    }
//
//    private void displayRestaurants() {
//        List<Restaurant> restaurantList = this.restaurantController.getAllRestaurants();
//        System.out.println(restaurantList);
//    }
//
//    private void customerRegisterForm() {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Please enter the following details");
//            System.out.println("Enter ID :");
//            String id =  scanner.nextLine();
//            System.out.println("Enter Name");
//            String name = scanner.nextLine();
//            System.out.println("Enter E-mail");
//            String email = scanner.nextLine();
//            System.out.println("Enter Password");
//            String password = scanner.nextLine();
//
//            Customer customer = new Customer();
//            customer.setId(id)
//                    .setName(name)
//                    .setEmail(email)
//                    .setPassword(password);
//
//            try{
//            Customer saveCustomer = customerController.save(customer);
//        } catch (CustomerExistsException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void displayMenuHeader(String welcomeToFoodieApp) {
//    }
}
