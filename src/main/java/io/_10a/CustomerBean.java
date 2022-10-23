package io._10a;

import io._10a.controller.CustomerController;
import io._10a.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CustomerBean implements Serializable {

    Logger logger = LoggerFactory.getLogger(CustomerBean.class);

    @Inject
    CustomerController customerController;

    private Long id;
    private String name;
    private String email;

//    Methods

    @PostConstruct
    public void init() {
    }

    public void addCustomer() {
        Customer customer = new Customer();
        logger.info("name: {}", name);
        logger.info("email: {}", email);
        customer.setName(name);
        customer.setEmail(email);
        customerController.addCustomer(customer);
    }

    public void loadCustomer(Long customerId) {
        Customer customer = customerController.findById(customerId);
        setName(customer.getName());
        setEmail(customer.getEmail());
        setId(customer.getId());
    }

    public void updateCustomer() {
        Customer customer = new Customer();
        logger.info("name: {}", name);
        logger.info("email: {}", email);
        customer.setName(name);
        customer.setEmail(email);
        customer.setId(id);
        customerController.updateCustomer(customer);
    }

    public void deleteCustomer(Long customerId) {
        customerController.deleteCustomer(customerId);
    }

    public List<Customer> loadCustomers(){
        return customerController.findAllCustomers();
    }

//    Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
