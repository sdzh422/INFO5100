/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Analytics;
import Business.Enterprise.Cinema;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodSupplier;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author sdzh4
 */
public class Network {
    private String name;
 private  ArrayList<Enterprise> cinemalist;
 private  ArrayList<Enterprise> supplierlist;
 private  ArrayList<Enterprise> analyticslist;
 public Network()
    {
        cinemalist = new ArrayList<>();
        supplierlist = new ArrayList<>();
        analyticslist = new ArrayList<>();
    }

    /**
     * 
     * @param name
     * @param address
     * @param type  1- CINEMA 2-SUPPLIER 3-ANALYTICS
     */
    public void addEnterprise(String name,String address,int type) 
    {
        switch (type)
        {
            case 1:
                cinemalist.add(new Cinema( name, address, type));
                break;
            case 2:
                supplierlist.add(new FoodSupplier( name, address, type));
                break;
            case 3:
                analyticslist.add(new Analytics( name, address, type));
                break;
        }          
    }

    public ArrayList<Enterprise> getCinemalist() {
        return cinemalist;
    }

    public void setCinemalist(ArrayList<Enterprise> cinemalist) {
        this.cinemalist = cinemalist;
    }

    public ArrayList<Enterprise> getSupplierlist() {
        return supplierlist;
    }

    public void setSupplierlist(ArrayList<Enterprise> supplierlist) {
        this.supplierlist = supplierlist;
    }

    public ArrayList<Enterprise> getAnalyticslist() {
        return analyticslist;
    }

    public void setAnalyticslist(ArrayList<Enterprise> analyticslist) {
        this.analyticslist = analyticslist;
    }
    public UserAccount authenticateUser(String username, String password){
         UserAccount ua =null;
        for (Enterprise enterprise : cinemalist) {
            ua = enterprise.getDepartmentDirectory().authenticateUser(username, password);
            if (ua != null) {
                ua.setEnterprise(enterprise);
                return ua;
            }
        }
        for (Enterprise enterprise : supplierlist) {
            ua = enterprise.getDepartmentDirectory().authenticateUser(username, password);
            if (ua != null) {
                ua.setEnterprise(enterprise);
                return ua;
            }
        }
        for (Enterprise enterprise : analyticslist) {
            ua = enterprise.getDepartmentDirectory().authenticateUser(username, password);
            if (ua != null) {
                ua.setEnterprise(enterprise);
                return ua;
            }
        }
        return ua;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getEnterpriseNum()
    {
        return cinemalist.size()+supplierlist.size()+analyticslist.size();
    }
    @Override
    public String toString()
    {
        return name;
    }
    
}
