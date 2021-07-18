import java.awt.*;
import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
import javax.swing.*;
import java.sql.*;
public class StudentDisplay extends JFrame implements ActionListener {
    
 FirstPage fp;
 Container c;
 JLabel lname,lsurname,laddress,lpass,lsubjects,lgender,lbranch;
 JTextField tname,tsurname;
 JTextArea taddress;
 JPasswordField tpass;
 JCheckBox m,j,d,cg;
 JRadioButton male,female,others;
 ButtonGroup bg;
 JComboBox cbranch;
 JButton b1,b2,b3;
 String b[]={"","CMPN","IT","EXTC","INSTRU","BIOMED","ETRX"};
 StudentDisplay(FirstPage f)
 {
            fp=f;
            c=getContentPane();
		lname=new JLabel("Name:");
		lsurname=new JLabel("Last Name:");
		laddress=new JLabel("Address:");
		lpass=new JLabel("Password");
            lsubjects=new JLabel("Subjects:");
            lgender=new JLabel("Gender");
            lbranch=new JLabel("Branch");
            m=new JCheckBox("Maths");
            j=new JCheckBox("JAVA");
            d=new JCheckBox("DS");
			cg=new JCheckBox("CG");
            male=new JRadioButton("Male");
            female=new JRadioButton("Female");
            others=new JRadioButton("Others");
            b1=new JButton("SEARCH");
            b2=new JButton("RESET");
            b3=new JButton("BACK");
            
            bg=new ButtonGroup();
            bg.add(male);
            bg.add(female);
            bg.add(others);
		tname=new JTextField();
		tsurname=new JTextField();
		taddress=new JTextArea();
		tpass=new JPasswordField();
            cbranch=new JComboBox(b);
		lname.setBounds(50,50,100,25);
		tname.setBounds(200,50,100,25);
		lsurname.setBounds(50,100,100,25);
		tsurname.setBounds(200,100,100,25);
		laddress.setBounds(50,150,100,25);
		taddress.setBounds(200,150,100,150);
		lpass.setBounds(50,350,100,25);
		tpass.setBounds(200,350,100,25);
		lsubjects.setBounds(50, 400, 100, 25);
            m.setBounds(200, 400, 100, 25);
            j.setBounds(200, 430, 100, 25);
            d.setBounds(200, 460, 100, 25);
			cg.setBounds(200, 490, 100, 25);
            lgender.setBounds(50,510,100,25);
            male.setBounds(200, 510, 100, 25);
            female.setBounds(310, 510, 100, 25);
            others.setBounds(420, 510, 100, 25);
            lbranch.setBounds(50, 560  , 100, 25);
            cbranch.setBounds(200, 560, 100, 25);
            b1.setBounds(150, 610, 100, 25);
            b2.setBounds(300, 610, 100, 25);
            b3.setBounds(450, 610, 100, 25);
		setLayout(null);
		c.add(lname);
		c.add(tname);
		c.add(lsurname);
		c.add(tsurname);
		c.add(laddress);
		c.add(taddress);
		c.add(lpass);
		c.add(tpass);
            c.add(lsubjects);
            c.add(m);
            c.add(j);
            c.add(d);
			c.add(cg);
            c.add(lgender);
            c.add(male);
            c.add(female);
            c.add(others);
            c.add(lbranch);
            c.add(cbranch);
            c.add(b1);
            c.add(b2);
            c.add(b3);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            tsurname.setEditable(false);
            taddress.setEditable(false);
            tpass.setEditable(false);
            m.setEnabled(false);
            j.setEnabled(false);
            d.setEnabled(false);
			 cg.setEnabled(false);
            male.setEnabled(false);
            female.setEnabled(false);
            others.setEnabled(false);
            cbranch.setEditable(false);
            
		setSize(800 ,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
   
 }
 
 StudentDisplay(StudentRegister s)
         
 {
     c=getContentPane();
   lname=new JLabel("Name:");
   tname=new JTextField();
   String n=s.tname.getText();
   tname.setText(n);
   lname.setBounds(50, 50, 100, 25);
   tname.setBounds(150, 50, 100, 25);
   
   
   
 } 

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("SEARCH"))
        {
            
            try{  
               // Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//this statement loads the driver for the databse
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_project","root","Kithani2001@@");  
                //here nitesh is database name, root is username and  password is empty String  
                Statement stmt=con.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from studenttable where fname='"+tname.getText()+"'");  
                
                if(rs.next()==false) 
                {
                    tname.setText("");
				  tsurname.setText("");
				  taddress.setText("");
				  tpass.setText("");
				  m.setSelected(false);
				  d.setSelected(false);
				  j.setSelected(false);
				   j.setSelected(false);
              
					cbranch.setSelectedIndex(0);
        
                    JOptionPane.showMessageDialog(this, "Record not Found");
                }
                else
                               
                {
                    tsurname.setText(rs.getString(2));
                    taddress.setText(rs.getString(3));
                    tpass.setText(rs.getString(4));
                    String sub= rs.getString(5);
                    switch(sub)
                    {
                        case "" :  m.setSelected(false);
                                 j.setSelected(false);
                                 d.setSelected(false); 
									cg.setSelected(false); 
                                 break;
                        case "m":  m.setSelected(true);
                                 j.setSelected(false);
                                 d.setSelected(false); 
								cg.setSelected(false); 								 
                                 break;
                        case "j":  m.setSelected(false);
                                 j.setSelected(true);
                                 d.setSelected(false); 
								cg.setSelected(false); 								 
                                 break;
                        case "d":  m.setSelected(false);
                                 j.setSelected(false);
                                 d.setSelected(true);  
									cg.setSelected(false); 								 
                                 break;
						 case "cg":  m.setSelected(false);
                                 j.setSelected(false);
                                 d.setSelected(false);   
								 cg.setSelected(true);   
                                 break;
                       
                        case "mj": m.setSelected(true);
                                 j.setSelected(true);
                                 d.setSelected(false); 
									cg.setSelected(false); 
                                 break;
                        case "md": m.setSelected(true);
                                 j.setSelected(false);
                                 d.setSelected(true);
								cg.setSelected(false); 								 
                                 break;
						case "mcg": m.setSelected(true);
                                 j.setSelected(false);
                                 d.setSelected(false);
								cg.setSelected(true); 								 
                                 break;
                        
                        case "jd": m.setSelected(false);
                                 j.setSelected(true);
                                 d.setSelected(true);  
								cg.setSelected(false);								 
                                 break;
						 case "jcg": m.setSelected(false);
                                 j.setSelected(true);
                                 d.setSelected(false);  
								cg.setSelected(true);								 
                                 break;
						 case "dcg": m.setSelected(false);
                                 j.setSelected(false);
                                 d.setSelected(true);  
								cg.setSelected(true);								 
                                 break;
                       
                       
                        case "mjd": m.setSelected(true);
                                 j.setSelected(true);
                                 d.setSelected(true);  
								cg.setSelected(false); 								 
                                 break;
						 case "mjcg": m.setSelected(true);
                                 j.setSelected(true);
                                 d.setSelected(false);    
								 cg.setSelected(true); 
                                 break;
						case "jdcg": m.setSelected(false);
                                 j.setSelected(true);
                                 d.setSelected(true);    
								 cg.setSelected(true); 
                                 break;
						 case "mjdcg": m.setSelected(true);
                                 j.setSelected(true);
                                 d.setSelected(true);    
								 cg.setSelected(true); 
                                 break;
 
                    }
                    if(rs.getString(6).equals("M"))
                        male.setSelected(true);
                    else if(rs.getString(6).equals("F"))
                        female.setSelected(true);
                    else if(rs.getString(6).equals("O"))
                        others.setSelected(true);
                    cbranch.setSelectedItem(rs.getString(7));
                    
                    
                 }
                    
                
                con.close();  
                }catch(Exception ex)
                { 
                    System.out.println(ex);
                }  
        }  
        
        
        else if(e.getActionCommand().equals("RESET"))
        {
              tname.setText("");
              tsurname.setText("");
              taddress.setText("");
              tpass.setText("");
              m.setSelected(false);
              d.setSelected(false);
              j.setSelected(false);
              
              
              cbranch.setSelectedIndex(0);
        
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            this.setVisible(false);
            fp.setVisible(true);
        }

    }
}