/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Department.AnalyticsMovie;
import Business.Department.AnalyticsUser;
import Business.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author sdzh4
 */
public class Analytics extends Enterprise{
    
    public Analytics(String name, String address, int type) {
        super(name, address, type);
        ArrayList<Department> departmentlist =super.getDepartmentDirectory().getDeparmentList();
        departmentlist.add(new AnalyticsMovie());
        departmentlist.add(new AnalyticsUser());
    }
    
}
