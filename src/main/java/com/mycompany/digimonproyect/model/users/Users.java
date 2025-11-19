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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<User> users;
    private User currentUser = new User();

    public Users() throws IOException, ClassNotFoundException {
        File file = new File("users.ser");
        file.createNewFile();
        users = new ArrayList();
        
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
       this.currentUser = currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User e) throws IOException {
        users.add(e);
        serializeList();
    }

    public void removeUser(User e) {
        users.remove(e);
    }

    public void serializeList() throws FileNotFoundException, IOException {

        FileOutputStream fos = new FileOutputStream("users.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }
    
    

    public ArrayList<User> deserializedList() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("users.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<User> dUsers = (ArrayList<User>) ois.readObject();
        ois.close();
        return dUsers;
    }
    
    public User getUser (String name) throws IOException, ClassNotFoundException{
        for (User u : deserializedList()) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

}
