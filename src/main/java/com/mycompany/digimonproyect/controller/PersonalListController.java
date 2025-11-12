package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.view.PersonalListJDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
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
        demo();
    }
    
    private String getPageTitle(){
        return this.model.getCurrentUser().getName()+"'s Personal List";
    }
    private void demo(){
            Vector row = new Vector();
            row.add("Imagen");
            row.add("Agu");
            row.add("Agumon");
            row.add(true);
            view.addRowTable(row);
    }
    private ActionListener getDeleteButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        };
        return al;
    }
    private ActionListener getNicknameButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
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
