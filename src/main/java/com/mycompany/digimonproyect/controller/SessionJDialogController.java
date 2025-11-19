package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.users.User;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.view.SessionJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dam2_alu09@inf.ald
 */
public class SessionJDialogController {

    private final SessionJDialog view;
    private final Users model;

    public SessionJDialogController(SessionJDialog view, Users model) throws IOException, ClassNotFoundException {
        this.view = view;
        this.model = model;
        manageLogInButton();
        this.view.addLogInButtonActionListener(this.getLogInButtonActionListener());
        this.view.addSingUpButtonActionListener(this.getSingUpButtonActionListener());
    }

    private void verifyLogIn() throws IOException, ClassNotFoundException {
        File file = new File ("users.ser");
        String username = view.getUsername().trim();
        String password = view.getPassword().toString().trim();
        User u = new User(username, password);
            for (User us : model.deserializedList()) {
                if (username.equals(us.getName().trim())) {
                    if (password.equals(us.getPassword().trim())) {
                        model.setCurrentUser(model.getUser(username));
                        JOptionPane.showMessageDialog(view, "User loged in correctly");
                        view.dispose();
                    } else {
                        JOptionPane.showMessageDialog(view, "Incorrect password");
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Username not found.");
                    clearView();
                }
            }
    }
    private void verifySingUp() throws IOException, ClassNotFoundException {
        File file = new File ("users.ser");
        String username = view.getUsername().trim();
        String password = view.getPassword().toString().trim();
        User u = new User(username, password);
        if (file.length()<1) {
            model.addUser(u);
            JOptionPane.showMessageDialog(view, "User singed up successfully, log in to get into the aplication");
            clearView();
        }else{
            for (User us : model.deserializedList()) {
                if (username.equals(us.getName().trim())) {
                    
                        JOptionPane.showMessageDialog(view, "Username already exists");
                    
                } else {
                    model.addUser(u);
                    JOptionPane.showMessageDialog(view, "User singed up successfully, log in to get into the aplication");
                    clearView();
                }
            }
        }
    }
    
    private void clearView(){
        view.setPassword("");
        view.setUsername("");
    }

    private boolean passwordTextFieldEmpty() {
        String password = view.getPassword();
        if (password.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean usernameTextFieldEmpty() {
        String username = view.getUsername();
        if (username.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    private void manageLogInButton() throws IOException, ClassNotFoundException{
        File file = new File ("users.ser");
        if (file.length()<1) {
            view.enableDisableLogInButton(false);
        }else{
            view.enableDisableLogInButton(true);
        }
    }
    
    public ActionListener getLogInButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (usernameTextFieldEmpty()) {
                    JOptionPane.showMessageDialog(view, "Introduce an user");
                }
                if (passwordTextFieldEmpty()) {

                    JOptionPane.showMessageDialog(view, "Introduce a password");
                }if(!usernameTextFieldEmpty() && !passwordTextFieldEmpty()){
                    try {
                        verifyLogIn();
                    } catch (IOException ex) {
                        Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                try {
                    manageLogInButton();
                } catch (IOException ex) {
                    Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
        
        return al;
    }

    public ActionListener getSingUpButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (usernameTextFieldEmpty()) {
                    JOptionPane.showMessageDialog(view, "Introduce an user");
                }if (passwordTextFieldEmpty()) {
                    JOptionPane.showMessageDialog(view, "Introduce a password");
                }if(!usernameTextFieldEmpty() && !passwordTextFieldEmpty()){
                    try {
                    verifySingUp();
                    } catch (IOException ex) {
                        Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    manageLogInButton();
                } catch (IOException ex) {
                    Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return al;
    }

}
