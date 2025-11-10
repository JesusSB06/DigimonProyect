/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.model;

import com.mycompany.digimonproyect.model.Image;

/**
 *
 * @author ADAN
 */
public class Field {
    private int id;
    private String field;
    private Image image;

    public Field() {
    }

    public Field(int id, String field, Image image) {
        this.id = id;
        this.field = field;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
}
