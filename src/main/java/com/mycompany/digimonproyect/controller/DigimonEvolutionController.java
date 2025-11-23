package com.mycompany.digimonproyect.controller;

import com.mycompany.digimonproyect.controller.DigimonJDialogController;
import com.mycompany.digimonproyect.controller.PersonalListController;
import com.mycompany.digimonproyect.model.digimon.Digimon;
import com.mycompany.digimonproyect.model.digimon.Evolution;
import com.mycompany.digimonproyect.model.users.Users;
import com.mycompany.digimonproyect.service.ApiConnection;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class DigimonEvolutionController {

    private DigimonEvolutionJDialog view;
    private Digimon digimon;
    private Users userModel;

    public DigimonEvolutionController(DigimonEvolutionJDialog view, Users userModel, Digimon digimon) {
        this.view = view;
        this.userModel = userModel;
        this.digimon = digimon;

        this.intiComponents();
        this.view.setCancelButtonsListener(this.setCancelButtonActionListener());
        this.view.setGoToDigimonListener(this.setGoToDigimonActionListener());
        this.view.setShowInfoListener(this.setShowInfoActionListener());
    }

    private void updateTable(JTable table, List<Evolution> evolutions) {
        view.clearTable(table);
        for (Evolution d : evolutions) {
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

    private ActionListener setCancelButtonActionListener() {
        return e -> view.dispose();
    }

    private ActionListener setGoToDigimonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTable table = view.getLastSelectedTable();
                int row = view.getLastSelectedRow();
                String nameDigimon = "";

                if (table != null && row != -1) {
                    nameDigimon = table.getModel().getValueAt(row, 0).toString();
                }

                if (nameDigimon.isEmpty()) {
                    return; // nada seleccionado
                }

                Digimon digimon = ApiConnection.JsonToDigimon(nameDigimon);
                DigimonJDialog dd = new DigimonJDialog(view, true);

                try {
                    DigimonJDialogController ddc = new DigimonJDialogController(dd, userModel, digimon);
                    dd.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(DigimonEvolutionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }
    
    private ActionListener setShowInfoActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, "Condition: " + view.getInfoCondition());
            }
        };
        return al;
    }

    private void intiComponents() {
        this.updateTable(view.getNextEvolutionsTable(), digimon.getNextEvolutions());
        this.updateTable(view.getPriorEvolutionsTable(), digimon.getPriorEvolutions());

        if (digimon.getNextEvolutions().isEmpty()) {
            view.enablePane(0, false);
        }
        if (digimon.getPriorEvolutions().isEmpty()) {
            view.enablePane(1, false);
        }
    }
}
