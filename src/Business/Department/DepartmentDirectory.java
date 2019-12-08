/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Department.Department.DepartmentType;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author sdzh4
 */
public class DepartmentDirectory {
    private ArrayList<Department> deparmentList;
    public DepartmentDirectory()
    {
        deparmentList = new ArrayList();
//        deparmentList.add(new FoodDepartment());
//        deparmentList.add(new CustomerServiceDepartment());
//        deparmentList.add(new TicketDepartment());
    }

    public ArrayList<Department> getDeparmentList() {
        return deparmentList;
    }

    public void setDeparmentList(ArrayList<Department> deparmentList) {
        this.deparmentList = deparmentList;
    }
     public UserAccount authenticateUser(String username, String password){
         UserAccount ua =null;
         for(Department department:deparmentList)
         {
             ua=department.getUserAccountDirectory().authenticateUser(username, password);
             if(ua!=null)
             {
                 ua.setDepartment(department);
                 return ua;
             }
         }
         return null;
     }

    
}
