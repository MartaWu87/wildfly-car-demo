package io._10a;
import io._10a.controller.CustomerController;
import io._10a.entity.Customer;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CustomerBean implements Serializable {

	@Inject
	CustomerController customerController;

	private List<Customer> customers;

	private String filter;

	@PostConstruct
	public void init() {
		customers = customerController.findAll();
	}

	public List<Customer> getAllCustomers() {
		return customers;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;

	}

	public void takeAction() {
		this.customers = customerController.findLike(filter);
	}
}
