/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Test;

import Business.Enterprise.Cinema;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sdzh4
 */
public class RandomData {
    private ArrayList<WorkRequest> ticket;
    private ArrayList<WorkRequest> food;
    private ArrayList<WorkRequest> performance;
    public RandomData()
    {
        ticket = new ArrayList<>();
        food = new ArrayList<>();
        performance = new ArrayList<>();
    }
    public void addRandomData()
    {
        Random random = new Random();
        int FoodkKinds = 6;
        int MovieNum = 20;
        int FileAudience = 1000;
        int AudienceIDrange = 700;
        int ticketrange =3;
        int foodrange = 3;
        double BuyRate = 0.8;
        double ReviewRate =0.8;
        int Performancerange = 5;
        //Favorable rate -  movie has over 80% good reviews(performace>4)
        double FavorableRate  = 0.6;
        for(int i=0;i<FileAudience;i++)
        {
            int userid = random.nextInt(AudienceIDrange);
            int movieid = random.nextInt(20);
            int ticketnum =random.nextInt(ticketrange-1)+1;
            ticket.add(new WorkRequest(0+","+movieid+","+ticketnum+","+userid));
            if(random.nextDouble()<BuyRate)
            {
                int foodid=random.nextInt(6);
                int foodnum = random.nextInt(foodrange-1)+1;
                food.add(new WorkRequest(0+","+foodid+","+foodnum+","+userid));
            }
            if(random.nextDouble()<ReviewRate)
            {
                double grade;
                if(random.nextDouble()<FavorableRate)  //favor
                {
                    grade=4+random.nextInt(11)/10;
                }
                else
                {
                    grade = random.nextInt(41)/10;
                }
                performance.add(new WorkRequest(0+","+movieid+","+grade+","+userid));
            }
        }         
    }

    public ArrayList<WorkRequest> getTicket() {
        return ticket;
    }

    public void setTicket(ArrayList<WorkRequest> ticket) {
        this.ticket = ticket;
    }

    public ArrayList<WorkRequest> getFood() {
        return food;
    }

    public void setFood(ArrayList<WorkRequest> food) {
        this.food = food;
    }

    public ArrayList<WorkRequest> getPerformance() {
        return performance;
    }

    public void setPerformance(ArrayList<WorkRequest> performance) {
        this.performance = performance;
    }
    
}
