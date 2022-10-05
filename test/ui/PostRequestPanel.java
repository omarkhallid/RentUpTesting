/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import demo.Methods;
import demo.logintest;
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

        buttons = new javax.swing.ButtonGroup();
        buttons2 = new javax.swing.ButtonGroup();
        buttons3 = new javax.swing.ButtonGroup();
        buttons4 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        MonthsButton = new javax.swing.JRadioButton();
        YearsButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        firstDuration = new javax.swing.JRadioButton();
        SecondDuration = new javax.swing.JRadioButton();
        ThirdDuration = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        budget = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        term1 = new javax.swing.JRadioButton();
        term2 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        status1 = new javax.swing.JRadioButton();
        status2 = new javax.swing.JRadioButton();
        status3 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        budget1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        property1 = new javax.swing.JRadioButton();
        property2 = new javax.swing.JRadioButton();
        property3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Post a Request Form");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cairo", "Giza", "Luxor", "Alexanderia", "Dahab" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masr El Gedida", "Zamalek", "Maadi" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Select a City ");

        jLabel3.setText("Select a district");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almazah", "El Korba", "El Nozha" }));

        jLabel4.setText("Select neighbourhood");

        jLabel5.setText("choose duration");

        buttons.add(MonthsButton);
        MonthsButton.setSelected(true);
        MonthsButton.setText("Months");
        MonthsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthsButtonActionPerformed(evt);
            }
        });

        buttons.add(YearsButton);
        YearsButton.setText("Years");
        YearsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearsButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("choose duration number ");

        buttons2.add(firstDuration);
        firstDuration.setText("3");
        firstDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstDurationActionPerformed(evt);
            }
        });

        buttons2.add(SecondDuration);
        SecondDuration.setSelected(true);
        SecondDuration.setText("4");
        SecondDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecondDurationActionPerformed(evt);
            }
        });

        buttons2.add(ThirdDuration);
        ThirdDuration.setText("6");
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

        jLabel8.setText("choose a term ");

        term1.setSelected(true);
        term1.setText("Allow smoking");
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

        jLabel9.setText("Furnishing status");

        buttons3.add(status1);
        status1.setText("Furnished");
        status1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status1ActionPerformed(evt);
            }
        });

        buttons3.add(status2);
        status2.setSelected(true);
        status2.setText("Unfurnished");
        status2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status2ActionPerformed(evt);
            }
        });

        buttons3.add(status3);
        status3.setText("Serviced Apartment");

        jLabel10.setText("Minimum rooms (2)");

        budget1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budget1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Property types");

        buttons4.add(property1);
        property1.setText("Duplex");
        property1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                property1ActionPerformed(evt);
            }
        });

        buttons4.add(property2);
        property2.setSelected(true);
        property2.setText("Hotel Room");

        buttons4.add(property3);
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
                .addGap(243, 243, 243)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(property1)
                                    .addComponent(status1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(status2)
                                        .addGap(63, 63, 63)
                                        .addComponent(status3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(property2)
                                                .addGap(63, 63, 63)
                                                .addComponent(property3))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(127, 127, 127)
                                .addComponent(MonthsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(YearsButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(57, 57, 57)
                                .addComponent(term1)
                                .addGap(36, 36, 36)
                                .addComponent(term2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(SecondDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(79, 79, 79)
                                .addComponent(firstDuration)
                                .addGap(160, 160, 160)
                                .addComponent(ThirdDuration)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addComponent(budget1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MonthsButton)
                    .addComponent(YearsButton)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(firstDuration)
                        .addComponent(SecondDuration)
                        .addComponent(ThirdDuration)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(term1)
                    .addComponent(term2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(status1)
                    .addComponent(status2)
                    .addComponent(status3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(budget1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(property1)
                    .addComponent(property2)
                    .addComponent(property3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void term1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_term1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_term1ActionPerformed

    private void term2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_term2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_term2ActionPerformed

    private void status1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_status1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String value = jComboBox1.getSelectedItem().toString();
        
        switch(value){
        
            case "Cairo":{
            jComboBox2.removeAllItems();
            jComboBox2.addItem("Masr El Gedida");
            jComboBox2.addItem("Zamalek");
            jComboBox2.addItem("Maadi");         
            break;
            }
            case "Giza":
        {
            jComboBox2.removeAllItems();
            jComboBox2.addItem("Agouza");
            jComboBox2.addItem("Dokki");
            jComboBox2.addItem("October");
            break;
        }
            case"Luxor":
        {
            jComboBox2.removeAllItems();
            jComboBox2.addItem("nothing");
            break;
            
        }
            case "Alexanderia":
        {
            jComboBox2.removeAllItems();
            jComboBox2.addItem("Miami");
            break;
        }
            case "Dahab":
         {
             jComboBox2.removeAllItems();
             jComboBox2.addItem("Blue Hole");
             jComboBox2.addItem("Canyon");
             jComboBox2.addItem("Laguna");
             break;
         }
         
         default:
             System.out.println("Error in Selecting Cities");
        
        }
        
     
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void status2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_status2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        try
        {
            String value2 = jComboBox2.getSelectedItem().toString();
               
            switch(value2){
               case "Masr El Gedida":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Almazah");
                jComboBox3.addItem("El Korba");
                jComboBox3.addItem("El Nozha");
                break;
            }
               case "Zamalek":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");
                   break;
            }
               case "Miami":
            {
             jComboBox3.removeAllItems();
             jComboBox3.addItem("nothing");
             break;
            }   
               case "Maadi":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Cornich El Maadi");
                break;
            }
               case "Agouza":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");
                break;
            }
               case "Dokki":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");
                break;
            }
               case "October":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Hay El Motamayez");
                jComboBox3.addItem("West Somid");
                break;
            }
               case "nothing":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");
                break;
            }
               case "Blue Hole":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("nothing");
                break;
            }
               case "Canyon":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Canyon Estate");
                jComboBox3.addItem("Tropitel");
                break;
            }
               case "Laguna":
            {
                jComboBox3.removeAllItems();
                jComboBox3.addItem("Gannet Sinai");
                jComboBox3.addItem("Golden Heights");
                break;
            }
            
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
                Methods.setCellData(e, 5, 0);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                Methods.setCellData("z", 5, 0);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!(jComboBox2.getSelectedItem().equals("Masr El Gedida")))
        {
            String e = jComboBox2.getSelectedItem().toString();
            try {
                Methods.setCellData(e, 5, 1);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                Methods.setCellData("z", 5, 1);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(!(jComboBox3.getSelectedItem().equals("Almazah")))
        {
            String e = jComboBox3.getSelectedItem().toString();
            try {
                Methods.setCellData(e, 5, 2);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                Methods.setCellData("z", 5, 2);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
         if(!(SecondDuration.isSelected()))
        {
           
            try {
                if((firstDuration.isSelected()))
                {
                    Methods.setCellData("3", 5, 4);
                }
                else
                {
                    Methods.setCellData("6", 5, 4);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                Methods.setCellData("z", 5, 4);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         if(!(MonthsButton.isSelected()))
        {
           
            try {
                if((YearsButton.isSelected()))
                {
                    Methods.setCellData("years", 5, 3);
                }           
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                Methods.setCellData("z", 5, 3);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
         if(!(budget.getText().isEmpty()))
        {
            String e = budget.getText().trim();
            try {
                Methods.setCellData(e, 5, 5);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {   
            try {
                Methods.setCellData("z", 5, 5);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         
           
            try {
                if((term1.isSelected()))
                {
                    Methods.setCellData("z", 5, 6);
                }
                else
                {
                    Methods.setCellData("NA", 5, 6);
                }
                if ((term2.isSelected()))
                {
                    t.setCellData("Free WiFi", 5, 7);
                }
                else
                {
                    Methods.setCellData("NA", 5, 7);
                }
               
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        
          
          if(!(status2.isSelected()))
        {
           
            try {
                if((status1.isSelected()))
                {
                    Methods.setCellData("Furnished", 5, 9);
                }
                else
                {
                    Methods.setCellData("Serviced Apartment", 5, 9);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                Methods.setCellData("z", 5, 9);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          if(!(budget1.getText().isEmpty()))
        {
            String e = budget1.getText().trim();
            try {
                Methods.setCellData(e, 5, 10);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {   
            try {
                Methods.setCellData("z", 5, 10);
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          if(!( property2.isSelected()))
        {
           
            try {
                if(( property1.isSelected()))
                {
                    Methods.setCellData("Duplex", 5, 11);
                }
                else
                {
                    Methods.setCellData("Villa", 5, 11);
                }
                
            } catch (Exception ex) {
                Logger.getLogger(PostRequestPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        else
        {
            try {
                Methods.setCellData("z", 5, 11);
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
    private javax.swing.ButtonGroup buttons;
    private javax.swing.ButtonGroup buttons2;
    private javax.swing.ButtonGroup buttons3;
    private javax.swing.ButtonGroup buttons4;
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
    private javax.swing.JRadioButton property1;
    private javax.swing.JRadioButton property2;
    private javax.swing.JRadioButton property3;
    private javax.swing.JRadioButton status1;
    private javax.swing.JRadioButton status2;
    private javax.swing.JRadioButton status3;
    private javax.swing.JRadioButton term1;
    private javax.swing.JRadioButton term2;
    // End of variables declaration//GEN-END:variables
}
