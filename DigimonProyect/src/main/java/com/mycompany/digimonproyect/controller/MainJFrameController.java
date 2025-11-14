package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.Digimons;
import com.mycompany.digimonproyect.model.users.User;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.view.MainJFrame;
import com.mycompany.digimonproyect.view.SessionJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainJFrameController {

    private MainJFrame view;
    private Users userModel;
    private Digimons digimonModel;

    public MainJFrameController(MainJFrame view, Users userModel, Digimons digimonModel) {
        this.view = view;
        this.userModel = userModel;
        this.digimonModel = digimonModel;
        this.view.addQuitMenuItemActionListener(getQuitMenuActionListener());
        this.view.addDigimonMenuItemActionListener(getDigimonMenuActionListener());
        this.view.addSessionMenuItemActionListener(getSessionMenuActionListener());
        this.view.addPersonalListMenuItemActionListener(getPersonalListMenuActionListener());
    }

    private ActionListener getQuitMenuActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                System.exit(0);
            }
        };
        return al;
    }
    private ActionListener getPersonalListMenuActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        };
        return al;
    }
    private ActionListener getSessionMenuActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SessionJDialog sjd = new SessionJDialog(view, true);
                try {
                    SessionJDialogController sjdc = new SessionJDialogController(sjd, userModel);
                } catch (IOException ex) {
                    Logger.getLogger(MainJFrameController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainJFrameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sjd.setVisible(true);
            }
        };
        return al;
    }
    private ActionListener getDigimonMenuActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        };
        return al;
    }
    
    
}
