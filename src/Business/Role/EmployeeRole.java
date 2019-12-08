/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EmployeeWorkArea.ServiceWorkAreaJPanel;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author sdzh4
 */
public class EmployeeRole extends Role{

    public EmployeeRole() {
        super(Role.RoleType.EMPLOYEE);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account) {
       JPanel panel=  new ServiceWorkAreaJPanel(userProcessContainer,account.getEnterprise(),account.getDepartment(),account);
        account.setDepartment(null);
        account.setEnterprise(null);
        return panel;
    }
    
}
