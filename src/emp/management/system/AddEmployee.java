package emp.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran=new Random();
    int number=ran.nextInt(999999);
    JTextField tname,tfname,taddress,tsal,tphone,temail,tdesignation,tadhaar;
    JDateChooser dcdob;
    JComboBox cedu;
    JLabel generateid;
    JButton add,back;
    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //HEADING
        
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("Serif",Font.BOLD,25));
        add(heading);
        
        //NAME
        
        JLabel name=new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("Serif",Font.BOLD,20));
        add(name);
        
        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        add(tname);     
        
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
       
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
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
        
        String courses[]={"BE/BTECH","BSC","BCA","BBA","BA","B.COM","ME/MTECH","MSC","MCA","MBA","MA","MCOM","Phd"};
        cedu=new JComboBox(courses);
        cedu.setBackground(Color.WHITE);
        cedu.setBounds(600,300,150,30);
        add(cedu);
        
        
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
        
        tadhaar=new JTextField();
        tadhaar.setBounds(600,350,150,30);
        add(tadhaar);
        
        //EMPLOYEE ID
        
        JLabel id=new JLabel("Employee ID");
        id.setBounds(50, 400, 150, 30);
        id.setFont(new Font("Serif",Font.BOLD,20));
        add(id);
        
        generateid=new JLabel(""+number);
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
       
        add=new JButton("Add Details");
        add.setBounds(470,600,140,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/add.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address= taddress.getText();
            String sal=tsal.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education= (String)cedu.getSelectedItem();
            String designation=tdesignation.getText();
            String adhaar=tadhaar.getText();
            String id=generateid.getText();
            
            try{
                Conn conn=new Conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+address+"','"+sal+"','"+phone+"',"
                        + "'"+email+"','"+education+"','"+designation+"','"+adhaar+"','"+id+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully");
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
        new AddEmployee();
    }
}
