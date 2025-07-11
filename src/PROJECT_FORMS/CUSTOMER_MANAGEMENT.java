/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PROJECT_FORMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ELDERGOD McCULLEN
 */
public class CUSTOMER_MANAGEMENT extends javax.swing.JFrame {

    /**
     * Creates new form CUSTOMER_MANAGEMENT
     */
    public CUSTOMER_MANAGEMENT() {
        initComponents();
        connect();
        setTitle("SHOP MANAGEMENT - CUSTOMER MANAGEMENT");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    Connection con;
    PreparedStatement pst;
    
    //===================================== CONNECTION STRING ====================================================================================================================================================
    public void connect(){
        try {                                    
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_management","CIAN McCULLEN","BARON23790draxum100%");   
            
            System.out.println("CONNECTION SUCCESSFULL");                       //CODE FOR CONNECTING TO THE DATABASE
        } catch (ClassNotFoundException | SQLException ex) {
             JOptionPane.showMessageDialog(this, "YOU ARE NOT CONNECTED TO THE DATABASE","SHOP MANAGEMENT", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PRODUCT_MANAGEMENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //===================================== CONNECTION STRING ===============================================================================================================================================
 
    
    //===================================== UPDATE DATABASE FUNCTION =====================================================================================================================================================
    private void table_update(){          // THIS FUNCTION IS FOR UPDATING THE DATABASE AFTER ANY OPERATION HAS BEEN DONE ON IT
       int CC;
        try {
        pst = con.prepareStatement("SELECT * FROM `shop_management`.`customers`");
        ResultSet Rs = pst.executeQuery();
        ResultSetMetaData RSMD = Rs.getMetaData();
        CC = RSMD.getColumnCount();
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();         //THIS METHOD WILL ALWAYS BE EXECUTED WHENEVER AN ACTION IS DONE ON THE DATABASE
        DFT.setRowCount(0);
        
        while (Rs.next()) {
            Vector v2 = new Vector();
            
            //LOOP THROUGH EACH COLUMN AND ADD THE CORRESSPONDING DATA TO THE VECTOR
            for (int li = 1; li <= CC; li++) {
                v2.add(Rs.getString(li)); //RETRIEVING DATA USING THE COLUMN INDEX,NOT THE COLUMN NAMES
            }
            DFT.addRow(v2);
        }  
        } catch (SQLException e) {
        // Handle exceptions properly, e.g., log or show error message
        e.printStackTrace();
        }
    }
    //================================================= UPDATE DATABASE FUNCTION ===================================================================================================================================
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LOAD_RECORDS = new javax.swing.JButton();
        UPDATE_RECORD = new javax.swing.JButton();
        SAVE_RECORD = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DELETE_RECORD = new javax.swing.JButton();
        NEW_RECORDS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 51));

        jTextField1.setFont(new java.awt.Font("Century Schoolbook", 0, 20)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Century Schoolbook", 0, 20)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel3.setText("NAME");

        jTextField3.setFont(new java.awt.Font("Century Schoolbook", 0, 20)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel4.setText("PHONE NUMBER");

        LOAD_RECORDS.setBackground(new java.awt.Color(0, 102, 102));
        LOAD_RECORDS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LOAD_RECORDS.setText("LOAD RECORDS");
        LOAD_RECORDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOAD_RECORDSActionPerformed(evt);
            }
        });

        UPDATE_RECORD.setBackground(new java.awt.Color(0, 102, 102));
        UPDATE_RECORD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        UPDATE_RECORD.setText("UPDATE CUSTOMER");
        UPDATE_RECORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATE_RECORDActionPerformed(evt);
            }
        });

        SAVE_RECORD.setBackground(new java.awt.Color(0, 102, 102));
        SAVE_RECORD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SAVE_RECORD.setText("SAVE CUSTOMER");
        SAVE_RECORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVE_RECORDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CUSTOMER MANAGEMENT");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CUSTOMER ID", "NAME", "E-MAIL ADDRESS", "PHONE NUMBER"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jLabel10.setText("SEARCH CUSTOMER");

        jTextField8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField8PropertyChange(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Century Schoolbook", 0, 20)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel5.setText("E-MAIL ADDRESS");

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel2.setText("CUSTOMER ID");

        DELETE_RECORD.setBackground(new java.awt.Color(0, 102, 102));
        DELETE_RECORD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        DELETE_RECORD.setText("DELETE CUSTOMER");
        DELETE_RECORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETE_RECORDActionPerformed(evt);
            }
        });

        NEW_RECORDS.setBackground(new java.awt.Color(0, 102, 102));
        NEW_RECORDS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        NEW_RECORDS.setText("NEW RECORD");
        NEW_RECORDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEW_RECORDSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(147, 147, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UPDATE_RECORD, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DELETE_RECORD, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NEW_RECORDS, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(SAVE_RECORD, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LOAD_RECORDS, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138)))))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NEW_RECORDS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SAVE_RECORD, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UPDATE_RECORD, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DELETE_RECORD, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(LOAD_RECORDS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    
    //==================================== CODE FOR LOADING THE RECORDS ONTO THE TABLE FRESHLY ======================================================================================================================
    private void LOAD_RECORDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOAD_RECORDSActionPerformed
        table_update();
    }//GEN-LAST:event_LOAD_RECORDSActionPerformed
    //==================================== CODE FOR LOADING THE RECORDS ONTO THE TABLE FRESHLY ============================================================================================================================
   
    
    //========================================= CODE FOR UPDATING A RECORD ===================================================================================================================================================
    private void UPDATE_RECORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATE_RECORDActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();

            String id,name,email,phone;

            id = jTextField1.getText();
            name = jTextField2.getText();
            email= jTextField3.getText();
            phone= jTextField4.getText();

            pst = con.prepareStatement("UPDATE `shop_management`.`customers` SET `CUSTOMER ID`=?, `NAME`=?, `E-MAIL`=?, `PHONE`=? WHERE `CUSTOMER ID`=?");

            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.setString(5, id);          // EMPHASIS SINCE THE CUSTOMER ID IS THE PRIMARY KEY

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "CUSTOMER DETAILS UPDATED SUCCESSFULLY","SHOP MANAGEMENT", JOptionPane.INFORMATION_MESSAGE);
            table_update();

            jTextField1.requestFocus();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "CUSTOMER DETAILS NOT UPDATED!","SHOP MANAGEMENT", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PRODUCT_MANAGEMENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UPDATE_RECORDActionPerformed
    //============================================= CODE FOR UPDATING A RECORD ===========================================================================================================================================================
  
    //==================================== CODE FOR SAVING A NEW RECORD =========================================================================================================================================================================
    private void SAVE_RECORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVE_RECORDActionPerformed
        try {
            String id, name, email, phone;

            id = jTextField1.getText();
            name = jTextField2.getText();
            email = jTextField3.getText();
            phone = jTextField4.getText();

            pst = con.prepareStatement("INSERT INTO `shop_management`.`customers`(`CUSTOMER ID`, `NAME`, `E-MAIL`, `PHONE`) VALUES (?, ?, ?, ?)");

            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setString(4, phone);
            
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "CUSTOMER DETAILS SAVED SUCCESSFULLY","SHOP MANAGEMENT", JOptionPane.INFORMATION_MESSAGE);

            jTextField1.setText("");
            jTextField2.setText("");  //CLEARING THE TEXTFIELDS AFTER INSERTING A RECORD
            jTextField3.setText("");
            jTextField4.setText("");

            table_update();
            jTextField1.requestFocus();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "CUSTOMER DETAILS NOT SAVED.","SHOP MANAGEMENT", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PRODUCT_MANAGEMENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SAVE_RECORDActionPerformed
   //==================================== CODE FOR SAVING A NEW RECORD ==========================================================================================================================================================
  
    
    //================================ CODE FOR PASSING DATA FROM THE TABLE ONTO THE TEXTBOXES ========================================================================================================
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel  model=(DefaultTableModel) jTable1.getModel();
        int selectedIndex=jTable1.getSelectedRow();

        jTextField1.setText(model.getValueAt(selectedIndex, 0).toString());
        jTextField2.setText(model.getValueAt(selectedIndex, 1).toString());
        jTextField3.setText(model.getValueAt(selectedIndex, 2).toString());
        jTextField4.setText(model.getValueAt(selectedIndex, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked
   //============================= CODE FOR PASSING DATA FROM THE TABLE ONTO THE TEXTBOXES =======================================================================================================================
 
    private void jTextField8PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField8PropertyChange

    }//GEN-LAST:event_jTextField8PropertyChange

    //========================== CODE FOR THE SEARCH TEXTBOX TO ENABLE SEARCHING FOR ANY PRODUCT ====================================================================================================================================
    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        DefaultTableModel ob = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> model = new TableRowSorter<> (ob);
        jTable1.setRowSorter(model);
        model.setRowFilter(RowFilter.regexFilter(jTextField8.getText()));
    }//GEN-LAST:event_jTextField8KeyReleased
  //======================= CODE FOR THE SEARCH TEXTBOX TO ENABLE SEARCHING FOR ANY PRODUCT ===============================================================================================================================
  
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    //=========================================== CODE FOR DELETING A RECORD ======================================================================================================================================================
    private void DELETE_RECORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETE_RECORDActionPerformed
        try {
            String id = jTextField1.getText();   //ASSUMING YOU ONLY NEED THE CUSTOMER ID FOR DELETION,DECLARING IT AND GIVING IT A VALUE

            pst = con.prepareStatement("DELETE FROM `shop_management`.`customers` WHERE `CUSTOMER ID`=?");

            pst.setString(1, id);    //SET THE CUSTOMER ID AS THE REFERENCE FOR DELETION

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "CUSTOMER DETAILS DELETED SUCCESSFULLY","SHOP MANAGEMENT", JOptionPane.INFORMATION_MESSAGE);
            table_update();

            jTextField1.setText("");
            jTextField2.setText("");           // CLEARING THE TEXTFIELDS AFTER DELETING A RECORD
            jTextField3.setText("");
            jTextField4.setText("");

            jTextField1.requestFocus();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "CUSTOMER DETAILS NOT DELETED!","SHOP MANAGEMENT", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PRODUCT_MANAGEMENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DELETE_RECORDActionPerformed
    //=============================================== CODE FOR DELETING A RECORD ========================================================================================================================================
  
    //==================================== CODE FOR CREATING A NEW RECORD ===============================================================================================================================
    private void NEW_RECORDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEW_RECORDSActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");           // BASICALLY CLEARING THE TEXTFIELDS TO INSERT A NEW RECORD
        jTextField3.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_NEW_RECORDSActionPerformed
    //==================================== CODE FOR CREATING A NEW RECORD ===========================================================================================================================================
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CUSTOMER_MANAGEMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CUSTOMER_MANAGEMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CUSTOMER_MANAGEMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CUSTOMER_MANAGEMENT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CUSTOMER_MANAGEMENT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE_RECORD;
    private javax.swing.JButton LOAD_RECORDS;
    private javax.swing.JButton NEW_RECORDS;
    private javax.swing.JButton SAVE_RECORD;
    private javax.swing.JButton UPDATE_RECORD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
