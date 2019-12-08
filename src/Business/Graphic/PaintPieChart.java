/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Graphic;
import java.util.Map;
import org.jfree.data.*; 
import org.jfree.chart.*; 
import org.jfree.chart.plot.*; 
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author sdzh4
 */

public class PaintPieChart implements Chart{
    
    
    
    
    /**
     * @param sale  -  salemap   <id,num>
     * @param category  name map    <id,name>
     * @return 
     */
     @Override
     public  DefaultPieDataset  getDataSet(Map<Integer,Double> sale,Map<Integer,String> category) {
         DefaultPieDataset dataset = new DefaultPieDataset(); 
         for(Integer t:sale.keySet())
         {

             dataset.setValue(category.get(t), sale.get(t) );
         }
//         for(int i=0;i<sale.size();i++)
//         {
//             dataset.setValue(category.get(i), sale.get(i) );
//         }
         return dataset;
     }
     @Override
     public JFreeChart PaintChart(String title,String xtitle,String ytitle,Map<Integer,Double> sale,Map<Integer,String> category)
     {
         DefaultPieDataset data = getDataSet(sale,category); 
         JFreeChart chart = ChartFactory.createPieChart3D(title,  
        data, 
        true,
        false, 
        false 
        ); 
         return chart;
     }
    
    
}
