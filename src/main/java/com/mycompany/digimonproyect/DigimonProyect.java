/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.digimonproyect;

import com.mycompany.digimonproyect.controller.MainJFrameController;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.view.MainJFrame;
import java.io.IOException;

/**
 *
 * @author dam2_alu19@inf.ald
 */
public class DigimonProyect {

    public static void main(String[] args) throws IOException, ClassNotFoundException {  
        MainJFrame mainView= new MainJFrame();
        Users usersModel = new Users();
        MainJFrameController mc = new MainJFrameController(mainView, usersModel);
        mainView.setVisible(true);
    }
}
