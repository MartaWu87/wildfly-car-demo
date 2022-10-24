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
        logger.info("CustomerController method findAllCustomers");
        return entityManager.createNamedQuery("Customer.findAllCustomers", Customer.class).getResultList();
    }

    public Customer findById(Long customerId) {
        logger.info("CustomerController findById for id: {}", customerId);
        return entityManager.createNamedQuery("Customer.findById", Customer.class)
                .setParameter("id", customerId)
                .getSingleResult();
    }

    public Customer updateCustomer(Customer customer) {
        logger.info("CustomerController updateCustomer name: {} email: {}", customer.getName(), customer.getEmail());
        return entityManager.merge(customer);
    }

    public void deleteCustomer(Long customerId) {
        logger.info("CustomerController deleteCustomer for id: {}", customerId);
        entityManager.remove(findById(customerId));
    }

    public void addCustomer(Customer customer) {
        logger.info("CustomerController addCustomer name: {} email: {}", customer.getName(), customer.getEmail());
        entityManager.persist(customer);
    }

    public List<Customer> findLike(String prefix) {
        logger.info("CustomerController findLike customerName: {}%", prefix);
        return entityManager.createNamedQuery("Customers.startingWith", Customer.class)
                .setParameter("likeExpression", prefix + "%").getResultList();
    }


}
