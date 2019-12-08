package Business;

import Business.Department.Department;
import Business.Employee.Employee;
import Business.Role.AdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static BookingSystem configure(){
        
        BookingSystem system = BookingSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin", "admin",null,null,new AdminRole() );
        return system;
    }
    
}
