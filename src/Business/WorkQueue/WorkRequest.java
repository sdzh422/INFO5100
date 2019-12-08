/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author sdzh4
 *  cinema data
 *  <0> - init data
 *  Ticket :  message - <0>,<movieID>,<ticket num> ,<userID>
 *  Food      message - <0>,<FoodID>,<num> ,<userID>             
 *  Movieperformance - <0>,<MovieID>,<Performance>, <userID>
 *  make a map int - String to show the relationship between movie and ID
 *  food map:....     1. popcorn  2. Coke 3. Sprite  4.Dr.pepper  5. ice-cream 6.  BarkTHINS Dark Chocolate Pretzel with Sea Salt $5
 *  food 6
 * movie 20
 * film audience 2000
 * 
 * normal request
 * <typenum>,<type text>,<from>
 */
public  class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private int type; //different request have different type
    private Date requestDate;
    private Date resolveDate;
    public static int CINEMA_FOOD=1;   
    public static int CINEMA_TICKET=2;
    public static int CINEMA_SERVICE=3;
    public static int SUPPLIER_SERVICE=4;
    public static int SUPPLIER_TRANSPORTATION=5;
    public static int ANALYTICS_MOVIE=6;
     public static int ANALYTICS_USER=7;
    public WorkRequest(String message){
//        requestDate = new Date();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public String toString()
    {
        return status;
    }
    
}
