package com.shkal.clothingstore.service;

import com.shkal.clothingstore.dao.CustomerDAO;
import com.shkal.clothingstore.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {

    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {

    }
}
