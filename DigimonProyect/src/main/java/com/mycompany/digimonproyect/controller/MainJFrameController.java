package com.mycompany.digimonproyect.controller;


import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.view.DigimonJDialog;
import com.mycompany.digimonproyect.view.MainJFrame;
import com.mycompany.digimonproyect.view.PersonalListJDialog;
import com.mycompany.digimonproyect.view.SessionJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainJFrameController {

    private MainJFrame view;
    private Users userModel;

    public MainJFrameController(MainJFrame view, Users userModel) {
        this.view = view;
        this.userModel = userModel;
        this.view.setBackgroundImage();
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
                if (userModel.getCurrentUser() == null) {
                    JOptionPane.showMessageDialog(view, "Log in to manage the list");
                } else{
                    if (userModel.getCurrentUser().getDigimon() == null) {
                        JOptionPane.showMessageDialog(view, "Your digimon list is empty, introduce a digimon to manage the list");
                    }else {
                        PersonalListJDialog pld = new PersonalListJDialog(view, true);
                        PersonalListController plc = new PersonalListController(pld, userModel);
                        pld.setVisible(true);  
                    }
                     
                }
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
      
                    DigimonJDialog dd = new DigimonJDialog(view, true);
                    try {
                        DigimonJDialogController ddc = new DigimonJDialogController(dd, userModel);
                    } catch (IOException ex) {
                        Logger.getLogger(MainJFrameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dd.setVisible(true);
            }
        };
        return al;
    }
}
    

