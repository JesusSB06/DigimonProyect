/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.model.digimon;

import com.mycompany.digimonproyect.model.digimon.Image;
import java.io.Serializable;

/**
 *
 * @author ADAN
 */
public class Field implements Serializable{
    private int id;
    private String field;
    private String image;

    public Field() {
    }

    public Field(int id, String field, String image) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
