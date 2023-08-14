package emp.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
     JTextField tuname, tPass;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel username=new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);
        
        tuname=new JTextField();
        tuname.setBounds(160, 20, 100, 30);
        add(tuname);
        
        JLabel password=new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);
        
        tPass=new JTextField();
        tPass.setBounds(160,70 , 100, 30);
        add(tPass);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(100,135,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 =i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
         
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username= tuname.getText();
            String password= tPass.getText();
            Conn c= new Conn();
            String query="select * from login where username= '"+username+"' and password= '"+password+"'";
            
            ResultSet rs= c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Username of Password");
                setVisible(false);
            }
        }
        catch(Exception e){
           e.printStackTrace();        
        }
        
    }
    public static void main(String args[]){
        new Login();
    }
}
