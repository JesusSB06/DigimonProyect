/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.model.digimon;

import java.io.Serializable;

/**
 *
 * @author ADAN
 */
public class Attribute implements Serializable{
    private int id;
    private String attribute;

    public Attribute() {
    }

    public Attribute(int id, String attribute) {
        this.id = id;
        this.attribute = attribute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    
}
