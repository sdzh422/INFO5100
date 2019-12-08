/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.BookingSystem;
import Business.Enterprise.Cinema;
import Business.Department.Department;
import Business.Department.Department.DepartmentType;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author sdzh4
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
private BookingSystem system;
    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public AdminWorkAreaJPanel(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        system = BookingSystem.getInstance();
        populateTree();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelectedNode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnManage = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();

        lblSelectedNode.setText("<View_selected_node>");

        jLabel1.setText("Selected Node:");

        btnManage.setText("Manage System");
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(lblSelectedNode))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnManage, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblSelectedNode))
                        .addGap(100, 100, 100)
                        .addComponent(btnManage)
                        .addGap(48, 48, 48)
                        .addComponent(btnDelete)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
public void populateTree(){
       DefaultTreeModel model=(DefaultTreeModel)jTree.getModel();
        ArrayList<Network> networkList=system.getNetworkdirectory().getNetworklist();
        
        ArrayList<Department> departmentList;
        
        Network network;
        Enterprise enterprise;
        Department department;
        
        DefaultMutableTreeNode networks=new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.setUserObject("Ecosystem");
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode departmentNode;
        
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            networkNode=new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
            ArrayList<Enterprise> enterpriseList= new ArrayList<>();
            enterpriseList.addAll(network.getAnalyticslist());
            enterpriseList.addAll(network.getCinemalist());
            enterpriseList.addAll(network.getSupplierlist());
            for(int j=0; j<enterpriseList.size();j++){
                enterprise=enterpriseList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
                
                departmentList=enterprise.getDepartmentDirectory().getDeparmentList();
                for(int k=0;k<departmentList.size();k++){
                    department=departmentList.get(k);
                    departmentNode=new DefaultMutableTreeNode(department.toString());
                    enterpriseNode.insert(departmentNode, k);
                }
            }
        }
        model.reload();
    }
    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged

        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged

    private void btnManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        CardLayout crdLyt ;
        String Networkname=null;
        String Enterprisename;
        if(selectedNode!=null)
        {
        switch (selectedNode.getLevel())
        {
            case 0://network
            case 1://network
                userProcessContainer.add("NetworkManage", new ManageNetworkJPanel(userProcessContainer));
                crdLyt = (CardLayout) userProcessContainer.getLayout();
                crdLyt.next(userProcessContainer);
                break;
            case 2://network
                Networkname = selectedNode.toString();
            case 3://enterprise(enterpriselist)
                if(Networkname==null)
                {
                Networkname = selectedNode.getParent().toString();
                }
                for(Network network:system.getNetworkdirectory().getNetworklist())
                {
                    if(network.getName().equals(Networkname))
                    {
                        userProcessContainer.add("EnterpriseManage", new ManageEnterpriseJPanel(userProcessContainer,network));
                        crdLyt = (CardLayout) userProcessContainer.getLayout();
                        crdLyt.next(userProcessContainer);
                        return;
                    }
                }
            case 4: //department
                Networkname = selectedNode.getParent().getParent().toString();
                Enterprisename = selectedNode.getParent().toString();
                for(Network network:system.getNetworkdirectory().getNetworklist())
                {    
                     if(network.getName().equals(Networkname))
                     {
                         ArrayList<Enterprise> temp = new ArrayList<>();
                         temp.addAll( network.getAnalyticslist());
                         temp.addAll(network.getCinemalist());
                         temp.addAll(network.getSupplierlist());
                         for(Enterprise enterprise:temp)
                         {
                             if(enterprise.getName().equals(Enterprisename))
                             {
                                 for(Department department:enterprise.getDepartmentDirectory().getDeparmentList())
                                 {
                                     if(department.toString().equals(selectedNode.toString()))
                                     {
                                         userProcessContainer.add("DetmentManage", new ManageDepartmentJPanel(userProcessContainer,department));
                                        crdLyt = (CardLayout) userProcessContainer.getLayout();
                                        crdLyt.next(userProcessContainer);
                                        return;
                                     }
                                 }
                             }
                         }
                     }
                }
          }
        }
        else
        {
             JOptionPane.showMessageDialog(null,"Please select a node");
        }
    }//GEN-LAST:event_btnManageActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
        String Networkname = null;
        String Enterprisename;
        if (selectedNode != null) {
            switch (selectedNode.getLevel()) {
                case 1:
                    system.getNetworkdirectory().getNetworklist().clear();
                    populateTree();
                    break;
                case 2:
                    Networkname = selectedNode.toString();
                    for (Network network : system.getNetworkdirectory().getNetworklist()) {
                        if (network.getName().equals(Networkname)) {
                            system.getNetworkdirectory().getNetworklist().remove(network);
                            populateTree();
                        }
                    }
                    break;
                case 3:
                    Networkname = selectedNode.getParent().toString();
                    Enterprisename = selectedNode.toString();
                    for (Network network : system.getNetworkdirectory().getNetworklist()) {
                        if (network.getName().equals(Networkname)) {
                            ArrayList<Enterprise> temp = new ArrayList<>();
                            temp.addAll(network.getAnalyticslist());
                            temp.addAll(network.getCinemalist());
                            temp.addAll(network.getSupplierlist());
                            for (Enterprise enterprise : temp) {
                                if (enterprise.getName().equals(Enterprisename)) {
                                    network.getAnalyticslist().remove(enterprise);
                                    network.getCinemalist().remove(enterprise);
                                    network.getSupplierlist().remove(enterprise);
                                    populateTree();
                                }
                            }
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "You don't havt this right");
                    break;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a node first");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnManage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblSelectedNode;
    // End of variables declaration//GEN-END:variables
}
