package com.trainingmug.foodiecli.ui;

import com.trainingmug.foodiecli.controller.CustomerController;
import com.trainingmug.foodiecli.exceptions.CustomerExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.factory.Factory;
import com.trainingmug.foodiecli.model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu extends Menu {

    private final CustomerController customerController;

    public CustomerMenu(){
        this.customerController = Factory.getCustomerController();
    }
    public void displayMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO CUSTOMER SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Register (New Customer)");
                System.out.println("2. Login  (Existing Customer)");
                System.out.println("3. Search Customer");
                System.out.println("4. Display All Customers ");
                System.out.println("5. Update Customer");
                System.out.println("6. Delete Customer");
                System.out.println("7. Exit");

                System.out.println("Please enter your choice (1-7)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> customerRegisterForm();//saveCustomer,findCustomerById C-> Done
                    case 2 -> customerLoginForm();
                    case 3 -> searchCustomer();//findCustomerById R -> Done
                    case 4 -> displayAllCustomers();//getAllCustomers R ->Done
                    case 5 -> customerUpdate();//updateCustomers  U ->Done
                    case 6 -> deleteCustomer();//deleteCustomers  D ->Done
                    case 7 -> {
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

    private void deleteCustomer() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the following details to delete the Customer\n");

        try {
            System.out.print("Enter Customer Id: ");
            String id = scanner.nextLine();

            customerController.deleteCustomer(id);
            System.out.println("Customer Deleted Successfully");

        } catch (CustomerNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            displayMenu(); // displayMenu() showing the main menu again
        }
    }


    private void customerUpdate() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please update by entering the following details\n");

            System.out.print("Enter Your Id: ");
            String id = scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter E-mail: ");
            String email = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            Customer customerToUpdate = new Customer();
            customerToUpdate.setId(id)
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password);

            Customer updatedCustomer = customerController.updateCustomer(customerToUpdate);
            System.out.println("Customer Updated Successfully");
            displayCustomerDetails(updatedCustomer);

        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            customerUpdate(); // Recursive call to handle retry if an error occurs
        }finally {
            displayMenu(); // displayMenu() showing the main menu again
        }
    }



    private void displayAllCustomers() {
        List<Customer> customersList = this.customerController.getAllCustomers();

        // Print each customer's details
//        for (Customer customer : customersList) {
//            System.out.printf( customer.getCustomerId(), customer.getName(), customer.getEmail());
//        }


        for (Customer customer : customersList) {
            String customerId = customer.getCustomerId();
            String name = customer.getName();
            String email = customer.getEmail();

            //update the spacing using other methods
            String formattedOutput = customerId + "          " + name + "                               " + email;
            System.out.println(formattedOutput);
        }

    }

    private void searchCustomer() {
        try {
           Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Customer\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();


            Customer customer = customerController.findCustomerById(id);
            displayCustomerDetails(customer);//calling display method
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());

        }finally {
            displayMenu(); // displayMenu() showing the main menu again
        }
    }


    private void customerLoginForm() {
    }

    private void customerRegisterForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the following details");
        System.out.println("Enter ID :");
        String id = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter E-mail");
        String email = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();

        Customer customer = new Customer();
        customer.setId(id)
                .setName(name)
                .setEmail(email)
                .setPassword(password);
        try {
            Customer savedCustomer = customerController.save(customer);
            System.out.println("Customer Registration Successful");
            displayAllCustomers();
        } catch (CustomerExistsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            customerRegisterForm();
        }
    }

    public void displayCustomerDetails(Customer customer) {
        //displays only one customer
        displayMenuHeader("Customer Details");
        // This for  header
        System.out.println("Id         Name                              E-mail               Password");
        // method for separator line
        printDashLine();
        System.out.println(customer.getCustomerId() + "         " + customer.getName() + "                              " + customer.getEmail() +"                " +  customer.getPassword());

    }
    public void printDashLine() {
        System.out.println("-".repeat(120));
    }

}

