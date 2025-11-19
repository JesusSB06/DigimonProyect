package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.service.ApiConnection;
import com.mycompany.digimonproyect.view.PersonalListJDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PersonalListController {
    
    private PersonalListJDialog view;
    private Users model;

    public PersonalListController(PersonalListJDialog view,Users model) {
        this.view = view;
        this.model = model;
        this.view.setDeleteButtonActionListener(this.getDeleteButtonActionListener());
        this.view.setModifyButtonActionListener(this.getModifyButtonActionListener());
        this.view.setShowButtonActionListener(this.getShowButtonActionListener());
        this.view.setTitleLabel(getPageTitle());
         updateTable();
    }
    
    private String getPageTitle(){
            return this.model.getCurrentUser().getName()+"'s Personal List";
    }
    private void updateTable(){
        view.clearTable();
        for (Digimon d: model.getCurrentUser().getDigimon()) {
            Vector row = new Vector();
            try {
                URL url = new URI(d.getImages().get(0).getHref()).toURL();
                BufferedImage img = ImageIO.read(url);
                int rowHeight = 80;
                int newWidth = img.getWidth() * rowHeight / img.getHeight();
                Image scaled = img.getScaledInstance(newWidth, rowHeight, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                row.add(icon);
            } catch (URISyntaxException ex) {
                Logger.getLogger(PersonalListController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(PersonalListController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PersonalListController.class.getName()).log(Level.SEVERE, null, ex);
            }
            row.add(d.getNickname());
            row.add(d.getName());
            row.add(d.isxAntibody());
            
            view.addRowTable(row);
        }
            
    }
    private ActionListener getDeleteButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                model.getCurrentUser().delDigimon(view.getSelectionRow());
                updateTable();
                try {
                    model.serializeList();
                } catch (IOException ex) {
                    Logger.getLogger(PersonalListController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return al;
    }
    private ActionListener getModifyButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int selectionRow = view.getSelectionRow();
                if (selectionRow!=-1) {
                    int selectionColumn = view.getSelectionColumn();
                    switch (selectionColumn) {
                        case 0:
                            String icon = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the icon from:");
                            boolean exists = ApiConnection.JsonToDigimon(icon)!=null;
                            if (exists) {
                                model.getCurrentUser().getDigimon().get(selectionRow).setImages(ApiConnection.JsonToDigimon(icon).getImages());
                            } else {
                                JOptionPane.showMessageDialog(view, "Digimon not found");
                            }
                            break;
                        case 1:
                            String nickname = JOptionPane.showInputDialog(view, "Write the nickname for your digimon:");
                            model.getCurrentUser().getDigimon().get(selectionRow).setNickname(nickname);
                            break;
                        case 2:
                            String name = JOptionPane.showInputDialog(view, "Write the new name for your digimon:");
                            model.getCurrentUser().getDigimon().get(selectionRow).setName(name);
                            break;
                        case 3:
                            int virus = JOptionPane.showConfirmDialog(view, "Does this digimon have xAntibody?");
                            switch (virus) {
                                case 0:
                                    model.getCurrentUser().getDigimon().get(selectionRow).setxAntibody(true);
                                    break;
                                case 1:
                                    model.getCurrentUser().getDigimon().get(selectionRow).setxAntibody(false);
                                    break;
                                case 2:
                                    break;
                            }
                            break;
                    }

                } else {
                    JOptionPane.showMessageDialog(view, "Please, select a cell to modify");
                }
                updateTable();
                try {
                    model.serializeList();
                } catch (IOException ex) {
                    Logger.getLogger(PersonalListController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return al;
    }
    private ActionListener getShowButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        };
        return al;
    }
    
}
