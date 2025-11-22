package com.mycompany.digimonproyect.model.users;

import com.mycompany.digimonproyect.model.digimon.Attribute;
import com.mycompany.digimonproyect.model.digimon.Description;
import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.digimon.Evolution;
import com.mycompany.digimonproyect.model.digimon.Field;
import com.mycompany.digimonproyect.model.digimon.Image;
import com.mycompany.digimonproyect.model.digimon.Level;
import com.mycompany.digimonproyect.model.digimon.Skill;
import com.mycompany.digimonproyect.model.digimon.Type;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dam2_alu04@inf.ald
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private ArrayList<Digimon> digimon;

    public User(String name, String password) {
        this.digimon = new ArrayList<>();
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Digimon> getDigimon() {
        return digimon;
    }

    public void delDigimon(int n) {
        if (n != -1) {
            digimon.remove(n);
        }
    }
    
    public void setDigimon(ArrayList<Digimon> digimon) {
        this.digimon = digimon;
    }
    
}
