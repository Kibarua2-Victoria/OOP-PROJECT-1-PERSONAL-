/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receptionproject;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static sun.security.jgss.GSSUtil.login;


/**
 *
 * @author kibarua muthoni
 */
public class ReceptionProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame myframe=new JFrame("My OOP 1");
        JPanel mypanel=new JPanel();
        JPanel panel=new JPanel();
        mypanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JButton mybutton=new JButton();
        mybutton.setText("Click here");
        String labelPrefix="Number of Clicks:";
        JLabel mylabel=new JLabel(labelPrefix + "0");
        JTextField text=new JTextField();
        JLabel namelabel=new JLabel("Your Name: ");
        JLabel passwordLabel=new JLabel("password");
        JTextField name=new JTextField();
        JPasswordField password=new JPasswordField();
        JButton clear =new JButton("Clear");
        name.setColumns(20);
        password.setColumns(20);
        JButton Login=new JButton("Login");
        mypanel.add(namelabel);
        mypanel.add(name);
        mypanel.add(passwordLabel);
        mypanel.add(password);
        mypanel.add(clear);
        mypanel.add(Login);
        mypanel.add(panel);
            panel.add(mybutton);
            panel.add(mylabel);
            myframe.add(mypanel);
        myframe.setSize(700, 900);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.pack();
        myframe.setVisible(true);
        mybutton.addActionListener(new ActionListener(){
            int count=0;
            @Override
            public void actionPerformed(ActionEvent e) {
             //To change value of count
            count=count+1;
            mylabel.setText(labelPrefix + count);
            System.out.println("Button has been clicked");
            }  
        });
                               

