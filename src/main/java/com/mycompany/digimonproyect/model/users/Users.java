package com.mycompany.digimonproyect.model.users;

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
public class Users implements Serializable{
    private static final long serialVersionUID = 1L;
    private static ArrayList<User> users;
    private User currentUser;

    public Users() {
        users = new ArrayList();
        currentUser = new User("Mariano","acb123.");
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    
    public static ArrayList<User> getUsers() {
        return users;
    }
    
    public static void addUsers(User e){
        users.add(e);
    }
    
    public static void serializeList() throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream("users.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
    }
   
    public static ArrayList<User> deserializedList() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("users.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<User> users= (ArrayList<User>) ois.readObject();
        return users;
    }
    
    public static boolean verifyUser(User u) throws IOException, ClassNotFoundException{
        for (User us :  deserializedList()) {
            if (us.getName().equals(u.getName())) {
                return true;
            }
        }
        return false;
    }
    
}
