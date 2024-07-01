package com.trainingmug.foodiecli.repository;

import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.util.CsvReader;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private List<Customer> customerList;

    public CustomerRepository(){
        CsvReader csvReader = new CsvReader();
        this.customerList = csvReader.readCustomersFromCsv();
    }
    public List<Customer> getAllCustomers(){
        return this.customerList;
    }

    public Customer saveCustomer(Customer customer){
        this.customerList.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerById(String id) {
        return this.customerList.stream().filter(customer -> customer.getCustomerId().equals(id)).findFirst();
    }

    public Customer updateCustomer(Customer customerToBeUpdated) {
        for (int i = 0; i < this.customerList.size(); i++) {
            Customer customer = this.customerList.get(i);
            if (customer.getCustomerId().equals(customerToBeUpdated.getCustomerId())) {
                //we will update
                customer.setName(customerToBeUpdated.getName());
                customer.setEmail(customerToBeUpdated.getEmail());
                customer.setPassword(customerToBeUpdated.getPassword());
                return customer;
            }
        }
        return null;
    }


    public void deleteCustomer(Customer customer){
        for(int i=0; i<customerList.size(); i++){
            if (customerList.get(i).equals(customer)){
                //remove the customer
                customerList.remove(i);
                break;
            }
        }
    }
}

