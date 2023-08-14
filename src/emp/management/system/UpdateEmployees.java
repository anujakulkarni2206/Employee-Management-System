package emp.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateEmployees extends JFrame implements ActionListener{
    
    JTextField tfname,taddress,tsal,tphone,temail,tedu,tdesignation,tadhaar;
    JLabel generateid;
    JButton update,back;
    String empId;
    
    UpdateEmployees(String empId){
        
        this.empId=empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //HEADING
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("Serif",Font.BOLD,25));
        add(heading);
        
        //NAME
        
        JLabel name=new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("Serif",Font.BOLD,20));
        add(name);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);     
        
        //FATHER'S NAME
        
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(430, 150, 150, 30);
        fname.setFont(new Font("Serif",Font.BOLD,20));
        add(fname);
        
        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);    
     
        //DATE OF BIRTH
        
        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("Serif",Font.BOLD,20));
        add(dob);
       
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        //ADDRESS
        
        JLabel address=new JLabel("Address");
        address.setBounds(430, 200, 150, 30);
        address.setFont(new Font("Serif",Font.BOLD,20));
        add(address);
        
        taddress=new JTextField();
        taddress.setBounds(600,200,150,30);
        add(taddress);     
        
        //SALARY
        
        JLabel sal=new JLabel("Salary");
        sal.setBounds(50, 250, 150, 30);
        sal.setFont(new Font("Serif",Font.BOLD,20));
        add(sal);
        
        tsal=new JTextField();
        tsal.setBounds(200,250,150,30);
        add(tsal);     
        
        //PHONE
         
        JLabel phone=new JLabel("Phone");
        phone.setBounds(430, 250, 150, 30);
        phone.setFont(new Font("Serif",Font.BOLD,20));
        add(phone);
        
        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);
        
        //EMAIL
        
        JLabel email=new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("Serif",Font.BOLD,20));
        add(email);
        
        temail=new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);
        
        //HIGHER EDUCATION
        
        JLabel edu=new JLabel("Higher Education");
        edu.setBounds(430, 300, 150, 30);
        edu.setFont(new Font("Serif",Font.BOLD,20));
        add(edu);
        
        tedu=new JTextField();
        tedu.setBounds(600,300,150,30);
        add(tedu);
        
        
        //DESIGNATION
        JLabel designation=new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("Serif",Font.BOLD,20));
        add(designation);
        
        tdesignation=new JTextField();
        tdesignation.setBounds(200,350,150,30);
        add(tdesignation);     
        
        
        //AADHAAR
        
        JLabel adhaar=new JLabel("Aadhaar Number");
        adhaar.setBounds(430, 350, 150, 30);
        adhaar.setFont(new Font("Serif",Font.BOLD,20));
        add(adhaar);
        
        JLabel lbladhaar=new JLabel();
        lbladhaar.setBounds(600,350,150,30);
        add(lbladhaar);
        
        //EMPLOYEE ID
        
        JLabel id=new JLabel("Employee ID");
        id.setBounds(50, 400, 150, 30);
        id.setFont(new Font("Serif",Font.BOLD,20));
        add(id);
        
        generateid=new JLabel();
        generateid.setBounds(200, 400, 150, 30);
        generateid.setFont(new Font("Serif",Font.BOLD,20));
        add(generateid);
        
        //ADD
        
        back=new JButton("Back");
        back.setBounds(280,600,140,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
       
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empID= '"+empId+"' ";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tsal.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                tedu.setText(rs.getString("highest_education"));
                tdesignation.setText(rs.getString("designation"));
                lbladhaar.setText(rs.getString("aaddhar"));
                generateid.setText(rs.getString("empId"));
               
                
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        update=new JButton("Update Details");
        update.setBounds(470,600,140,40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
      
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
          
            String fname=tfname.getText();
            String address= taddress.getText();
            String sal=tsal.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String highest_education= tedu.getText();
            String designation=tdesignation.getText();
           
            
            try{
                Conn conn=new Conn();
                String query="update employee set fname='"+fname+"',address='"+address+"',salary='"+sal+"',phone='"+phone+"',email='"+email+"',highest_education='"+highest_education+"',designation='"+designation+"' where empId='"+this.empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
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
        new UpdateEmployees("");
    }
}
