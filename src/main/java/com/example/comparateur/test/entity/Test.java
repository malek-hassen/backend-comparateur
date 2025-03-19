package com.example.comparateur.test.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Test {

    @Id
    private String id;
    private String nom;

    @Override
    public String toString() {
        return "TestDTO{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }


}
