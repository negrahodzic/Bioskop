/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Negra
 */
public class FormLoggedUser extends javax.swing.JFrame {

    /**
     * Creates new form FormMain
     */
    public FormLoggedUser() {
        initComponents();
        prepareView();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLoggedUser = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuSearch = new javax.swing.JMenu();
        menuItemSearchMovies = new javax.swing.JMenuItem();
        menuItemSearchProjections = new javax.swing.JMenuItem();
        menuReservation = new javax.swing.JMenu();
        menuItemNewReservation = new javax.swing.JMenuItem();
        menuItemMyReservations = new javax.swing.JMenuItem();
        menuReview = new javax.swing.JMenu();
        menuItemNewReview = new javax.swing.JMenuItem();
        menuItemMyReviews = new javax.swing.JMenuItem();
        menuUser = new javax.swing.JMenu();
        menuItemUpdateUser = new javax.swing.JMenuItem();
        btnDeleteUser = new javax.swing.JMenuItem();
        menuItemSingoutUser = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLoggedUserLayout = new javax.swing.GroupLayout(panelLoggedUser);
        panelLoggedUser.setLayout(panelLoggedUserLayout);
        panelLoggedUserLayout.setHorizontalGroup(
            panelLoggedUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );
        panelLoggedUserLayout.setVerticalGroup(
            panelLoggedUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        menuSearch.setText("Pretraga");

        menuItemSearchMovies.setText("Pretraga filmova");
        menuItemSearchMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSearchMoviesActionPerformed(evt);
            }
        });
        menuSearch.add(menuItemSearchMovies);

        menuItemSearchProjections.setText("Pretraga projekcija");
        menuItemSearchProjections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSearchProjectionsActionPerformed(evt);
            }
        });
        menuSearch.add(menuItemSearchProjections);

        jMenuBar1.add(menuSearch);

        menuReservation.setText("Rezervacije");

        menuItemNewReservation.setText("Nova rezervacija");
        menuReservation.add(menuItemNewReservation);

        menuItemMyReservations.setText("Moje rezervacije");
        menuReservation.add(menuItemMyReservations);

        jMenuBar1.add(menuReservation);

        menuReview.setText("Ocene");

        menuItemNewReview.setText("Nova ocena");
        menuReview.add(menuItemNewReview);

        menuItemMyReviews.setText("Moje ocene");
        menuReview.add(menuItemMyReviews);

        jMenuBar1.add(menuReview);

        menuUser.setText("Moj nalog");

        menuItemUpdateUser.setText("Izmeni nalog");
        menuItemUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUpdateUserActionPerformed(evt);
            }
        });
        menuUser.add(menuItemUpdateUser);

        btnDeleteUser.setText("Izbriši nalog");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        menuUser.add(btnDeleteUser);

        menuItemSingoutUser.setText("Odjavi se");
        menuItemSingoutUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSingoutUserActionPerformed(evt);
            }
        });
        menuUser.add(menuItemSingoutUser);

        jMenuBar1.add(menuUser);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLoggedUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLoggedUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSearchMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSearchMoviesActionPerformed
        panelLoggedUser = new PanelSearch(); //ili dva panela ili prosledi parametar movie projection
    }//GEN-LAST:event_menuItemSearchMoviesActionPerformed

    private void menuItemSearchProjectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSearchProjectionsActionPerformed
        panelLoggedUser = new PanelSearch();
    }//GEN-LAST:event_menuItemSearchProjectionsActionPerformed

    private void menuItemSingoutUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSingoutUserActionPerformed
        Controller.getInstance().logoutUser();
        this.dispose();
        new FormWelcome().setVisible(true);
    }//GEN-LAST:event_menuItemSingoutUserActionPerformed

    private void menuItemUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUpdateUserActionPerformed
        new FormUpdateUser(this, true).setVisible(true);
    }//GEN-LAST:event_menuItemUpdateUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da izbrišete Vaš nalog?", "Brisanje naloga",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirm == 0) {
                Controller.getInstance().deleteUser();
                this.dispose();
                new FormWelcome().setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Neuspešno brisanje, pokušajte ponovo.");
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnDeleteUser;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemMyReservations;
    private javax.swing.JMenuItem menuItemMyReviews;
    private javax.swing.JMenuItem menuItemNewReservation;
    private javax.swing.JMenuItem menuItemNewReview;
    private javax.swing.JMenuItem menuItemSearchMovies;
    private javax.swing.JMenuItem menuItemSearchProjections;
    private javax.swing.JMenuItem menuItemSingoutUser;
    private javax.swing.JMenuItem menuItemUpdateUser;
    private javax.swing.JMenu menuReservation;
    private javax.swing.JMenu menuReview;
    private javax.swing.JMenu menuSearch;
    private javax.swing.JMenu menuUser;
    private javax.swing.JPanel panelLoggedUser;
    // End of variables declaration//GEN-END:variables
    
    private void prepareView() {
        setLocationRelativeTo(null);
    }
    
}
