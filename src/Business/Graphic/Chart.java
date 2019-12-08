/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Graphic;

import java.util.Map;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.AbstractDataset;

/**
 *
 * @author sdzh4
 */
public interface Chart {
    public AbstractDataset getDataSet(Map<Integer,Double> id2num,Map<Integer,String> id2name);
    public  JFreeChart PaintChart(String title,String xtitle,String ytitle,Map<Integer,Double> id2num,Map<Integer,String> id2name);
}
