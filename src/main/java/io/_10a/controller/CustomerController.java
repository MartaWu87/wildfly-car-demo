package io._10a.controller;

import io._10a.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @PersistenceContext
    EntityManager entityManager;

    public List<Customer> findAllCustomers() {
        return entityManager.createNamedQuery("Customer.findAllCustomers", Customer.class).getResultList();
    }

    public Customer findById(Long customerId) {
        return entityManager.createNamedQuery("Customer.findById", Customer.class)
                .setParameter("id", customerId)
                .getSingleResult();
    }

    public Customer updateCustomer(Customer customer) {
        return entityManager.merge(customer);
    }

    public void deleteCustomer(Long customerId) {
        entityManager.remove(findById(customerId));
    }

    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }



}
