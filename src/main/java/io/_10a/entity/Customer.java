package io._10a.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
@NamedQueries({
		@NamedQuery(
				name = "Customer.findAllCustomers",
				query = "SELECT c FROM Customer c ORDER BY c.id DESC"
		),
		@NamedQuery(
				name = "Customer.findById",
				query = "SELECT c FROM Customer c WHERE c.id=:id"
		)})
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name="EMAIL")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
}
