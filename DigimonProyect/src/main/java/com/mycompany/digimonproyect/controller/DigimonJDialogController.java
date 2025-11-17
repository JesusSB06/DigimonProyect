/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.service.ApiConnection;
import com.mycompany.digimonproyect.view.DigimonJDialog;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.view.createPanel(this.view.getLogoPanel(),"src/main/resources/img/logo.jpeg");
        this.view.setSearchButtonActionListener(this.setSearchButtonActionListener());
    }
    
    private ActionListener setSearchButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setDigimon(ApiConnection.JsonToDigimon(view.getSearchTextField()));
                try {
                    view.createPanel(view.getDigimonPanel(),digimon.getImages().get(0).getHref());
                } catch (IOException ex) {
                    Logger.getLogger(DigimonJDialogController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    

    
}
