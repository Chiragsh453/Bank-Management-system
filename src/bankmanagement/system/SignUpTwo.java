package bankmanagement.system;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    
  
    JTextField pan,aadhar;
     JButton next;
     JRadioButton syes,sno,eyes,eno;
   String formno;
     JComboBox religion,category,occupation,Education,Income;
    SignUpTwo(String formno) 
    {
        this.formno=formno;
        setLayout(null);
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2:");
        
        JLabel additionalDetails =new JLabel("Page 2: Additonal Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,38));
        additionalDetails.setBounds(140,20,600,40);
        add(additionalDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
      name.setBounds(100,140,100,30);
        add(name);
       
        String valReligion[]={"Hindu","Muslim","SIkh","Christian","Other"};
         religion =new JComboBox(valReligion);//dropdown
         religion.setBounds(300,140,400,30);
         religion.setBackground(Color.WHITE);
         add(religion);
      
        
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[] ={"General","OBC","SC","ST","Other"};
         category =new JComboBox(valcategory);
         category.setBounds(300,190,400,30);
         category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
      dob.setBounds(100,240,200,30);
        add(dob);
        
         String Incomecategory[] ={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 1,00,000"};
         Income =new JComboBox(Incomecategory);
         Income.setBounds(300,240,400,30);
         Income.setBackground(Color.WHITE);
        add(Income);
        
        
        
        
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
      gender.setBounds(100,290,200,30);
        add(gender);
        
    
        
        JLabel email=new JLabel("Qualifiaction:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
      email.setBounds(100,315,200,30);
        add(email);
        
           String educationval[] ={"Non graduation","Graduate","Post Graduation","12th pass","Other"};
         Education =new JComboBox(educationval);
         Education.setBounds(300,315,400,30);
         Education.setBackground(Color.WHITE);
        add(Education);
        
        
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
      marital.setBounds(100,390,200,30);
        add(marital);
        
             String Occupationval[] ={"Salaried","Self employed","Bussiness","Student","Other"};
            occupation =new JComboBox(Occupationval);
            occupation.setBounds(300,390,400,30);
              occupation.setBackground(Color.WHITE);
         add(occupation);
        
        JLabel address=new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
      address.setBounds(100,440,200,30);
        add(address);
        
       pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
      city.setBounds(100,490,200,30);
        add(city);
      
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state=new JLabel("Senior Ctizen:");
     state.setFont(new Font("Raleway",Font.BOLD,20));
      state.setBounds(100,540,200,30);
        add(state);
        
       syes =new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
          sno =new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
     
        
        ButtonGroup maritalGroup =new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);
        
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
      pincode.setBounds(100,590,200,30);
        add(pincode);
              
        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
          eno =new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
     
        
        ButtonGroup emaritalGroup =new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,730);
        setLocation(200,10);
       setVisible(true);
    }
     
     public void actionPerformed(ActionEvent ae)
     {
         
         String sreligion= (String)religion.getSelectedItem();
         String scategory=(String)category.getSelectedItem();
         String sincome= (String) Income.getSelectedItem();
         String seducation =(String) Education.getSelectedItem();
         String soccupation =(String) occupation.getSelectedItem();
      
         String seniorcitizen = null;
         if(syes.isSelected()){
         seniorcitizen="Yes";
         }
         else if(sno.isSelected()){
             seniorcitizen="No";
         
         }
      
         String existingaccount=null;
         if(eyes.isSelected()){
         existingaccount="Yes";
         }
         else if(eno.isSelected()){
         existingaccount="No";
         }
        
         String span=pan.getText();
         String saadhar=aadhar.getText();
         
           try{
           
          
           Conn c=new Conn();
         String query = "insert into signuptwo values('"+formno+"','"+sreligion+"',"
                 + "'"+scategory+"','"+sincome+"','"+seducation+"',"
                 + "'"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
           c.s.executeUpdate(query);
           
           //signupthree
           setVisible(false);
           new SignupThree(formno).setVisible(true);
           
           }
           catch(Exception e)
           {
           System.out.println(e);
           }
     }
    
    public static void main(String args[]) {
        new SignUpTwo("");

    }
}
