/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.model.digimon;

import java.io.Serializable;

/**
 *
 * @author dam2_alu19@inf.ald
 */
public class Description implements Serializable{
    private String origin;
    private String language;
    private String description;

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return description;
    }
    
}
