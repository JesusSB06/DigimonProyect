package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.users.Users;
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
        this.view.setNicknameButtonActionListener(this.getNicknameButtonActionListener());
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
            row.add(true);
            view.addRowTable(row);
        }
            
    }
    private ActionListener getDeleteButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                model.getCurrentUser().delDigimon(view.getSelectionInt());
                updateTable();
            }
        };
        return al;
    }
    private ActionListener getNicknameButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (view.getSelectionInt()!=-1) {
                    String nickname = JOptionPane.showInputDialog(view, "Write the nickname for your digimon:");
                    model.getCurrentUser().changeDigimonNickname(view.getSelectionInt(), nickname);
                    updateTable();
                } else {
                    JOptionPane.showMessageDialog(view, "Please, select a digimon in the list to change the nickname to");
                }
            }
        };
        return al;
    }
    private ActionListener getShowButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(view, view.getSelection());
            }
        };
        return al;
    }
    
}
