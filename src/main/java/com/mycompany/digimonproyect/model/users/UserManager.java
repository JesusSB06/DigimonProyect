package com.mycompany.digimonproyect.model.users;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import com.mycompany.digimonproyect.model.users.Users;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author dam2_alu04@inf.ald
 */
public class UserManager implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public static void serializeList() throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream("users.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Users.getUsers());
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
