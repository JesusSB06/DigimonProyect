package com.mycompany.digimonproyect.model.users;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dam2_alu04@inf.ald
 */
public class Users implements Serializable{
    private static final long serialVersionUID = 1L;
    private static ArrayList<User> users;

    public Users() {
        users = new ArrayList();
    }
    
    public static ArrayList<User> getUsers() {
        return users;
    }
    
    public static void addUsers(User e){
        users.add(e);
    }
}
