package io._10a.entity;

import javax.persistence.*;

@Entity
@Table(name="MODELS")
@NamedQueries({
        @NamedQuery(
                name = "Model.findAll",
                query = "SELECT m FROM Model m"
        ),
        @NamedQuery(
                name = "Model.startingWith",
                query = "SELECT m FROM Model m WHERE m.name LIKE :likeExpression"
        )})
public class Model {

    @Id
    @Column(name = "MODEL_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name="PRICE")
    private Long price;

}
