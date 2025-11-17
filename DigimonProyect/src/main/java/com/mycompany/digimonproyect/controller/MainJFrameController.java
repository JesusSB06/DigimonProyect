package com.mycompany.digimonproyect.controller;


import com.mycompany.digimonproyect.controller.SessionJDialogController;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.view.DigimonJDialog;
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


    public MainJFrameController(MainJFrame view, Users userModel) {
        this.view = view;
        this.userModel = userModel;
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
                SessionJDialog sjd = new SessionJDialog(view,true);
                SessionJDialogController sdc = new SessionJDialogController(sjd, userModel);
                sjd.setVisible(true);
            }
        };
        return al;
    }
    private ActionListener getDigimonMenuActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DigimonJDialog dd = new DigimonJDialog(view, true);
                try {
                    DigimonJDialogController ddc = new DigimonJDialogController(dd, userModel);
                    dd.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainJFrameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return al;
    }
    
    
}
