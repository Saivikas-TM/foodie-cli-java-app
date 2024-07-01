package com.trainingmug.foodiecli.controller;

import com.trainingmug.foodiecli.exceptions.CustomerExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.service.CustomerServiceImp;

import java.util.List;

public class CustomerController {

    public CustomerServiceImp customerService;

    public CustomerController(CustomerServiceImp customerService){
        this.customerService = customerService;
    }
    public Customer save(Customer customer) throws CustomerExistsException {
        return customerService.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }

    public Customer findCustomerById(String id) throws CustomerNotFoundException {
        return this.customerService.findCustomerById(id);
    }

    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
        return this.customerService.updateCustomer(customer);
    }

    public void deleteCustomer(String id) throws CustomerNotFoundException{
        this.customerService.deleteCustomer(id);
    }
}
