import java.sql.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class StudentUpdate extends JFrame implements ActionListener {
    
 Container c;
 FirstPage fp;
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
 StudentUpdate(FirstPage f)
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
            b1=new JButton("UPDATE");
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
		setSize(800 ,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
   
    }
 
 StudentUpdate(StudentRegister s)
         
 {
     c=getContentPane();
   lname=new JLabel("Name:");
   tname=new JTextField();
   String n=s.tname.getText();
   tname.setText(n);
   lname.setBounds(50, 50, 100, 25);
   tname.setBounds(150, 50, 100, 25);
   
   c.add(lname);
   c.add(tname);
   setSize(800,800);
   setLayout(null);
   setVisible(true);
   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
 } 

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String sub="";
        if(e.getActionCommand().equals("UPDATE"))
        {
            try
        {
           // Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_project","root","Kithani2001@@");    
            String query ="update Studenttable set fname=?,lname=?,address=?,passwordd=?,subjectt=?,gender=?,branch=? where fname=?";
            PreparedStatement st =con.prepareStatement(query);
            st.setString(1, tname.getText());
            st.setString(2, tsurname.getText());
            st.setString(3, taddress.getText());
            st.setString(4, new String(tpass.getPassword()));
            if(m.isSelected())
                sub="m";
            if(j.isSelected())
                sub=sub+"j";
            if(d.isSelected())
                sub=sub+"d";
             if(cg.isSelected())
                sub=sub+"cg";
           
            st.setString(5, sub);
            if(male.isSelected())
                st.setString(6, "M");
            else if(female.isSelected())
                st.setString(6, "F");
            else if (others.isSelected())
                st.setString(6, "O");
            st.setString(7, cbranch.getSelectedItem().toString());
            st.setString(8, tname.getText());
            
            st.execute();
            con.close();
            
            
        }
        catch (Exception se)
        {
            System.out.println(se);
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
			  cg.setSelected(false);
              
              
              cbranch.setSelectedIndex(0);
        
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            this.setVisible(false);
            fp.setVisible(true);
        }

    }
}