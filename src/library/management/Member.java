/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

/**
 *
 * @author Nitin
 */

import java.util.Scanner;

public class Member
{
    int memberId;
    String name;
    int mobileNumber;
    String address;
    float pendingFine;
  
    public void getData()
    {
        Scanner scan = new Scanner(System.in);
        String buffer;
        
        System.out.print("Enter Member Id : ");
        memberId = scan.nextInt();
        
        buffer = scan.nextLine();
        
        System.out.print("Enter Name : ");
        name = scan.nextLine();
        
        System.out.print("Enter Address : ");
        address= scan.nextLine();
        
        System.out.print("Enter Mobile Number : ");
        mobileNumber = scan.nextInt();
    }
    
    public void display()
    {
        System.out.println("Member Id : " + memberId);
        System.out.println("Name : " + name);
        System.out.println("Address : " + address);
        System.out.println("Mobile Number : " + mobileNumber);
        System.out.println("Pending Fine : " + pendingFine + " Rupees");
    }
    
    public int getMemberId()
    {
        return memberId;
    }
    
    public void incrementFine(float add)
    {
        pendingFine += add;
    }
    
    public void payFine(float paidAmount)
    {
        System.out.println("");
        if(paidAmount < 0)
        {
            System.out.println("Enter positive Amount!");
        }
        else if(paidAmount > pendingFine)
        {
            System.out.println("Entered Amount is greater than Pending Fine!");
        }
        else
        {
            pendingFine -= paidAmount;
            System.out.println("Record Updated!");
            System.out.println("Pending Fine Now : " + pendingFine);
        }
    }    

    public float getPendingFine()
    {
        return pendingFine;
    }
}
