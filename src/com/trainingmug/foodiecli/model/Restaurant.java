package com.trainingmug.foodiecli.model;

import java.util.List;
import java.util.Objects;

public class Restaurant {

 /*
    add the following properties
    --------------------------------------
    Datatype                  variable
    --------------------------------------
    String                      id
    String                      name
    String                      address
    List<Dish>                  menu
     /

    /

1.All the fields should be private
2.Create only no-arg constructor
3.Create Getters and Setter methods
4.Override hashCode() and equals() methods
5.Override toString() methods
*/

    private String id;
    private String name;
    private String address;
    private List<Dish> menu;

    //no-agr constructor
    public Restaurant(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restarunt = (Restaurant) o;
        return Objects.equals(id, restarunt.id) && Objects.equals(name, restarunt.name) && Objects.equals(address, restarunt.address) && Objects.equals(menu, restarunt.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, menu);
    }

    @Override
    public String toString() {
        return "Restarunt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                '}';
    }
}
