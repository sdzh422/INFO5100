/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.BookingSystem;
import Business.Enterprise.Cinema;
import Business.UserAccount.UserAccount;
import UserInterface.ManagerWorkArea.ManageEmployeeJPanel;
import javax.swing.JPanel;

/**
 *
 * @author sdzh4
 */
public class ManagerRole extends Role{

    public ManagerRole() {
        super(Role.RoleType.MANAGER);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account) {
        JPanel panel=  new ManageEmployeeJPanel(userProcessContainer,account.getDepartment());
        account.setDepartment(null);
        account.setEnterprise(null);
        return panel;
    }
    
}
