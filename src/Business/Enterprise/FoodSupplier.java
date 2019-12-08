/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Department.Department;
import Business.Department.SupplierServiceDepartment;
import Business.Department.SupplierTransportationDepartment;
import java.util.ArrayList;

/**
 *
 * @author sdzh4
 */
public class FoodSupplier extends Enterprise{
    
    public FoodSupplier(String name, String address, int type) {
        super(name, address, type);
        ArrayList<Department> departmentlist =super.getDepartmentDirectory().getDeparmentList();
        departmentlist.add(new SupplierServiceDepartment());
        departmentlist.add(new SupplierTransportationDepartment());
    }
    
}
