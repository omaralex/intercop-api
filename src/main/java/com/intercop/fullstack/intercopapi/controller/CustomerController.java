package com.intercop.fullstack.intercopapi.controller;

import com.intercop.fullstack.intercopapi.pojo.Customer;
import com.intercop.fullstack.intercopapi.pojo.ResponseGet;
import com.intercop.fullstack.intercopapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/kpideclientes")
    public ResponseGet getAverageStandardDeviation() throws InterruptedException, ExecutionException{
        return customerService.getAverageStandardDeviation();
    }

    @GetMapping("/listclientes")
    public List<Customer> customersList() throws InterruptedException, ExecutionException{
        return customerService.getAllCustomers();
    }

    @PostMapping("/creacliente")
    public String createPatient(@RequestBody Customer customer ) throws InterruptedException, ExecutionException {
        return customerService.saveCustomer(customer);
    }
}