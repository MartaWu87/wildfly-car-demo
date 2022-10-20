package io._10a;

import io._10a.controller.ModelController;
import io._10a.entity.Customer;
import io._10a.entity.Model;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ModelBean implements Serializable {

    @Inject
    ModelController modelController;

    private List<Model> models;

    private String filter;

    @PostConstruct
    public void init() {
        models = modelController.findAll();
    }

    public List<Model> getAllModels() {
        return models;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void takeAction() {
        this.models = modelController.findLike(filter);
    }
}
