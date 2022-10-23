package io._10a.controller;

import io._10a.entity.Model;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ModelController {

    @PersistenceContext
    EntityManager entityManager;

    public List<Model> findAllModels() {
        return entityManager.createNamedQuery("Model.findAllModels", Model.class).getResultList();
    }

    public Model findById(Long id) {
        return entityManager.createNamedQuery("Model.findById", Model.class)
                .setParameter("id", id)
                .getSingleResult();
    }


    public List<Model> findModel(String modelName, String modelEngine, String modelDriveTrain, String modelTransmission, String modelVersion) {
        return entityManager.createNamedQuery("Model.findModel", Model.class)
                .setParameter("modelName", modelName)
                .setParameter("modelEngine", modelEngine)
                .setParameter("modelDriveTrain", modelDriveTrain)
                .setParameter("modelTransmission", modelTransmission)
                .setParameter("modelVersion", modelVersion)
                .getResultList();
    }
}
