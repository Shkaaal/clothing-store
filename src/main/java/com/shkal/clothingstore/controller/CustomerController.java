package com.shkal.clothingstore.controller;

import com.shkal.clothingstore.entity.Customer;
import com.shkal.clothingstore.exception_handling.NoSuchCustomerException;
import com.shkal.clothingstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return customerList;
    }

    @GetMapping("/customersOrderByName")
    public List<Customer> getAllCustomersOrderByName() {
        List<Customer> customerList = customerService.getAllCustomersOrderByName();
        return customerList;
    }

    @GetMapping("/customersOrderBySurname")
    public List<Customer> getAllCustomersOrderBySurname() {
        List<Customer> customerList = customerService.getAllCustomersOrderBySurname();
        return customerList;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);

        if (customer == null) {
            throw new NoSuchCustomerException("There is no Customer with ID = " +
                    id + " in Database");
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {

        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new NoSuchCustomerException("There is no Customer with ID = " +
                    id + " in Database");
        }
        customerService.deleteCustomer(id);
        return "Customer with ID " + id + " was deleted";
    }
}