/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.BookingSystem;
import Business.Enterprise.Cinema;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author sdzh4
 */

public abstract class Role {
    public enum RoleType
{
    EMPLOYEE,MANAGER,GENERALUSER,VIPUSER,ADMIN;
}
    private RoleType roleType;
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account);
    public Role(RoleType roleType)
    {
        this.roleType = roleType;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    
}
