package emp.management.system;
import javax.swing.*;
import java.awt.*;//For Color and Image Class
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener{
    
   Splash(){
      
      getContentPane().setBackground(Color.PINK);
      setLayout(null);
      
      JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
      heading.setBounds(100,30,1200,60);
      heading.setFont(new Font("Serif",Font.PLAIN,40));
      heading.setForeground(Color.black);
      add(heading);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
      Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(20,100,1050,500);
      add(image);
      
      JButton click=new JButton("Click Here To Continue");
      click.setBounds(400,400,300,70);
      click.setBackground(Color.white);
      click.setForeground(Color.black);
      click.addActionListener(this);
      image.add(click);
      
      setSize(1000,600);
      setLocation(200,100);
      setVisible(true);
      
      while(true){
          heading.setVisible(false);
          try{
              Thread.sleep(500);
          }
          catch(Exception e){
      }
          
          heading.setVisible(true);
          try{
              Thread.sleep(500);
          }
          catch(Exception e){
              
          }
   }
   }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
   
    public static void main(String args[]){
        new Splash();
    }
}
