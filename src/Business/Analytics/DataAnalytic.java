/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Analytics;

import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sdzh4
 */
public class DataAnalytic implements Analytic{
/**
 *  1: movieid - tickets 2: food id - num
 * @param history work request list  (type  0)
 * @return 
 */
    @Override
    public Map<Integer, Double> toMap(ArrayList<WorkRequest> history) {
        String tempstring = "";
        int id=0;
        double tempdouble;
        Map<Integer, Double> result = new HashMap<>();
        for(WorkRequest wr:history)
        {
            tempstring = wr.getMessage();
            String[] temp = tempstring.split(",");
            id = Integer.valueOf(temp[1]);
            tempdouble = Double.valueOf(temp[2]);
            if(result.containsKey(id))
            {
                double old = result.get(id);
                result.put(id, old+tempdouble);
            }
            else
            {
                result.put(id, tempdouble);
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Double> toMap_performence(ArrayList<WorkRequest> history) {
        String tempstring = "";
        int id=0;
        double tempdouble;
        Map<Integer, Double> result = new HashMap<>();
        Map<Integer,Integer> count = new  HashMap<>();
        for(WorkRequest wr:history)
        {
            tempstring = wr.getMessage();
            String[] temp = tempstring.split(",");
            id = Integer.valueOf(temp[1]);
            tempdouble = Double.valueOf(temp[2]);
            if(result.containsKey(id))
            {
                double old = result.get(id);
                result.put(id, old+tempdouble);
                old = count.get(id);
                count.put(id, (int)old+1);
            }
            else
            {
                result.put(id, tempdouble);
                count.put(id, 1);
            }
        }
        for(int i=0;i<result.size();i++)
        {
            tempdouble=result.get(i);
            int num = count.get(i);
            result.put(i, tempdouble/num);            
        }
        return result;
    }
    public ArrayList<WorkRequest> changeType( ArrayList<WorkRequest> WorkRequest)
    {
        ArrayList<WorkRequest> Result = new ArrayList<>();
        for(WorkRequest wr:WorkRequest)
        {
            String[] temp = wr.getMessage().split(",");
            String message = "0,"+(Integer.valueOf(temp[0])-1)+","+temp[2]+","+wr.getSender().toString();
            WorkRequest newwr = new WorkRequest(message);
            Result.add(newwr);
        }
        return Result;
    }
}
