/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import demo.Methods;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;

/**
 *
 * @author Tarek Radwan
 */
public class PostRequestPanel extends javax.swing.JPanel {

    private final JLayeredPane layeredPane;

    /**
     * Creates new form Post
     */
    public PostRequestPanel(JLayeredPane layeredPane)  {
        initComponents();
        this.layeredPane = layeredPane;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        term1 = new javax.swing.JRadioButton();
        term2 = new javax.swing.JRadioButton();
        term3 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        status1 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        status2 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        status3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        budget1 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nightsbutton = new javax.swing.JRadioButton();
        MonthsButton = new javax.swing.JRadioButton();
        YearsButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        firstDuration = new javax.swing.JRadioButton();
        SecondDuration = new javax.swing.JRadioButton();
        ThirdDuration = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        budget = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        property1 = new javax.swing.JRadioButton();
        property2 = new javax.swing.JRadioButton();
        property3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel8.setText("choose a term ");

        term1.setSelected(true);
        term1.setText("will get pet");
        term1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                term1ActionPerformed(evt);
            }
        });

        term2.setText("Free WiFi");
        term2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                term2ActionPerformed(evt);
            }
        });

        term3.setText("Mobile charger");
        term3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                term3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Furnishing status");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Post a Request Form");

        buttonGroup3.add(status1);
        status1.setText("Furnished");
        status1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cairo", "Giza", "Luxor", "Alexanderia", "Dahab" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        buttonGroup3.add(status2);
        status2.setSelected(true);
        status2.setText("Unfurnished");
        status2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masr El Gedida", "Zamalek", "Maadi" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        buttonGroup3.add(status3);
        status3.setText("Serviced Apartment");

        jLabel2.setText("Select a City ");

        jLabel10.setText("Minimum rooms (2)");

        jLabel3.setText("Select a district");

        budget1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budget1ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almazah", "El Korba", "El Nozha" }));

        jLabel4.setText("Select neighbourhood");

        jLabel5.setText("choose duration");

        buttonGroup1.add(nightsbutton);
        nightsbutton.setText("Nights");
        nightsbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nightsbuttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(MonthsButton);
        MonthsButton.setSelected(true);
        MonthsButton.setText("Months");
        MonthsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthsButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(YearsButton);
        YearsButton.setText("Years");
        YearsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearsButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("choose duration number ");

        buttonGroup2.add(firstDuration);
        firstDuration.setText("3");
        firstDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstDurationActionPerformed(evt);
            }
        });

        buttonGroup2.add(SecondDuration);
        SecondDuration.setSelected(true);
        SecondDuration.setText("4");
        SecondDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecondDurationActionPerformed(evt);
            }
        });

        buttonGroup2.add(ThirdDuration);
        ThirdDuration.setText("8");
        ThirdDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThirdDurationActionPerformed(evt);
            }
        });

        jLabel7.setText("Enter budget (333)");

        budget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetActionPerformed(evt);
            }
        });

        jLabel11.setText("Property types");

        buttonGroup4.add(property1);
        property1.setText("Duplex");
        property1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property1ActionPerformed(evt);
            }
        });

        buttonGroup4.add(property2);
        property2.setSelected(true);
        property2.setText("Hotel Room");

        buttonGroup4.add(property3);
        property3.setText("Villa");
        property3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nightsbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(firstDuration))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(MonthsButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(YearsButton))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(SecondDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ThirdDuration)
                                                .addGap(22, 22, 22)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(budget)
                                .addGap(63, 63, 63))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(status1)
                                    .addComponent(property1)
                                    .addComponent(term1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(budget1)
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(term2)
                                    .addComponent(status2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(status3)
                                    .addComponent(term3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(property2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(property3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nightsbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthsButton)
                            .addComponent(YearsButton))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstDuration)
                            .addComponent(SecondDuration)
                            .addComponent(ThirdDuration))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(term1)
                    .addComponent(term2)
                    .addComponent(term3))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(status1)
                    .addComponent(status2)
                    .addComponent(status3))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(budget1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(property1)
                    .addComponent(property2)
                    .addComponent(property3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void term1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_term1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_term1ActionPerformed

    private void term2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_term2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_term2ActionPerformed

    private void term3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_term3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_term3ActionPerformed

    private void status1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_status1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String value = jComboBox1.getSelectedItem().toString();
        if(value.equals("Cairo"))
        {
            jComboBox2.removeAllItems();
            jComboBox2.addItem("Masr El Gedida");
            jComboBox2.addItem("Zamalek");
            jComboBox2.addItem("Maadi");
             
        }
        else if (value.equals("Giza"))
        {
            jComboBox2.removeAllItems();
            jComboBox2.addItem("Agouza");
            jComboBox2.addItem("Dokki");
            jComboBox2.addItem("October");
        }
        else if (value.equals("Luxor"))
        {
            jComboBox2.removeAllItems();
            jComboBox2.addItem("nothing");
            
        }
         else if (value.equals("Alexanderia"))
        {
            jComboBox2.removeAllItems();
            jComboBox2.addItem("nothing");
        }
         else if(value.equals("Dahab"))
         {
             jComboBox2.removeAllItems();
             jComboBox2.addItem("Blue Hole");
             jComboBox2.addItem("Canyon");
             jComboBox2.addItem("Laguna");
         }
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void status2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status2ActionPerformed
        // TODO add your handling code here:
         try
        {
        String value2 = jComboBox2.getSelectedItem().toString();
   
        if(value2.equals("Masr El Gedida"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("Almazah");
             jComboBox3.addItem("El Korba");
             jComboBox3.addItem("El Nozha");
        }
        if(value2.equals("Zamalek"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("nothing");
             
        }
        if(value2.equals("Maadi"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("Cornich El Maadi");
             
        }
        if(value2.equals("Agouza"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("nothing");
        }   
        if(value2.equals("Dokki"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("nothing");
        }  
        if(value2.equals("October"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("Hay El Motamayez");
             jComboBox3.addItem("West Somid");
        }
        if(value2.equals("nothing"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("nothing");
             
        }  
        if(value2.equals("Blue Hole"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("nothing"); 
        }
        if(value2.equals("Canyon"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("Canyon Estate"); 
             jComboBox3.addItem("Tropitel"); 
        }
        if(value2.equals("Laguna"))
        {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("Gannet Sinai"); 
             jComboBox3.addItem("Golden Heights"); 
        }
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
       
    }//GEN-LAST:event_status2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        try
        {
            String value2 = jComboBox2.getSelectedItem().toString();

            if(value2.equals("Masr El Gedida"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Almazah");
                jComboBox3.addItem("El Korba");
                jComboBox3.addItem("El Nozha");
            }
            if(value2.equals("Zamalek"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");

            }
            if(value2.equals("Maadi"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Cornich El Maadi");

            }
            if(value2.equals("Agouza"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");
            }
            if(value2.equals("Dokki"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");
            }
            if(value2.equals("October"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Hay El Motamayez");
                jComboBox3.addItem("West Somid");
            }
            if(value2.equals("nothing"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");

            }
            if(value2.equals("Blue Hole"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");
            }
            if(value2.equals("Canyon"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Canyon Estate");
                jComboBox3.addItem("Tropitel");
            }
            if(value2.equals("Laguna"))
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Gannet Sinai");
                jComboBox3.addItem("Golden Heights");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void budget1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budget1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_budget1ActionPerformed

    private void nightsbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nightsbuttonActionPerformed
        // TODO add your handling code here:genderGroup.getSelection().getActionCommand();

    }//GEN-LAST:event_nightsbuttonActionPerformed

    private void MonthsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthsButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_MonthsButtonActionPerformed

    private void YearsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearsButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_YearsButtonActionPerformed

    private void firstDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstDurationActionPerformed

    private void SecondDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecondDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SecondDurationActionPerformed

    private void ThirdDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThirdDurationActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ThirdDurationActionPerformed

    private void budgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetActionPerformed
        // TODO add your handling code here:
        //        String b = budget.getText().trim();
        //        if(!(budget.getText().isEmpty()))
        //        {
            //            System.out.println("hehe");
            //        }

    }//GEN-LAST:event_budgetActionPerformed

    private void property1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_property1ActionPerformed

    private void property3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_property3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_property3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Methods t = new Methods();  
       
        if(!(jComboBox1.getSelectedItem().equals("Cairo")))
        {
            String e = jComboBox1.getSelectedItem().toString();
            try {
                t.setCellData(e, 5, 0);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                t.setCellData("z", 5, 0);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!(jComboBox2.getSelectedItem().equals("Masr El Gedida")))
        {
            String e = jComboBox2.getSelectedItem().toString();
            try {
                t.setCellData(e, 5, 1);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                t.setCellData("z", 5, 1);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!(jComboBox3.getSelectedItem().equals("Almazah")))
        {
            String e = jComboBox3.getSelectedItem().toString();
            try {
                t.setCellData(e, 5, 2);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                t.setCellData("z", 5, 2);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
         if(!(SecondDuration.isSelected()))
        {
           
            try {
                if((firstDuration.isSelected()))
                {
                    t.setCellData("3", 5, 4);
                }
                else
                {
                    t.setCellData("8", 5, 4);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                t.setCellData("z", 5, 4);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(!(MonthsButton.isSelected()))
        {
           
            try {
                if((nightsbutton.isSelected()))
                {
                    t.setCellData("nights", 5, 3);
                }
                else
                {
                    t.setCellData("years", 5, 3);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                t.setCellData("z", 5, 3);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
         if(!(budget.getText().isEmpty()))
        {
            String e = budget.getText().trim();
            try {
                t.setCellData(e, 5, 5);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {   
            try {
                t.setCellData("z", 5, 5);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
           
            try {
                if((term1.isSelected()))
                {
                    t.setCellData("z", 5, 6);
                }
                else
                {
                    t.setCellData("NA", 5, 6);
                }
                if ((term2.isSelected()))
                {
                    t.setCellData("Free WiFi", 5, 7);
                }
                else
                {
                    t.setCellData("NA", 5, 7);
                }
                if ((term3.isSelected()))
                {
                    t.setCellData("Mobile charger", 5, 8);
                }
                else
                {
                    t.setCellData("NA", 5, 8);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        
          
          if(!(status2.isSelected()))
        {
           
            try {
                if((status1.isSelected()))
                {
                    t.setCellData("Furnished", 5, 9);
                }
                else
                {
                    t.setCellData("Serviced Apartment", 5, 9);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                t.setCellData("z", 5, 9);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          if(!(budget1.getText().isEmpty()))
        {
            String e = budget1.getText().trim();
            try {
                t.setCellData(e, 5, 10);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {   
            try {
                t.setCellData("z", 5, 10);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          if(!( property2.isSelected()))
        {
           
            try {
                if(( property1.isSelected()))
                {
                    t.setCellData("Duplex", 5, 11);
                }
                else
                {
                    t.setCellData("Villa", 5, 11);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                t.setCellData("z", 5, 11);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          
          
       
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        layeredPane.remove(this);
        layeredPane.getComponentsInLayer(0)[0].setVisible(true);
        layeredPane.revalidate();
        layeredPane.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton MonthsButton;
    private javax.swing.JRadioButton SecondDuration;
    private javax.swing.JRadioButton ThirdDuration;
    private javax.swing.JRadioButton YearsButton;
    private javax.swing.JTextField budget;
    private javax.swing.JTextField budget1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JRadioButton firstDuration;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton nightsbutton;
    private javax.swing.JRadioButton property1;
    private javax.swing.JRadioButton property2;
    private javax.swing.JRadioButton property3;
    private javax.swing.JRadioButton status1;
    private javax.swing.JRadioButton status2;
    private javax.swing.JRadioButton status3;
    private javax.swing.JRadioButton term1;
    private javax.swing.JRadioButton term2;
    private javax.swing.JRadioButton term3;
    // End of variables declaration//GEN-END:variables
}
