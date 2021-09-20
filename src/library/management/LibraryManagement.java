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

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement
{   
    static ArrayList<Book> bookList = new ArrayList();
    static ArrayList<Member> memberList = new ArrayList();
        
    static Scanner scan = new Scanner(System.in);
    static String buffer;
    
    public static void main(String[] args)
    {
        do
        {
            Extras.clear();
            
            System.out.println("----------------------------Library Management---------------------------");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search a book");
            System.out.println("4. Display all books");
            System.out.println("");
            System.out.println("5. Add a member");
            System.out.println("6. Remove a member");
            System.out.println("7. Search a member");
            System.out.println("8. Display all members");
            System.out.println("");
            System.out.println("9. Issue Book");
            System.out.println("10. Return Book");
            System.out.println("11. Pay Fine");
            System.out.println("");
            System.out.println("12. Exit");
            
            int choice;
            System.out.print("Enter a choice : ");
            choice = scan.nextInt();
            buffer = scan.nextLine();
            
            Extras.clear();
            switch(choice)
            {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    addMember();
                    break;
                case 6:
                    removeMember();
                    break;
                case 7:
                    searchMember();
                    break;
                case 8:
                    displayMembers();
                    break;
                case 9:
                    issueBook();
                    break;
                case 10:
                    returnBook();
                    break;
                case 11:
                    payFine();
                    break;
                case 12:
                    return;
                default:
                    System.out.println("Enter a valid choice!");
                    System.out.print("Press Enter key to go to main menu...");
                    buffer = scan.nextLine();
            }   
        }while(true);
    }
    
    public static int findBookFromId(int id)
    {
        Book b;
        for(int i = 0; i < bookList.size(); i++)
        {
            b = bookList.get(i);
            if(b.getBookId() == id)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static int findMemberFromId(int id)
    {
        Member m;
        for(int i = 0; i < memberList.size(); i++)
        {
            m = memberList.get(i);
            if(m.getMemberId() == id)
            {
                return i;
            }
        }
        return -1;
    }
    
    public static void addBook()
    {
        Book newBook = new Book();
        System.out.println("-----------------Enter details for the new book--------------------");
        newBook.getData();
        if(findBookFromId( newBook.getBookId() ) != -1)
        {
            System.out.println("Book with same id is already present!");
        }
        else
        {
            bookList.add(newBook);
            System.out.println("------------------Displaying newly added book----------------------");
            newBook.display();
            System.out.println("");
        }
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }
    
    public static void removeBook()
    {
        System.out.println("-------------------------Remove book-----------------------------");
        System.out.print("Enter book id of book to remove from list : ");
        int bookIdToRemove = scan.nextInt();
        buffer = scan.nextLine();
        
        int index = findBookFromId(bookIdToRemove);
        if(index == -1)
        {
            System.out.println("Book not found!");
        }
        else
        {
            bookList.remove(index);
            System.out.println("Book removed!");
        }
        
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }

    public static void searchBook()
    {
        System.out.println("--------------------------Search book-----------------------------");
        System.out.print("Enter book id of book to search : ");
        int bookIdToSearch = scan.nextInt();
        buffer = scan.nextLine();
        
        int index = findBookFromId(bookIdToSearch);
        if(index == -1)
        {
            System.out.println("Book not found!");
        }
        else
        {
            Book b = bookList.get(index);
            System.out.println("Displaying found book : \n");
            b.display();
            System.out.println("");
        }
        
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }
    
    public static void displayBooks()
    {
        Book b;
        System.out.println("----------------------------All Books------------------------------");

        if(bookList.isEmpty())
        {
            System.out.println("Book List Empty!");
        }
        else
        {
            for(int i = 0; i < bookList.size(); i++)
            {   
                b = bookList.get(i);
                b.display();
                System.out.println("********************************************************************");
            }
        }
        
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }
    
    public static void addMember()
    {
        Member newMember = new Member();
        System.out.println("-----------------Enter details for the new member--------------------");
        newMember.getData();
        if(findMemberFromId( newMember.getMemberId() ) != -1)
        {
            System.out.println("Member with same id is already present!");
        }
        else
        {
            memberList.add(newMember);
            System.out.println("--------------Displaying newly added member--------------------------");
            newMember.display();
            System.out.println("");
        }
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }
    
    public static void removeMember()
    {
        System.out.println("---------------------------Remove Member----------------------------");
        System.out.print("Enter member id of member to remove from list : ");
        int memberIdToRemove = scan.nextInt();
        buffer = scan.nextLine();
        
        int index = findMemberFromId(memberIdToRemove);
        if(index == -1)
        {
            System.out.println("Member not found!");
        }
        else
        {
            memberList.remove(index);
            System.out.println("Member removed!");
        }
        
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }
    
    public static void searchMember()
    {
        System.out.println("-------------------------Search Member----------------------------");
        System.out.print("Enter member id of member to search : ");
        int memberIdToSearch = scan.nextInt();
        buffer = scan.nextLine();
        
        int index = findMemberFromId(memberIdToSearch);
        if(index == -1)
        {
            System.out.println("Member not found!");
        }
        else
        {
            Member m = memberList.get(index);
            System.out.println("Displaying found member : \n");
            m.display();
            System.out.println("");
        }
        
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }
    
    public static void displayMembers()
    {
        Member m;
        System.out.println("---------------------------All Members-----------------------------");

        if(memberList.isEmpty())
        {
            System.out.println("Member List Empty!");
        }
        else
        {
            for(int i = 0; i < memberList.size(); i++)
            {   
                m = memberList.get(i);
                m.display();
                System.out.println("********************************************************************");
            }
        }
        
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }
    
    public static void issueBook()
    {
        System.out.println("---------------------------Issue Book-------------------------------");
        System.out.print("Enter id of member who wants to issue book : ");
        int issuingMemberId = scan.nextInt();
        buffer = scan.nextLine();
        
        int memberIndex = findMemberFromId(issuingMemberId);
        if(memberIndex == -1)
        {
            System.out.println("Member not found");
        }
        else
        {
            System.out.print("Enter id of book to be issued : ");
            int issuingBookId = scan.nextInt();
            buffer = scan.nextLine();
        
            int bookIndex = findBookFromId(issuingBookId);
            if(bookIndex == -1)
            {
                System.out.println("Book not found");
            }
            else
            {
                Book b = bookList.get(bookIndex);
                b.issue(issuingMemberId);
            }
        }
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();    
    }
    
    public static void returnBook()
    {
        System.out.println("---------------------------Return Book------------------------------");
        System.out.print("Enter id of member who is returning book : ");
        int returningMemberId = scan.nextInt();
        buffer = scan.nextLine();
        
        int memberIndex = findMemberFromId(returningMemberId);
        if(memberIndex == -1)
        {
            System.out.println("Member not found");
        }
        else
        {
            Member m = memberList.get(memberIndex);
            
            System.out.print("Enter id of returned book : ");
            int returningBookId = scan.nextInt();
            buffer = scan.nextLine();
        
            int bookIndex = findBookFromId(returningBookId);
            if(bookIndex == -1)
            {
                System.out.println("Book not found");
            }
            else
            {
                Book b = bookList.get(bookIndex);
                b.returned(m);
            }
        }
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();  
    }
    
    public static void payFine()
    {
        System.out.println("--------------------------Pay Fine------------------------------");
        System.out.print("Enter member id of member who wants to pay fine : ");
        int memberId = scan.nextInt();
        buffer = scan.nextLine();
        
        int memberIndex = findMemberFromId(memberId);
        if(memberIndex == -1)
        {
            System.out.println("Member not found!");
        }
        else
        {
            System.out.println("Displaying details of member : \n");
            Member m = memberList.get(memberIndex);
            m.display();
            System.out.println("");
            
            System.out.print("Enter the amount of fine paid : ");
            float paidAmount = scan.nextFloat();
            buffer = scan.nextLine();
            m.payFine(paidAmount);
        }
        System.out.println("");
        System.out.print("Press Enter key to go to main menu....");
        buffer = scan.nextLine();
    }
    
}