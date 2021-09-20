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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Book
{
    int bookId;
    String title;
    String author;
    float price;
    boolean isRented;
    int rentedTo;
    LocalDate returnDate;
    
    static float finePerDay = 10.0f;
    
    public void getData()
    {
        Scanner scan = new Scanner(System.in);
        String buffer;
        
        System.out.print("Enter Book Id : ");
        bookId = scan.nextInt();
        
        buffer = scan.nextLine();
        
        System.out.print("Enter Book Title : ");
        title = scan.nextLine();
        
        System.out.print("Enter Author : ");
        author = scan.nextLine();
        
        System.out.print("Enter Price : ");
        price = scan.nextFloat();
    }
    
    public void issue(int memberId)
    {
        if(!isRented)
        {
            isRented = true;
            rentedTo = memberId;
            returnDate = LocalDate.now().plusDays(7);
            System.out.println("Book with title " + title + " successfully issued to member with id : " + memberId + " !");
        }
        else
        {
            System.out.println("Book already rented to member with id : " + rentedTo + " !");
        }
    }
    
    public void display()
    {
        System.out.println("Book Id : " + bookId);
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price + " Rupees");
        if(isRented)
        {
            System.out.println("Is Rented : Yes");
            System.out.println("Rented To : " + rentedTo);
        }
        else
        {
            System.out.println("Is Rented : No");
        }
    }
    
    public void returned(Member m)
    {
        if(isRented)
        {
            isRented = false;
            LocalDate todayDate = LocalDate.now();
            if(returnDate.compareTo(todayDate) < 0)
            {
                long numberOfDays = ChronoUnit.DAYS.between(returnDate, todayDate);
                m.incrementFine(numberOfDays * finePerDay);
                System.out.println("Book is returned " + numberOfDays + " days late.");
                System.out.println("Member now has a pending fine of Rupees " + m.getPendingFine() );
            }
            System.out.println("Book list updated!");
        }
        else
        {
            System.out.println("Book was never rented or is already returned!");
        }       
    }
    
    public int getBookId()
    {
        return bookId;
    }
    
    
//    public static void main(String[] args)
//    {
//        LocalDate todayDate = LocalDate.now();
//        LocalDate d = LocalDate.now();
//            if(d.compareTo(todayDate) <= 0)
//            {
//                long numberOfDays = ChronoUnit.DAYS.between(d, todayDate);
//               System.out.println(numberOfDays);
//            }   
//    }

   
}
