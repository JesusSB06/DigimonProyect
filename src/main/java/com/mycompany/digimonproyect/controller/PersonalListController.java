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
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JList;
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
        this.view.setCreateButtonActionListener(this.getCreateButtonActionListener());
        this.view.setCloneButtonActionListener(this.getCloneButtonActionListener());
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
            row.add(d.getLevels());
            row.add(d.getTypes());
            row.add(d.getAttributes());
            row.add(d.getFields());
            row.add(d.getReleaseDate());
            row.add(d.getDescriptions());
            row.add(d.getSkills());
            row.add(d.getPriorEvolutions());
            row.add(d.getNextEvolutions());
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
                            if (icon==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(icon) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setImages(ApiConnection.JsonToDigimon(icon).getImages());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
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
                        case 4:
                            String level = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the levels from:");
                            if (level==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(level) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setLevels(ApiConnection.JsonToDigimon(level).getLevels());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
                            }
                            break;
                        case 5:
                            String types = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the types from:");
                            if (types==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(types) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setTypes(ApiConnection.JsonToDigimon(types).getTypes());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
                            }
                            break;
                        case 6:
                            String attributes = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the attributes from:");
                            if (attributes==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(attributes) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setAttributes(ApiConnection.JsonToDigimon(attributes).getAttributes());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
                            }
                            break;
                        case 7:
                            String fields = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the fields from:");
                            if (fields==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(fields) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setFields(ApiConnection.JsonToDigimon(fields).getFields());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
                            }
                            break;
                        case 8:
                            String releaseDate = JOptionPane.showInputDialog(view, "Write the release date for your digimon:");
                            model.getCurrentUser().getDigimon().get(selectionRow).setReleaseDate(releaseDate);
                            break;
                        case 9:
                            String descriptions = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the descriptions from:");
                            if (descriptions==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(descriptions) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setDescriptions(ApiConnection.JsonToDigimon(descriptions).getDescriptions());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
                            }
                            break;
                        case 10:
                            String skills = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the skills from:");
                            if (skills==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(skills) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setSkills(ApiConnection.JsonToDigimon(skills).getSkills());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
                            }
                            break;
                        case 11:
                            String priorEvolutions = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the prior evolutions from:");
                            if (priorEvolutions==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(priorEvolutions) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setPriorEvolutions(ApiConnection.JsonToDigimon(priorEvolutions).getPriorEvolutions());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
                            }
                            break;
                        case 12:
                            String nextEvolutions = JOptionPane.showInputDialog(view, "Write the name of the digimon u want the next evolutions from:");
                            if (nextEvolutions==null) {
                                
                            } else {
                                boolean exists = ApiConnection.JsonToDigimon(nextEvolutions) != null;
                                if (exists) {
                                    model.getCurrentUser().getDigimon().get(selectionRow).setNextEvolutions(ApiConnection.JsonToDigimon(nextEvolutions).getNextEvolutions());
                                } else {
                                    JOptionPane.showMessageDialog(view, "Digimon not found");
                                }
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
                if (view.getSelectionRow()!=-1) {
                    int selection = view.getSelectionColumn();
                    Object value = view.getSelection();
                    switch(selection){
                        case 0:
                            //nada es una imagen
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(view, value.toString());
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(view, value.toString());
                            break;
                        case 3:
                            //nada es un boolean
                            break;
                        case 8:
                            JOptionPane.showMessageDialog(view, value.toString());
                            break;
                        default:
                            if (value instanceof List<?>) {
                                StringBuilder sb = new StringBuilder();
                                for (Object o : (List<?>) value) {
                                    sb.append(o).append("\n");
                                }
                                JOptionPane.showMessageDialog(view, sb.toString());
                            }
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Please, select a cell to show");
                }
            }
        };
        return al;
    }
    private ActionListener getCreateButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Digimon newDigimon = model.getNewDigimon();
                model.getCurrentUser().getDigimon().add(newDigimon);
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
    private ActionListener getCloneButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (view.getSelectionRow()!=-1) {
                    Digimon digimon = model.getCurrentUser().getDigimon().get(view.getSelectionRow());
                    Digimon newDigimon = new Digimon(digimon.getId(),digimon.getName(),digimon.isxAntibody(),digimon.getImages(),digimon.getLevels(),digimon.getTypes(),digimon.getAttributes(),digimon.getFields(),digimon.getReleaseDate(),digimon.getDescriptions(),digimon.getSkills(),digimon.getPriorEvolutions(),digimon.getNextEvolutions());
                    model.getCurrentUser().getDigimon().add(newDigimon);
                    updateTable();
                    try {
                        model.serializeList();
                    } catch (IOException ex) {
                        Logger.getLogger(PersonalListController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Please, select a Digimon to clone");
                }
            }
        };
        return al;
    }
    
}
