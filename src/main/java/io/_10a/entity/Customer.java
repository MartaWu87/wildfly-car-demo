package io._10a.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
@NamedQueries({
@NamedQuery(
		name = "Customers.findAll",
		query = "SELECT c FROM Customer c"
),
@NamedQuery(
	name = "Customers.startingWith",
	query = "SELECT c FROM Customer c WHERE c.name LIKE :likeExpression"
)})
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
