/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Cinema;
import Business.Department.Department;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Network.NetworkDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author sdzh4
 */
public class BookingSystem {
    private static BookingSystem business;
    private NetworkDirectory networkdirectory;
    private UserAccountDirectory userAccountDirectory;
    public static BookingSystem getInstance(){
        if(business==null){
            business=new BookingSystem();
        }
        return business;
    }
     public static void retreieve(BookingSystem system)
     {
         business = system;
     }
    private BookingSystem()
    {
        userAccountDirectory = new UserAccountDirectory();
        networkdirectory = new NetworkDirectory();
    }
//    public Cinema addCinema(String name,String address)
//    {
//        Cinema temp =new Cinema(name,address);
//        cinemaList.add(temp);
//        return temp;
//    }
    public boolean  checkIfUserIsUnique(String userName)//check if user account is unique in system
    {
        boolean result=true;
        for(Network network:networkdirectory.getNetworklist())   //network loop
        {
            for(Enterprise enterprise:network.getCinemalist()) //cinema loop
            {
                for(Department department:enterprise.getDepartmentDirectory().getDeparmentList()) //department loop
                {
                    result=result&&department.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
                }
            }
            for(Enterprise enterprise:network.getSupplierlist()) //supplier loop
            {
                for(Department department:enterprise.getDepartmentDirectory().getDeparmentList()) //department loop
                {
                    result=result&&department.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
                }
            }
            for(Enterprise enterprise:network.getAnalyticslist()) //analytics loop
            {
                for(Department department:enterprise.getDepartmentDirectory().getDeparmentList()) //department loop
                {
                    result=result&&department.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
                }
            }
        }
        result = result&&userAccountDirectory.checkIfUsernameIsUnique(userName); //admin account
        return result;
    }
    public boolean checkIfEnterpriseUnique(String name,String address)
    {
        for(Network network:networkdirectory.getNetworklist())
        {
            for(Enterprise temp:network.getCinemalist())
            {
                if(temp.getName().equalsIgnoreCase(name)||temp.getAddress().equalsIgnoreCase(address))
                    return false;
            }
            for(Enterprise temp:network.getSupplierlist())
            {
                if(temp.getName().equalsIgnoreCase(name)||temp.getAddress().equalsIgnoreCase(address))
                    return false;
            }
            for(Enterprise temp:network.getAnalyticslist())
            {
                if(temp.getName().equalsIgnoreCase(name)||temp.getAddress().equalsIgnoreCase(address))
                    return false;
            }
        }
        return true;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public NetworkDirectory getNetworkdirectory() {
        return networkdirectory;
    }

    public void setNetworkdirectory(NetworkDirectory networkdirectory) {
        this.networkdirectory = networkdirectory;
    }
    public boolean checkIfNetworkIsUnique(String name)
    {
        for(Network network:business.networkdirectory.getNetworklist())
        {
            if(name.equals(network.getName()))
                return false;
        }
        return true;
    }
    public Enterprise searchCinema(String name)
    {
        for(Network network:networkdirectory.getNetworklist())
        {
            for(Enterprise enterprise:network.getCinemalist())
            {
                if(enterprise.getName().equals(name))
                    return enterprise;
            }
        }
        return null;
    }

    
}
