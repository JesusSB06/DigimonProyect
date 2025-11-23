/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.digimon.Field;
import com.mycompany.digimonproyect.model.users.User;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.service.ApiConnection;
import com.mycompany.digimonproyect.view.DigimonJDialog;
import com.mycompany.digimonproyect.view.InformationDigimonDialog;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author dam2_alu09@inf.ald
 */
public class DigimonJDialogController {
    private DigimonJDialog view;
    private Users userModel;
    private Digimon digimon;

    public DigimonJDialogController(DigimonJDialog view, Users userModel) throws IOException {
        this.view = view;
        this.userModel = userModel;
        this.digimon = null;
        this.initComponents();
        this.view.setSearchButtonActionListener(this.setSearchButtonActionListener());
        this.view.setAddToListButtonActionListener(this.setAddToListButtonActionListener());
        this.view.setShowInfoButtonListener(this.setShowInfoButtonActionListener());
        this.view.setCancelButtonActionListener(this.setCancelButtonActionListener());
    }
    
    public DigimonJDialogController(DigimonJDialog view, Users userModel, Digimon digimon) throws IOException {
        this.view = view;
        this.userModel = userModel;
        this.digimon = digimon;
        this.initComponents();
        this.view.setSearchButtonActionListener(this.setSearchButtonActionListener());
        this.view.setCancelButtonActionListener(this.setCancelButtonActionListener());
        this.view.setShowInfoButtonListener(this.setShowInfoButtonActionListener());
        this.view.setAddToListButtonActionListener(this.setAddToListButtonActionListener());
    }
    private void initComponents() throws IOException{
        this.view.createPanel(this.view.getLogoPanel(),getClass().getResource("/img/digidex.png"));
        this.view.enableFieldComponents(false);
        this.view.enableShowInformationButton(false);
        this.view.enableAddToListBUtton(false, false);
        if (digimon != null) {
            showInterfaceButton();
            view.enableFieldComponents(true);
            view.createPanel(view.getDigimonPanel(), digimon.getImages().get(0).getHref());
            view.setJListModel(addFieldToList(), digimon);
            view.setSearchTextField(digimon.getName());
        }
    }
    private void showInterfaceButton(){
        if(digimon == null){
            view.enableShowInformationButton(false);
        } else {
            view.enableShowInformationButton(true);
        }
        if(userModel.getCurrentUser() == null){
            this.view.enableAddToListBUtton(false, true);
        }else{
            this.view.enableAddToListBUtton(true, true);
        }
        
    }

    private ActionListener setSearchButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                digimon = ApiConnection.JsonToDigimon(view.getSearchTextField());
                try {
                    if (digimon != null && digimon.getImages() != null && !digimon.getImages().isEmpty()) {
                        showInterfaceButton();
                        view.enableFieldComponents(true);
                        view.createPanel(view.getDigimonPanel(), digimon.getImages().get(0).getHref());
                        view.setJListModel(addFieldToList(),digimon);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(DigimonJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return al;
    }

    private ActionListener setAddToListButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (userModel.getCurrentUser() == null) {
                    JOptionPane.showMessageDialog(view, "User not valid");
                    return;
                }
                if (digimon == null) {
                    JOptionPane.showMessageDialog(view, "Select digimon first");
                    return;
                }
                ArrayList<Digimon> digimonList = userModel.getCurrentUser().getDigimon();
                if (digimonList == null) {
                    digimonList = new ArrayList<>();
                    userModel.getCurrentUser().setDigimon(digimonList);
                } 
                Digimon nuevoDigimon = getDigimon();
                User u = userModel.getCurrentUser();
                ArrayList<User> us = userModel.getUsers();
                us.remove(u);
                u.getDigimon().add(digimon);
                us.add(u);
                try {
                    userModel.serializeList();
                } catch (IOException ex) {
                    System.getLogger(DigimonJDialogController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                JOptionPane.showMessageDialog(view, "Digmon " +nuevoDigimon.getName() + " addes correctly to your list");
                
            }
        };
        return al;
    }

    private ActionListener setShowInfoButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (digimon == null) {
                    JOptionPane.showMessageDialog(view, "Select Digimon first");
                } else {
                    InformationDigimonDialog id = new InformationDigimonDialog(view, true);
                    try {
                        InformationDigimonController idc = new InformationDigimonController(id, userModel,digimon);
                        id.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(DigimonJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        };
        return al;
    }
    
    private ActionListener setCancelButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               view.dispose();
            }
        };
        return al;
    }

    public Digimon getDigimon() {
        return digimon;
    }

    public void setDigimon(Digimon digimon) {
        this.digimon = digimon;
    }
    

    private DefaultListModel<String> addFieldToList() throws IOException {
        DefaultListModel<String> model = new DefaultListModel<>();
        if (digimon != null && digimon.getFields() != null) {
            for (Field f : digimon.getFields()) {
                model.addElement(f.getField()); 
            }
        }
        return model;
    }
}
