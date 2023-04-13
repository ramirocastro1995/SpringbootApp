package com.example.demo.api.Controllers;


import com.example.demo.api.Model.Customer;
import com.example.demo.api.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/customers")
public class CustomerController {
    @Autowired(required = false)
    private CustomerRepository customerRepository;
    //Create new customer
    @PostMapping(path="/add")
    public Customer addNewCustomer(@RequestBody Customer newCustomer){
        Customer user = new Customer();
        user.setName(newCustomer.getName());
        user.setEmail(newCustomer.getEmail());
        customerRepository.save(user);
        return user;
    }
    //view all customers
    @GetMapping(path="view/all")
    public @ResponseBody Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    //view specific customer
    @GetMapping(path="view/{id}")
    public Optional<Customer> getCustomer(@PathVariable Integer id){
        return customerRepository.findById(id);
    }
    //update an existing customer
    @PutMapping(path="/edit/{id}")
    public String update(@RequestBody Customer updateCustomer,@PathVariable Integer id){
        return customerRepository.findById(id)
                .map(customer ->{
                    customer.setName(updateCustomer.getName());
                    customer.setEmail(updateCustomer.getEmail());
                    customerRepository.save(customer);
                    return "Customer has been successfully updated";
                }).orElseGet(()->{
                    return "this customer doesn't exist";
                });
    }
    //Delete customer
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        customerRepository.deleteById(id);
        return "Customer has been successfully deleted";
    }
}
