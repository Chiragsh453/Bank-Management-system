package bankmanagement.system;

import javax.swing.*;
 import java.awt.*;//..for image
import java.awt.event.*;//for actionlistener
import java.sql.*;

public class Login extends JFrame implements ActionListener{
 
    JButton login,clear,signup;
    JTextField cardtextfield;
    JPasswordField pintextfield;//so that pin invisible rahe
    //globally define kiya h so that hum inne dusre function
    //me bhi access kr paye
Login() 
{   setTitle("AUTOMATED TELLER MACHINE");
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label =new JLabel(i3);
    label.setBounds(70, 10, 100, 100);
     add(label);
     
     JLabel text =new JLabel("WELCOME TO ATM");
     text.setFont(new Font("Osward",Font.BOLD,38));
     text.setBounds(200, 40, 400, 40);
     add(text);
     
     JLabel cardno =new JLabel("Card no");
     cardno.setFont(new Font("Raleway",Font.BOLD,28));
     cardno.setBounds(120, 150, 150, 40);
     add(cardno);
     
     cardtextfield =new JTextField();
     cardtextfield.setBounds(300, 150, 230, 40);
     cardtextfield.setFont(new Font("Arial",Font.BOLD,14));
     add(cardtextfield);
     
     JLabel pin =new JLabel("PIN");
     pin.setFont(new Font("Raleway",Font.BOLD,28));
     pin.setBounds(120, 220, 400, 40);
     add(pin);
     
     pintextfield =new JPasswordField();
     pintextfield.setBounds(300, 220, 230, 40);
     pintextfield.setFont(new Font("Arial",Font.BOLD,14));
     add(pintextfield);
     
     login =new JButton("SIGN IN");
     login.setBounds(300,300,100,30);
     login.setBackground(Color.BLACK);
     login.setForeground(Color.WHITE);
     login.addActionListener(this);
     add(login);
     
     //action listener batata h ki button pr
     //click hua hain 
     clear =new JButton("CLEAR");
     clear.setBounds(430,300,100,30);
     clear.setBackground(Color.BLACK);
     clear.setForeground(Color.WHITE);
      clear.addActionListener(this);
     add(clear);
     
     signup =new JButton("SIGN UP");
     signup.setBounds(300,350,230,30);
     signup.setBackground(Color.BLACK);
     signup.setForeground(Color.WHITE);
     signup.addActionListener(this);
     add(signup);
      
    getContentPane().setBackground(Color.WHITE);
    
setSize(800,480);//frame ban jayega
setVisible(true);/*frame dikhane ke liye by default false hota h*/
setLocation(350,200);
}
 
  public void actionPerformed(ActionEvent ae)
  {
      if(ae.getSource()==clear){
       cardtextfield.setText("");
       pintextfield.setText("");
      }else if(ae.getSource()==login){
          Conn conn=new Conn();
          String cardnumber=cardtextfield.getText();
          String pinnumber=pintextfield.getText();
          String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
      try{
        ResultSet rs=conn.s.executeQuery(query);
        if(rs.next()){
          setVisible(false);
          new Transaction(pinnumber).setVisible(true);
            }
        else
          {
          JOptionPane.showMessageDialog(null, "Invalid Card number or Pin");
          }
      }catch(Exception e){
          System.out.println(e);
      
      }
          //phele hme user ko create krna padega tb hm login 
          //kr skte h
          //phele hme singup banana hoga 
      }else if(ae.getSource()==signup){
      
           setVisible(false);
           new SignUpOne().setVisible(true);
      }
  
  }//actionlistener ke liye ovveride karna padega
    public static void main(String[] args) {
 new Login();
    }
    
}
