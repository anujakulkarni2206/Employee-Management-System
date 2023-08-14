package emp.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete,back;
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempId=new JLabel("Employee ID");
        labelempId.setBounds(50,40,100,30);
        add(labelempId);
        
        cEmpId=new Choice();
        cEmpId.setBounds(190,40,140,30);
        add(cEmpId);
        
        try{
            Conn c=new Conn();
            String query="Select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
               cEmpId.add(rs.getString("empId"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //Name
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,90,100,30);
        add(labelname);

        JLabel lblname=new JLabel();
        lblname.setBounds(190,90,100,30);
        add(lblname);
        
        //Phone
        
        JLabel labelPhone=new JLabel("Phone");
        labelPhone.setBounds(50,140,100,30);
        add(labelPhone);

        JLabel lblPhone=new JLabel();
        lblPhone.setBounds(190,140,100,30);
        add(lblPhone);

        //Email
        
        JLabel labelEmail=new JLabel("Email");
        labelEmail.setBounds(50,190,100,30);
        add(labelEmail);

        JLabel lblEmail=new JLabel();
        lblEmail.setBounds(190,190,100,30);
        add(lblEmail);

   
        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c=new Conn();
                    String query= "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next()){
                       lblname.setText(rs.getString("name"));
                       lblPhone.setText(rs.getString("phone"));
                       lblEmail.setText(rs.getString("email"));
                    }

                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        back=new JButton("Back");  
        back.setBounds(80,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        delete=new JButton("Delete");  
        delete.setBounds(220,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
        
        setSize(1000,500);
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==delete){
            
             try{
                    Conn c=new Conn();
                    String query= "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Employee Information Deleted Sucessfully");
                    setVisible(false);
                    new Home();
                }
             catch(Exception e){
                    e.printStackTrace();
                }
        }
        
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new RemoveEmployee();
    }
}
