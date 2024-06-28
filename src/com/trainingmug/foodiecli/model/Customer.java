package com.trainingmug.foodiecli.model;

import java.util.List;
import java.util.Objects;

public class Customer {
    /*
      add the following properties
      --------------------------------------
      Datatype                  variable
      --------------------------------------
      String                      id
      String                      name
      String                      email
      String                      password
       /

      /

 1. All the fields should be private
 2. Create only no-arg constructor
  3.Create Getters and Setter methods
 4. Override hashCode() and equals() methods
 5. Override toString() methods
  */
  private String id;

    private String name;

    private String email;

    private String password;

    private List<Order> orderHistory;

    // Getter for customerId
    public String getCustomerId() {
        return id;
    }

    // Setter for customerId
    public Customer setId(String id) {
        this.id = id;
        return this;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && Objects.equals(orderHistory, customer.orderHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, orderHistory);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orderHistory=" + orderHistory +
                '}';
    }
}

