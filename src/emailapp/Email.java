/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity=500;
    private String email;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String company="comapany.com";
    
    public Email(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
       
        this.department=setDepartment();
        
        email=firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + company;
        System.out.println("\nEMAIL CREATED. ");
        System.out.println("Your Email is: " + email);
        
        this.password=randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);
    }
    
    private String setDepartment(){
        System.out.print("\nDEPARTMENT CODES ARE:\n1 For Sales\n2 For Development\n3 For Accounting\n0 For None\nEnter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice==1)
            return "Sales";
        else if(depChoice==2)
            return "Development";
        else if(depChoice==3)
            return "Accounting";
        else
            return "";
    }
    
    private String randomPassword(int length){
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@_-&.#";
        char[] password=new char[length];
        for(int i=0;i<length;i++){
            int rand=(int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity=capacity;
    }
    
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }
    
    public void changePassword(String password){
        this.password=password;
    }
    
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String showInfo(){
        return ("DISPLAY NAME: " + firstName + " " + lastName +
                "\nDEPARTMENT: " + department +
                "\nCOMPANY EMAIL: " + email + 
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb" + 
                "\nALTERNATE EMAIL: " + alternateEmail);
    }
    
    public Connection getConnection(){ 
     try{
             Class.forName("com.mysql.jdbc.Driver");  
             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","Satyajit.215");
             String q="insert into emailgenerate(Firstname,Lastname,Department,DeptMail,Password,AlternateMail) values(?,?,?,?,?,?)";
             PreparedStatement pst=con.prepareStatement(q);
             //pst.setString(1,jTextField1.getText());
             pst.setString(1,firstName);
             pst.setString(2,lastName); 
             pst.setString(3,department);
            
             
             pst.setString(4,email);
             
             pst.setString(5,password);
             pst.setString(6,alternateEmail);
             
             pst.executeUpdate();
             
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
}
