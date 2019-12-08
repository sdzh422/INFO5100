/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Department.DepartmentDirectory;

/**
 *
 * @author sdzh4
 */
public abstract class Enterprise {
    private String name;
    private String address;
    private DepartmentDirectory departmentDirectory;
    private int type; //cinema 1, foodsupplier 2, analytics 3
    public Enterprise(String name,String address,int type)
    {
        this.name =name;
        this.address = address;
        departmentDirectory = new DepartmentDirectory();
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DepartmentDirectory getDepartmentDirectory() {
        return departmentDirectory;
    }

    public void setDepartmentDirectory(DepartmentDirectory departmentDirectory) {
        this.departmentDirectory = departmentDirectory;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
     
    @Override
    public String toString()
    {
        return name;
    }
    
}
