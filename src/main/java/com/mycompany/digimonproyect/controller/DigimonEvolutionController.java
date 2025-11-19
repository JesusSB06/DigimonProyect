/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.digimon.Evolution;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.view.DigimonEvolutionJDialog;
import com.mycompany.digimonproyect.view.DigimonJDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author jsbje
 */
public class DigimonEvolutionController {
    private DigimonEvolutionJDialog view;
    private Digimon digimon;
    private Users userModel;
    public DigimonEvolutionController(DigimonEvolutionJDialog view, Users userModel, Digimon digimon) {
        this.view = view;
        this.digimon = digimon;
        this.userModel = userModel;
        this.updateTable(view.getNextEvolutionsTable(), digimon.getNextEvolutions());
        this.updateTable(view.getPriorEvolutionsTable(), digimon.getPriorEvolutions());
        this.view.setCancelButtonListener(this.setCancelButtonActionListener());
    }

    private void updateTable(JTable table, List<Evolution> evolutions){
        view.clearTable(table);
        for (Evolution d: evolutions) {
            Vector row = new Vector();
            try {
                URL url = d.getImage();
                BufferedImage img = ImageIO.read(url);
                int rowHeight = 80;
                int newWidth = img.getWidth() * rowHeight / img.getHeight();
                Image scaled = img.getScaledInstance(newWidth, rowHeight, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                row.add(d.getDigimon());
                row.add(d.getCondition());
                row.add(icon);
            } catch (MalformedURLException ex) {
                Logger.getLogger(PersonalListController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PersonalListController.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.addRowTable(row, table);
        }
            
    }
    
    private ActionListener setCancelButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.dispose();
            }
        };
          return al;      
    }
    private ActionListener setDigimonNextEvolutionsButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DigimonJDialog dd = new DigimonJDialog(view,true);
                
            }
        };
        return al;
    }
    
    private Digimon getDigimonEvolution(JTable table){
        int row = view.getRowSelect(table);
        return null;
   
    }
}
