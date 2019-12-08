/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author sdzh4
 */

public abstract class Department {
    public enum DepartmentType
{
    CINEMA_FOOD,CINEMA_TICKET,CINEMA_SERVICE,SUPPLIER_SERVICE,SUPPLIER_TRANSPORTATION,ANALYTICS_MOVIE,ANALYTICS_USER;
}
    private DepartmentType departmentType;
    private UserAccountDirectory userAccountDirectory;
    private WorkQueue workQueue;

    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(DepartmentType departmentType) {
        this.departmentType = departmentType;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    public  Department(DepartmentType departmentType)
    {
        this.departmentType = departmentType;
        userAccountDirectory = new UserAccountDirectory();
        workQueue = new WorkQueue();
    }
    @Override
    public String toString()
    {
        return getDepartmentType().toString();
    }
}
