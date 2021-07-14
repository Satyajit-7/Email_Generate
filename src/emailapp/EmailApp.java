/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class EmailApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Enter Your Firstname: ");
        Scanner in = new Scanner(System.in);
        String firstname=in.nextLine();
        
        System.out.print("Enter Your Lastname: ");
        Scanner inn = new Scanner(System.in);
        String lastname=in.nextLine();
        
       
        Email em1=new Email(firstname,lastname);
        
        System.out.print("Reset Password: ");
        Scanner lnn = new Scanner(System.in);
        String newpwd=in.nextLine();
        em1.changePassword(newpwd);
        System.out.println("Password changed successfully");
        
        System.out.print("Enter Your Alternate Email: ");
        Scanner ln = new Scanner(System.in);
        String altEmail=in.nextLine();
        em1.setAlternateEmail(altEmail);
        System.out.println("\nYOUR INFO.\n" + em1.showInfo() + "\n");
        em1.getConnection();
    }
    
}
