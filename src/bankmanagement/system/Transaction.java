
package bankmanagement.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
 JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
 String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image =new JLabel(i3);
    image.setBounds(0, 0, 900, 800);
     add(image);
     
     JLabel text =new JLabel("Please select your Transaction");
     text.setBounds(215,260,400,35);
     text.setForeground(Color.WHITE);
     text.setFont(new Font("System",Font.BOLD,16));
     image.add(text);
     
     deposit=new JButton("Deposite");
      deposit.setBounds(160,365,150,30);
       deposit.addActionListener(this);
     image.add(deposit);
     
     withdrawl=new JButton("Cash Withdrawl");
      withdrawl.setBounds(360,365,150,30);
       withdrawl.addActionListener(this);
     image.add(withdrawl);
     
     fastcash=new JButton("Fast Cash");
      fastcash.setBounds(160,395,150,30);
      fastcash.addActionListener(this);
     image.add(fastcash);
     
     ministatement=new JButton("Mini Statement");
      ministatement.setBounds(360,395,150,30);
      ministatement.addActionListener(this);
     image.add(ministatement);
     
       pinchange=new JButton("Pin Change");
      pinchange.setBounds(160,425,150,30);
       pinchange.addActionListener(this);
     image.add(pinchange);
     
       balanceenquiry=new JButton("Balance Enquiry");
      balanceenquiry.setBounds(360,425,150,30);
       balanceenquiry.addActionListener(this);
     image.add(balanceenquiry);
     
      exit=new JButton("Exit");
      exit.setBounds(260,457,150,28);
      exit.addActionListener(this);
     image.add(exit);
       
     setSize(900,800);
     setLocation(100,0);
     setUndecorated(true);
     setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==exit){
      System.exit(0);
      }else if(ae.getSource()==deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
      }else if(ae.getSource()==withdrawl){
        setVisible(false);
        new withdrawl(pinnumber).setVisible(true);
      }else if(ae.getSource()==fastcash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
      }else if(ae.getSource()==pinchange){
        setVisible(false);
        new pinChange(pinnumber).setVisible(true);
      }else if(ae.getSource()==balanceenquiry){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
        
      }else if(ae.getSource()==ministatement){
        new MiniStatement(pinnumber).setVisible(true);
        
      }
    }
   
    public static void main(String args[]) {
       new Transaction(""); 
    }
}
