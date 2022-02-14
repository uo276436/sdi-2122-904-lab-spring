package com.uniovi.sdi2122904spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
    @Id
    private String dni;
    private String department;

    public Professor() {
    }
    public Professor(String dni, String department) {
        this.dni = dni;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "dni=" + dni +
                ", department='" + department +
                '}';
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}