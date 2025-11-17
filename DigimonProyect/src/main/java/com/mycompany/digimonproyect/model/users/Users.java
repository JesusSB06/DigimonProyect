package com.mycompany.digimonproyect.model.users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dam2_alu04@inf.ald
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<User> users;
    private User currentUser;

    public Users() {
        users = new ArrayList();
        currentUser = null;
        File file = new File("users.ser");
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        currentUser = currentUser;
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
        oos.writeObject(users);
    }

    public ArrayList<User> deserializedList() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("users.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<User> dUsers = (ArrayList<User>) ois.readObject();
        return dUsers;
    }
    
    public User getUser (String name){
        for (User u : users) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

}
