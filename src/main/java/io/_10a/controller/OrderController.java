package io._10a.controller;

import io._10a.OrderBean;
import io._10a.entity.Customer;
import io._10a.entity.Model;
import io._10a.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderController {

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PersistenceContext
    EntityManager entityManager;

    public void createOrder(Model model, Customer customer){
        Order order = new Order();
        order.setModel(model);
        order.setCustomer(customer);
        entityManager.persist(order);
        logger.info("created: {} {}", order.getModel().getId(), order.getCustomer().getId());
    }
}
