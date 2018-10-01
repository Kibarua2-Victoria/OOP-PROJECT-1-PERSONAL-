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
public class ClientGUI {
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
    
    JButton addClient = new JButton("Add Client");
    
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
        
        fnameLabel.setBounds(10, 40, 100, 20);
        fname.setBounds(100, 400, 100,120);
        
        lnameLabel.setBounds(10,40,70,40);
        lname.setBounds(100,400,170,140);
        
        pnumberLabel.setBounds(10,40,70,40);
        pnumber.setBounds(100, 400, 170, 140);
        
        dobLabel.setBounds(10,40,70,40);
        dob.setBounds(100, 400, 170,140);
        
        genderLabel.setBounds(10,40,70,40);
        gMale.setBounds(100, 400, 170,140);
        gFemale.setBounds(100,400,170,140);
        
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
        String sql = "insert into clientdetails(firstname,lastname,pnumber,dob,gender)";
        try {
            PreparedStatement st = c.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
   
    }
}

    

