/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptionproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author kibarua muthoni
 */
public class ClientgGraphicalUserInterface {
    JFrame clientFrame = new JFrame("Client Details");
    JPanel clientPanel = new JPanel();
    
    JLabel fnameLabel = new JLabel("FirstName: ");
    JLabel lnameLabel = new JLabel("LastName: ");
    JLabel pnumberLabel = new JLabel("PhoneNumber: ");
    JLabel dobLabel = new JLabel("DateOfBirth: ");
    JLabel genderLabel = new JLabel("Gender: ");
    
    JTextField fname = new JTextField();
    JTextField lname = new JTextField();
    JTextField pnumber = new JTextField();
    JTextField dob = new JTextField();

    JCheckBox gMale = new JCheckBox();
    JCheckBox gFemale = new JCheckBox();
    
    ButtonGroup group = new ButtonGroup();
    
    JButton addClient = new JButton("Add Client");
    JButton dashboardBtn = new JButton("Dashboard");
            
    String gender;
    int age;
    
    DatabaseConnector rt = new DatabaseConnector();
     public void ClientGUI(){
       clientPanel.setLayout(null);
        
        clientPanel.add(fnameLabel);
        clientPanel.add(fname);
        
        clientPanel.add(lnameLabel);
        clientPanel.add(lname);
        
        clientPanel.add(pnumberLabel);
        clientPanel.add(pnumber);
        
        clientPanel.add(dobLabel);
        clientPanel.add(dob);
        
        clientPanel.add(genderLabel);
        clientPanel.add(gMale);
        clientPanel.add(gFemale);
        
        fnameLabel.setBounds(10, 70, 80, 20);
        fname.setBounds(100, 70, 130,20);
        
        lnameLabel.setBounds(10,100,80,20);
        lname.setBounds(100,160,130,20);
        
        pnumberLabel.setBounds(10,130,80,20);
        pnumber.setBounds(100, 190, 130, 20);
        
        dobLabel.setBounds(10,160,100,20);
        dob.setBounds(100, 210, 130,20);
        
        genderLabel.setBounds(10,190,80,20);
        gMale.setBounds(100, 240, 130,20);
        gFemale.setBounds(100,270,130,20);
        
        group.add(gMale);
        group.add(gFemale);
        
        //Button Action Listeners
        addClient.addActionListener((java.awt.event.ActionEvent evt)-> {
            addActionPerformed(evt);
        });
        
        clientFrame.add(clientPanel);
        clientFrame.setSize(700, 900);
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.pack();
        clientFrame.setVisible(true);
    }
    public void addActionPerformed(java.awt.event.ActionEvent evt){
        Connection c =rt.DatabaseConnector();
        String sql = "insert into clientdetails(firstname,lastname,phonenumber,dob,gender,age) values('" + fname.getText() + "','" + lname.getText() + "','" + pnumber.getText()+"','" + dob.getText() + "','" + gender +"','" + age + "')";
        try {
            PreparedStatement st = c.prepareStatement(sql);
            st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public static void main(String[] args) {
   
    }
    
}

    

