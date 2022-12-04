package com.shkal.clothingstore.dao;

import com.shkal.clothingstore.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int id);

    public void saveCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int id);
}
