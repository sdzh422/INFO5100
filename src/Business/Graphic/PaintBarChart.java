/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Graphic;

import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.AbstractDataset;

/**
 *
 * @author sdzh4
 */
public  class  PaintBarChart implements Chart{

    @Override
    public AbstractDataset getDataSet(Map<Integer, Double> id2num, Map<Integer, String> id2name) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        for(int i=0;i<id2num.size();i++)
         {
             dataset.addValue(id2num.get(i), "1",id2name.get(i) );
         }
         return dataset;
    }

    @Override
    public  JFreeChart PaintChart(String title, String xtitle,String ytitle,Map<Integer, Double> id2num, Map<Integer, String> id2name) {
       CategoryDataset  dataset = (CategoryDataset)getDataSet(id2num,id2name); 
       JFreeChart chart = ChartFactory.createBarChart3D(
                           title, 
                           xtitle, //X-title
                           ytitle, //y-TITLE
                            dataset, 
                            PlotOrientation.VERTICAL, 
                            true,  
                            false, 
                            false 
                            ); 
       return chart;
    }
    
}
