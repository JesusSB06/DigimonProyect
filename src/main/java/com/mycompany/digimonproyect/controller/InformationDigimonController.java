/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.digimon.*;
import com.mycompany.digimonproyect.view.InformationDigimonDialog;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author jsbje
 */
public class InformationDigimonController {
    private InformationDigimonDialog view;
    private Digimon digimon;

    public InformationDigimonController(InformationDigimonDialog view,  Digimon digimon) throws IOException {
        this.view = view;
        this.digimon = digimon;
        this.initComponents();
    }
    private void initComponents() throws IOException {
        this.view.createPanel(view.getDigimonPanel(), digimon.getImages().get(0).getHref());
        this.view.configurateTextArea(view.getDescriptionScrollPane(), view.getDescriptionTextArea());
        this.view.setJListModel(addFieldToList(), digimon, view.getFieldsList(), view.getFieldScrollPane());
        this.view.setJListModel(addAttributesToList(), digimon, view.getAttributesList(), view.getAttributesScrollPane());
        this.view.setJListModel(addSkillsToList(), digimon, view.getSkillList(), view.getSkillScrollPane());
        this.view.setJListModel(addTypesToList(), digimon, view.getTypesList(), view.getTypeScrollPane());
        this.view.setJListModel(addLevelsToList(), digimon, view.getLevelsList(), view.getLevelsScrollPane());
        this.view.setDescriptioAreaText(digimon.getDescriptions().get(1).getDescription());
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
    private DefaultListModel<String> addAttributesToList() throws IOException {
        DefaultListModel<String> model = new DefaultListModel<>();
        if (digimon != null && digimon.getAttributes() != null) {
            for (Attribute f : digimon.getAttributes()) {
                model.addElement(f.getAttribute());
            }
        }
        return model;
    }
    private DefaultListModel<String> addSkillsToList() throws IOException {
        DefaultListModel<String> model = new DefaultListModel<>();
        if (digimon != null && digimon.getSkills() != null) {
            for (Skill f : digimon.getSkills()) {
                model.addElement(f.getSkill() + ": " + f.getDescription());
            }
        }
        return model;
    }
    private DefaultListModel<String> addTypesToList() throws IOException {
        DefaultListModel<String> model = new DefaultListModel<>();
        if (digimon != null && digimon.getTypes() != null) {
            for (Type f : digimon.getTypes()) {
                model.addElement(f.getType());
            }
        }
        return model;
    }
    private DefaultListModel<String> addLevelsToList() throws IOException {
        DefaultListModel<String> model = new DefaultListModel<>();
        if (digimon != null && digimon.getLevels() != null) {
            for (Level f : digimon.getLevels()) {
                model.addElement(f.getLevel());
            }
        }
        return model;
    }
    
}
