package com.mycompany.digimonproyect.model.digimon;

import java.io.Serializable;

/**
 *
 * @author dam2_alu04@inf.ald
 */
public class Type implements Serializable{

    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
