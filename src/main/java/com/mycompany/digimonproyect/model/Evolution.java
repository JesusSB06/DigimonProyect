/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.model;

import java.io.Serializable;
import java.net.URL;

/**
 *
 * @author dam2_alu19@inf.ald
 */
public class Evolution implements Serializable{
    private int id;
    private String digimon;
    private String condition;
    private URL image;
    private URL url;

    public Evolution(int id, String digimon, String condition, URL image, URL url) {
        this.id = id;
        this.digimon = digimon;
        this.condition = condition;
        this.image = image;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDigimon() {
        return digimon;
    }
    public void setDigimon(String digimon) {
        this.digimon = digimon;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public URL getImage() {
        return image;
    }
    public void setImage(URL image) {
        this.image = image;
    }
    public URL getUrl() {
        return url;
    }
    public void setUrl(URL url) {
        this.url = url;
    }
    
}
