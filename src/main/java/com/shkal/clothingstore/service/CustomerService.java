package com.shkal.clothingstore.service;

import com.shkal.clothingstore.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int id);

    public void saveCustomer(Customer customer);

    public void deleteCustomer(int id);
}
