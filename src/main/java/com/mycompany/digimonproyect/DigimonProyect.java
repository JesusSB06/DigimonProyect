/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.digimonproyect;

import com.mycompany.digimonproyect.controller.MainJFrameController;
import com.mycompany.digimonproyect.model.Digimons;
import com.mycompany.digimonproyect.model.User;
import com.mycompany.digimonproyect.model.Users;
import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.service.ApiConnection;
import com.mycompany.digimonproyect.view.MainJFrame;

/**
 *
 * @author dam2_alu19@inf.ald
 */
public class DigimonProyect {

    public static void main(String[] args) {
        Digimon f = ApiConnection.JsonToDigimon("Agumon");
        System.out.println(f.getName());
        
        MainJFrame mainView= new MainJFrame();
        Users usersModel = new Users();
        Digimons digimonsModel = new Digimons();
        MainJFrameController mc = new MainJFrameController(mainView, usersModel, digimonsModel);
        mainView.setVisible(true);
    }
}
