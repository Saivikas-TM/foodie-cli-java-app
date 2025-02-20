package com.trainingmug.foodiecli.service;

import com.trainingmug.foodiecli.exceptions.CustomerExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistsException;
    public List<Customer> getAllCustomers();

    public Customer findCustomerById(String id) throws CustomerNotFoundException;

    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
    public void deleteCustomer(String id) throws CustomerNotFoundException;
}
