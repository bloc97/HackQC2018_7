/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hack.project;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author panbe
 */
public class PanelDecorationFile extends JPanel {

    /**
     * Creates new form PanelDecoration
     */
    public PanelDecorationFile() {
        initComponents();
    }
                        
                       
    private void initComponents() {
        
   
       ImageIcon mini = new ImageIcon(getClass().getResource("src\\main\\java\\resource\\mini.png"));
       ImageIcon cancel = new ImageIcon(getClass().getResource("src/main/java/resource/cancel.png"));

        jLabel4 = new javax.swing.JLabel();
        labelExit = new javax.swing.JLabel();
        labelMini = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 210, 117));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 42)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(91, 91, 91));
        jLabel4.setText("HackQC18");

        labelExit.setIcon(cancel); // NOI18N
        labelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelExitMouseExited(evt);
            }
        });

        labelMini.setIcon(mini); // NOI18N
        labelMini.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                labelMiniFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                labelMiniFocusLost(evt);
            }
        });
        labelMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMiniMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1152, Short.MAX_VALUE)
                .addComponent(labelMini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelExit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(labelMini)
            .addComponent(labelExit)
        );
    }// </editor-fold>                        

    private void labelMiniFocusGained(java.awt.event.FocusEvent evt) {                                      
        // TODO add your handling code here:
        System.out.println("TEST");
    }                                     

    private void labelMiniFocusLost(java.awt.event.FocusEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void labelMiniMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void labelExitMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void labelExitMouseEntered(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void labelExitMouseExited(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    }                                     


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelExit;
    private javax.swing.JLabel labelMini;
    // End of variables declaration                   
}
