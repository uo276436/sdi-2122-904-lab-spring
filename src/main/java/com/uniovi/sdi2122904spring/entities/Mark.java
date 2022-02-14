package com.uniovi.sdi2122904spring.entities;
import javax.persistence.*;

@Entity
public class Mark {
    @Id
    @GeneratedValue
    private Long id;

    private String description;
    private Double score;
//hice los commits mal, puse 2021,
    public Mark() {
    }
    public Mark(Long id, String description, Double score) {
        this.id = id;
        this.description = description;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", score=" + score +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
}
//bean profe
//profesor controller (rest), devuelven strings
//