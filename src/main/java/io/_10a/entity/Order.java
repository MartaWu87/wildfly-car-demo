package io._10a.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @JoinColumn(name = "MODEL_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Model model;

    @JoinColumn(name = "CUSTOMER_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @Column(name = "ORDER_DATE)")
    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @PrePersist
    @PreUpdate
    public void setOrderDate() {
        this.orderDate = new Date();
    }
}
