package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.users.Users;

import com.mycompany.digimonproyect.view.MainJFrame;
import com.mycompany.digimonproyect.view.PersonalListJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainJFrameController {

    private MainJFrame view;
    private Users model;

    public MainJFrameController(MainJFrame view, Users userModel) {
        this.view = view;
        this.model = userModel;
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
                PersonalListJDialog dialog = new PersonalListJDialog(view, true);
                PersonalListController controller = new PersonalListController(dialog,model);
                dialog.setVisible(true);
            }
        };
        return al;
    }
    private ActionListener getSessionMenuActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
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
