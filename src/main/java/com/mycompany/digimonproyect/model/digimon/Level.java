package com.mycompany.digimonproyect.model.digimon;

import java.io.Serializable;

/**
 *
 * @author dam2_alu04@inf.ald
 */
public class Level implements Serializable{

    private int id;
        private String level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return level;
    }
    
}
