package io._10a.controller;

import io._10a.entity.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerController {

	@PersistenceContext
	EntityManager entityManager;

	public List<Customer> findAll() {
		return entityManager.createNamedQuery("Customers.findAll", Customer.class).getResultList();
	}

	public List<Customer> findLike(String prefix) {
		return entityManager.createNamedQuery("Customers.startingWith", Customer.class)
				.setParameter("likeExpression", prefix + "%").getResultList();
	}

}
