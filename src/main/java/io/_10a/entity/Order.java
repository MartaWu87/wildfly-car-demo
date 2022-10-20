package io._10a.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MODEL_ID")
    @OneToMany
    private List<Model> modelList;

    @Column(name = "CUSTOMER_ID")
    @OneToMany
    private List<Customer> customerList;

    @Column(name = "ORDER_DATE)")
    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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
