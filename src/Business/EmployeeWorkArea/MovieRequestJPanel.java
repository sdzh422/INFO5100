/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EmployeeWorkArea;

import Business.BookingSystem;
import Business.Department.Department;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
    

/**
 *
 * @author sdzh4
 */
public class MovieRequestJPanel extends javax.swing.JPanel {
private BookingSystem system;
private Network network;
private UserAccount useraccount;
private Department department;
private JPanel userProcessContainer;
private Enterprise enterprise;
    /**
     * Creates new form SendRequestJPanel
     */
    public MovieRequestJPanel(JPanel userProcessContainer,Enterprise enterprise,Department department,UserAccount useraccount) {
        initComponents();
        system= BookingSystem.getInstance();
        this.userProcessContainer = userProcessContainer;
        this.department = department;
        this.useraccount = useraccount;
        this.enterprise = enterprise;
        switch (useraccount.getDepartmentType())
        {
            case CINEMA_SERVICE:
                jLabel1.setText(" Analysis Request");
                combType.removeAllItems();
                combType.addItem("Movie Performence");
                combType.addItem("Food Sales");
                combType.addItem("Food Request Analysis");
                break;
            case CINEMA_TICKET:
                combType.removeAllItems();
                combType.addItem("Movie Box Office");
                break;
        }
        populateCombNetwork();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combEnterprise = new javax.swing.JComboBox();
        btnCreate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        combNetwork = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combType = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(jEditorPane1);

        jLabel1.setText("Ticket Work Request");

        jLabel2.setText("  Analysis company ");

        combEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel3.setText("Network");

        combNetwork.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combNetworkActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setText("Type");

        combType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCreate)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(327, 327, 327))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combEnterprise, 0, 111, Short.MAX_VALUE)
                            .addComponent(combNetwork, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(71, 71, 71)
                .addComponent(btnBack)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnBack))
                .addGap(168, 168, 168))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combNetworkActionPerformed
        // TODO add your handling code here:
        network = (Network)combNetwork.getSelectedItem();
        if(network!=null)
        {
            populateCombEnterprise();
        }
    }//GEN-LAST:event_combNetworkActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        Enterprise tempenterprise = (Enterprise) combEnterprise.getSelectedItem();
        if (tempenterprise == null) {
            return;
        }
        WorkRequest wr = new WorkRequest("");;
        wr.setSender(useraccount);
        wr.setStatus("waiting");
        switch (useraccount.getDepartmentType()) {
            case CINEMA_SERVICE:
                switch (combType.getSelectedIndex() ) {
                    case 0:
                    wr.setMessage(1 + ",Movie Performence,"+enterprise.getName());
                    break;
                    case 1:
                    wr.setMessage(2 + ",Food Sales,"+enterprise.getName());
                    break;
                    case 2:
                        wr.setMessage(3 + ",Food Request Analysis,"+enterprise.getName());
                        break;
                }
                wr.setType(3);
                tempenterprise.getDepartmentDirectory().getDeparmentList().get(1).getWorkQueue().getWorkRequestList().add(wr);
                break;
            case CINEMA_TICKET:
                wr.setMessage(",Box Office Result,"+enterprise.getName()); // enterprise
                wr.setType(2);
                tempenterprise.getDepartmentDirectory().getDeparmentList().get(0).getWorkQueue().getWorkRequestList().add(wr);
                break;
        }
        useraccount.getWorkQueue().getWorkRequestList().add(wr);
        department.getWorkQueue().getWorkRequestList().add(wr);
        JOptionPane.showMessageDialog(null, "Created Successfully");
        Back();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Back();
    }//GEN-LAST:event_btnBackActionPerformed
public void populateCombNetwork()
{
    combNetwork.removeAllItems();
    for(Network network:system.getNetworkdirectory().getNetworklist())
    {
        combNetwork.addItem(network);
    }
}
public void populateCombEnterprise()
{
    combEnterprise.removeAllItems();
    for(Enterprise enterprise:network.getAnalyticslist())
    {
        combEnterprise.addItem(enterprise);
    }
}
public void Back()
{
         userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ServiceWorkAreaJPanel serviceworkarea = (ServiceWorkAreaJPanel) component;
        serviceworkarea.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox combEnterprise;
    private javax.swing.JComboBox combNetwork;
    private javax.swing.JComboBox<String> combType;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
