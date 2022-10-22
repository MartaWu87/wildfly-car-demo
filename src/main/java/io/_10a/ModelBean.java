package io._10a;

import io._10a.controller.ModelController;
import io._10a.entity.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class ModelBean implements Serializable {

    Logger logger = LoggerFactory.getLogger(ModelBean.class);

    @Inject
    ModelController modelController;

    private List<Model> models;
    private List<Model> modelsFilter;
    private List<String> names;
    private List<String> engines;
    private List<String> driveTrains;
    private List<String> transmissions;
    private List<String> versions;
    private String modelName;
    private String modelEngine;
    private String modelDriveTrain;
    private String modelTransmission;
    private String modelVersion;

    private Long cost;
    private String photoLink;

    @PostConstruct
    public void init() {
        models = modelController.findAllModels();
        modelsFilter = models;
        names = models.stream()
                .map(Model::getName)
                .distinct()
                .collect(Collectors.toList());
    }



    public List<Model> getAllModels() {
        return modelsFilter;
    }

    public String getModelName() {
        modelEngine=null;
        modelDriveTrain=null;
        modelTransmission=null;
        modelVersion=null;
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }


    public List<String> getEngines() {
        return engines;
    }

    public void setEngines(List<String> engines) {
        this.engines = engines;
    }

    public List<String> getDriveTrains() {
        return driveTrains;
    }

    public void setDriveTrains(List<String> driveTrains) {
        modelTransmission=null;
        modelVersion=null;
        this.driveTrains = driveTrains;
    }

    public List<String> getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(List<String> transmissions) {
        modelVersion=null;
        this.transmissions = transmissions;
    }

    public List<String> getVersions() {
        return versions;
    }

    public void setVersions(List<String> versions) {
        this.versions = versions;
    }

    public String getModelEngine() {
        modelDriveTrain=null;
        modelTransmission=null;
        modelVersion=null;
        return modelEngine;
    }

    public void setModelEngine(String modelEngine) {
        this.modelEngine = modelEngine;
    }

    public String getModelDriveTrain() {
        modelTransmission=null;
        modelVersion=null;
        return modelDriveTrain;
    }

    public void setModelDriveTrain(String modelDriveTrain) {
        this.modelDriveTrain = modelDriveTrain;
    }

    public String getModelTransmission() {
        modelVersion=null;
        return modelTransmission;
    }

    public void setModelTransmission(String modelTransmission) {
        this.modelTransmission = modelTransmission;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public Long getCost() {
        return cost;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public void takeAction() {
        modelsFilter = modelController.findModel(modelName, modelEngine, modelDriveTrain, modelTransmission, modelVersion);
        engines = models.stream()
                .filter(el -> el.getName().equals(modelName))
                .map(el -> el.getEngine())
                .distinct()
                .collect(Collectors.toList());
        driveTrains=models.stream()
                .filter(el -> el.getName().equals(modelName))
                .filter(el -> el.getEngine().equals(modelEngine))
                .map(el -> el.getDrivetrain())
                .distinct()
                .collect(Collectors.toList());
        transmissions=models.stream()
                .filter(el -> el.getName().equals(modelName))
                .filter(el -> el.getEngine().equals(modelEngine))
                .filter(el -> el.getDrivetrain().equals(modelDriveTrain))
                .map(el -> el.getTransmission())
                .distinct()
                .collect(Collectors.toList());
        versions=models.stream()
                .filter(el -> el.getName().equals(modelName))
                .filter(el -> el.getEngine().equals(modelEngine))
                .filter(el -> el.getDrivetrain().equals(modelDriveTrain))
                .filter(el -> el.getTransmission().equals(modelTransmission))
                .map(el -> el.getVersion())
                .distinct()
                .collect(Collectors.toList());
        logger.info("Cost value before stream: {}", cost);
        cost=modelsFilter.stream()
                .map(Model::getPrice)
                .min(Long::compareTo).get();
        logger.info("Cost value after stream: {}", cost);
        logger.info("photoLink value after stream: {}", photoLink);
        photoLink=modelsFilter.stream()
                .filter(el -> el.getName().equals(modelName))
                .map(p -> p.getPhotoLink())
                .findFirst()
                .map(String::new)
                .orElse("test");
        logger.info("photoLink value after stream: {}", photoLink);
    }
}
