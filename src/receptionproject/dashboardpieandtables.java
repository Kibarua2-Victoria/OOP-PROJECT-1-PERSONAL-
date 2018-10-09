/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptionproject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author kibarua muthoni
 */
public class dashboardpieandtables {
     DatabaseConnector db = new DatabaseConnector();
    ResultSet rs = db.getData();
    
    //Objects
    JTable table = new javax.swing.JTable();
    
    JPanel myPanel = new javax.swing.JPanel();
    JScrollPane tablePanel = new javax.swing.JScrollPane();
    JFrame dashboardFrame = new JFrame();
    
    int males, females;
    // Dashboard to display JTable & Charts(Bar & Pie - JFreeChart)
    public dashboardpieandtables(){
        dashboardFrame.setLayout(null);
        //JTable
        table.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        
         tablePanel.setViewportView(table);
         tablePanel.setBounds(50, 70, 650, 50);  
     
         table.setModel(getTable());
         
         //PieChart
         PieDataset dataset = createDataset();
         JFreeChart chart = plotChart(dataset);
         ChartPanel chartPanel = new ChartPanel(chart);
         chartPanel.setPreferredSize(new java.awt.Dimension(500, 300));
         chartPanel.setVisible(true);
         chartPanel.setBounds(100, 170, 700, 500);
         dashboardFrame.add(chartPanel);
         dashboardFrame.add(tablePanel);
         
         dashboardFrame.setSize(1000, 600);
         dashboardFrame.setVisible(true);
         dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
    }
    
    private DefaultTableModel getTable() {
        try {
            //ADD COLUMNS TO TABLE MODEL
            DefaultTableModel t = new DefaultTableModel();
            t.addColumn("ID");
            t.addColumn("FirstName");
            t.addColumn("LastName");
            t.addColumn("PhoneNumber");
            t.addColumn("DateOfBirth");
            t.addColumn("Gender");
            t.addColumn("Age");
            
            while (rs.next()) {
                String id = rs.getString(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String pnumber = rs.getString(4);
                String birthdate = rs.getString(5);
                String gender = rs.getString(6);
                String age = rs.getString(7);

                t.addRow(new String[]{id, fname, lname, pnumber, birthdate, gender, age});
            }
            return t;
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private PieDataset createDataset(){
        try {
            DefaultPieDataset result = new DefaultPieDataset();
            ResultSet r = rs;
            //Male and Female Counter
            while(r.next()){   
                // Gender is on the 6th Row
                String gendersex = r.getString(6);
                if("Female".equals(gendersex))
                    females = females + 1;
                if("Male".equals(gendersex))
                    males = males + 1;
            }
            result.setValue("Male", males);
            result.setValue("Female", females);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } return null;
    }
    
       private JFreeChart plotChart(PieDataset dataset1){
        JFreeChart chart = ChartFactory.createPieChart3D("Gender Statistics", dataset1, true, true,false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.3f);
        return chart;
}
}

    

