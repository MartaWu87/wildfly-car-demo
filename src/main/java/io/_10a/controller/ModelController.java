package io._10a.controller;

import io._10a.entity.Customer;
import io._10a.entity.Model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ModelController {

    @PersistenceContext
    EntityManager entityManager;

    public List<Model> findAll() {
        return entityManager.createNamedQuery("Model.findAll", Model.class).getResultList();
    }

    public List<Model> findLike(String prefix) {
        return entityManager.createNamedQuery("Model.startingWith", Model.class)
                .setParameter("likeExpression", prefix + "%").getResultList();
    }
}
