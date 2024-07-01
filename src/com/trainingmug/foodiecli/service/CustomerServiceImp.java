package com.trainingmug.foodiecli.service;
import com.trainingmug.foodiecli.exceptions.CustomerExistsException;
import com.trainingmug.foodiecli.exceptions.CustomerNotFoundException;
import com.trainingmug.foodiecli.model.Customer;
import com.trainingmug.foodiecli.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImp implements CustomerService {

    public CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistsException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getCustomerId());
        if (customerById.isPresent())
            throw new CustomerExistsException("This Customer is Exists with the Id  :" + customer.getCustomerId());
        return this.customerRepository.saveCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getAllCustomers();
    }

    @Override
    public Customer findCustomerById(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if (customerById.isEmpty())
            throw new CustomerNotFoundException("Customer not found :" + id);
        return customerById.get();
    }

    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getCustomerId());
        if (customerById.isEmpty())
            throw new CustomerNotFoundException("Customer Not Exists with this ID : " + customer.getCustomerId());
        return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer Not Exists with this ID : " + id);
        this.customerRepository.deleteCustomer(customerById.get());
    }

    }
