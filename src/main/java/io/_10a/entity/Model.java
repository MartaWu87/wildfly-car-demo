package io._10a.entity;

import javax.persistence.*;

@Entity
@Table(name = "MODELS")
@NamedQueries({
        @NamedQuery(
                name = "Model.findAllModels",
                query = "SELECT m FROM Model m"
        ),
        @NamedQuery(
                name = "Model.findModel",
                query = "SELECT m FROM Model m WHERE " +
                        "(:modelName IS NULL OR m.name = :modelName) AND " +
                        "(:modelEngine IS NULL OR m.engine = :modelEngine) AND " +
                        "(:modelDriveTrain IS NULL OR m.drivetrain = :modelDriveTrain) AND " +
                        "(:modelTransmission IS NULL OR m.transmission = :modelTransmission) AND " +
                        "(:modelVersion IS NULL OR m.version = :modelVersion)"
        )})
public class Model {

    @Id
    @Column(name = "MODEL_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ENGINE")
    private String engine;

    @Column(name = "DRIVETRAIN")
    private String drivetrain;

    @Column(name = "TRANSMISSION")
    private String transmission;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "PRICE")
    private Long price;
    @Column(name = "PHOTO_LINK")
    private String PhotoLink;

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

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPhotoLink() {
        return PhotoLink;
    }

    public void setPhotoLink(String photoLink) {
        PhotoLink = photoLink;
    }
}