package com.trainingmug.foodiecli.model;

import java.util.List;
import java.util.Objects;

public class Dish {
    /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    Customer                    customer
    Restaurant                  restaurant
    List<Dish>                  dishes
    double                      price
     /

             /

    All the fields should be private
    Create only no-arg constructor
    Create Getters and Setter methods
    Override hashCode() and equals() methods
    Override toString() methods
*/
        private String id;
        private Customer customer;
        private Restaurant restaurant;
        private List<Dish> dishes;
        private double price;

        // No-arg constructor
        public Dish() {}

        // Getters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override hashCode() method


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.price, price) == 0 && Objects.equals(id, dish.id) && Objects.equals(customer, dish.customer) && Objects.equals(restaurant, dish.restaurant) && Objects.equals(dishes, dish.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, restaurant, dishes, price);
    }

    // Override toString() method
        @Override
        public String toString() {
            return "Dish{" +
                    "id='" + id + '\'' +
                    ", customer=" + customer +
                    ", restaurant=" + restaurant +
                    ", dishes=" + dishes +
                    ", price=" + price +
                    '}';
        }
    }


