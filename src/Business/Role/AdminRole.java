/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.BookingSystem;
import Business.Enterprise.Cinema;
import Business.UserAccount.UserAccount;
import UserInterface.AdminWorkArea.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author sdzh4
 */
public class AdminRole extends Role{

    public AdminRole()
    {
        super(Role.RoleType.ADMIN);
    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account) {
        return new AdminWorkAreaJPanel(userProcessContainer);
    }
    
}
