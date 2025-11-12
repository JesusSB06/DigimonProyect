package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.users.User;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.view.SessionJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dam2_alu09@inf.ald
 */
public class SessionJDialogController {

    private SessionJDialog view;
    private Users model;

    public SessionJDialogController(SessionJDialog view, Users model) {
        this.view = view;
        this.model = model;
        manageLogInButton();
        this.view.addLogInButtonActionListener(this.getLogInButtonActionListener());
        this.view.addSingUpButtonActionListener(this.getSingUpButtonActionListener());
    }

    private void verifyUser() throws IOException, ClassNotFoundException {
        String username = view.getUsername();
        String password = view.getPassword().toString();
        User u = new User(username, password);
        if (model.getUsers().isEmpty()) {
            model.addUser(u);
        }else{
            for (User us : model.deserializedList()) {
                if (username.equals(us.getName())) {
                    if (password.equals(us.getPassword())) {
                        model.setCurrentUser(model.getUser(username));
                        view.dispose();
                    } else {
                        JOptionPane.showMessageDialog(view, "Incorrect password");
                    }
                } else {
                    int choice = JOptionPane.showConfirmDialog(view, "Username not found. Do you want to create a new user?");
                    if (choice == 0) {
                        model.addUser(u);
                    }

                }
            }
        }
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
    
    private void manageLogInButton(){
        if (model.getUsers().isEmpty()) {
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
                if (!usernameTextFieldEmpty() && passwordTextFieldEmpty()) {

                    JOptionPane.showMessageDialog(view, "Introduce a password");
                } else {
                    try {
                        verifyUser();
                    } catch (IOException ex) {
                        Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                manageLogInButton();
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
                } else {
                    if (passwordTextFieldEmpty()) {
                        JOptionPane.showMessageDialog(view, "Introduce a password");
                    } else {
                        try {
                        verifyUser();
                        } catch (IOException ex) {
                            Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(SessionJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                manageLogInButton();
            }
        };
        return al;
    }

}
