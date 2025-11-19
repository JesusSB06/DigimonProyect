package com.mycompany.digimonproyect.model.users;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam2_alu04@inf.ald
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;
    private ArrayList<Digimon> digimon;

    public User(String name, String password) throws IOException {
        this.digimon = new ArrayList<>(deserializeListDigimons(this));
        this.name = name;
        this.password = password;
    }
    public User() {
        this.digimon = new ArrayList<>();
        this.name = null;
        this.password = null;
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
    
    public void changeDigimonNickname(int n,String s){
        digimon.get(n).setNickname(s);
    }
    public void setDigimon(ArrayList<Digimon> digimon) {
        this.digimon = digimon;
    }
    
    public List<Digimon> deserializeListDigimons( User user) throws FileNotFoundException, IOException, ClassNotFoundException{
        File file1 = new File(user.getName() + "listaDigimon.ser");
        List<Digimon> digimon = null;
        if(file1.exists()){
            FileInputStream fis = new FileInputStream(file1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            digimon = (ArrayList<Digimon>) ois.readObject();
        }
        return digimon;
    }
    
    public void serializeListDigimon(List<Digimon> digimons) throws IOException{
        File file1 = new File(this.getName() + "listaDigimon.ser");
        file1.createNewFile();
        FileOutputStream fos = new FileOutputStream(file1);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(digimons);
        oos.close();
    }
}
