package com.example.myapplication.db;

import java.io.Serializable;
/*
public class Contact implements Serializable {

    public String nombre;

    public Contact(){}

    public Contact(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }



}
*/

public class Contact{
    String nom;

    public Contact(String nom) { this.nom = nom; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
