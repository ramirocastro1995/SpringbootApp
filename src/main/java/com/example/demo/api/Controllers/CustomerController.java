package com.example.demo.api.Controllers;

import com.example.demo.api.Model.Customer;
import com.example.demo.api.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository customerRepository;
    //Create new customer
    @GetMapping("/add")
    public Customer addNewCustomer(@RequestBody Customer newCustomer){
        Customer user = new Customer();
        user.setName(newCustomer.getName());
        user.setEmail(newCustomer.getEmail());
        customerRepository.save(user);
        return user;
    }
    //view all customers
    @GetMapping("view/all")
    public @ResponseBody Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    //view specific customer
    @GetMapping("view/{id}")
    public Optional<Customer> getCustomer(@PathVariable Integer id){
        return customerRepository.findById(id);
    }
    //update an existing customer
    @PutMapping("edit/{id}")
    public String update(@RequestBody Customer updateCustomer,@PathVariable Integer id){
        return customerRepository.findById(id)
                .map(customer ->{
                    customer.setName(updateCustomer.getName());
                    customer.setEmail(updateCustomer.getEmail());
                    customerRepository.save(customer);
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
