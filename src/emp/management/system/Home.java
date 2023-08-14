package emp.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    
   JButton add,view,update,remove;
    
   Home(){
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i2=i1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,1100,600);
       add(image);
       
       
       JLabel heading =new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
       heading.setBounds(650,20,400,40);
       heading.setFont(new Font("Serif",Font.BOLD,25));
       image.add(heading);
       
       add=new JButton("Add Employee");
       add.setBounds(650,70,140,40);
       add.addActionListener(this);
       image.add(add);
       
       view=new JButton("View Employees");
       view.setBounds(810,70,140,40);
       view.addActionListener(this);
       image.add(view);
       
       update=new JButton("Update Employee");
       update.setBounds(650,130,140,40);
       update.addActionListener(this);
       image.add(update);
       
       remove=new JButton("Remove Employee");
       remove.setBounds(810,130,140,40);
       remove.addActionListener(this);
       image.add(remove);
       
       setSize(1100,600);
       setLocation(250,100);
       setVisible(true);
       
   }
   
   public void actionPerformed(ActionEvent ae){
       
       if(ae.getSource() == add){
           setVisible(false);
           new AddEmployee();
       } 
       else if(ae.getSource()== view){
           setVisible(false);
           new ViewEmployees();
       }
       else if(ae.getSource()== update){
           new ViewEmployees();
       }
       else {
           setVisible(false);
           new RemoveEmployee();
       }
   }
   
   
   public static void main(String args[]){
     new Home();
   }
    
}
