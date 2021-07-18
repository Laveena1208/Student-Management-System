import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 91963
 */
public class FirstPage extends JFrame implements ActionListener 
{

    JButton bRegister,bDisplay,bUpdate;
    Container ca;
    JLabel c;
    FirstPage()
    {
        ca=getContentPane();
        c=new JLabel(new ImageIcon("E:\\JAVA PROGRAMS\\Final new java prj\\FirstPage IMAGE.JPG"));
        c.setBounds(0, 0, 800, 800);
        ca.add(c);
        bRegister=new JButton("Register");
        bDisplay=new JButton("Display");
        bUpdate= new JButton("Update");
        this.setLayout(null);
        this.setSize(800, 800);
        bRegister.setBounds(200, 200, 100, 25);
        bDisplay.setBounds(400, 200, 100, 25);
        bUpdate.setBounds(600, 200, 100, 25);
        
        c.add(bRegister);
        c.add(bDisplay);
        c.add(bUpdate);
        
        bRegister.addActionListener(this);
        bDisplay.addActionListener(this);
        bUpdate.addActionListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Register"))
        {
            this.setVisible(false);
            StudentRegister sr = new StudentRegister(this);
        }
        else if(e.getActionCommand().equals("Display"))
        {
            this.setVisible(false);
            StudentDisplay sv = new StudentDisplay(this);
        }
        else if(e.getActionCommand().equals("Update"))
        {
            this.setVisible(false);
            StudentUpdate su = new StudentUpdate(this);
        }
        
    }
    public static void main(String args[])
    {
        FirstPage f=new FirstPage();
    }
}
    
