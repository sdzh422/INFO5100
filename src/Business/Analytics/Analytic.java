/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Analytics;

import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author sdzh4
 */
public interface Analytic {

    public Map<Integer,Double> toMap(ArrayList<WorkRequest> history);
    public Map<Integer, Double> toMap_performence(ArrayList<WorkRequest> history);
    
}
