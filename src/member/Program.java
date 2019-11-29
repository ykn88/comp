package member;


import java.util.List;
import java.util.Scanner;

import dao.MemDao;
import pojo.Member;

public class Program {
	
	
	static Scanner sc = new Scanner(System.in);
	private static void printRecord(List<Member> member)
	{
		if(member!= null)
		{
			for (Member mem: member)
			{
				System.out.println(mem.toString());
			}
		}
	}
	
	public static int menuList()
	{
		System.out.println("1. Display Books");
		System.out.println("2. Find Book");
		System.out.println("Enter your choice");
		return sc.nextInt();
		
	}

	public static void main(String[] args)
	{
	    try(MemDao mem = new MemDao())
	    {
	    	int choice;
	    	String name; 
	    	while((choice=Program.menuList())!=0)
	    	{
	    		switch(choice)
	    		{
	    		case 1: List<Member> mems = mem.getBooks();
	    		         Program.printRecord(mems);
	    		         break;
	    		case 2: System.out.println("Enter the name of the book");
	    				sc.nextLine();
	    			    name = sc.nextLine();
	    			    List<Member> mems1 = mem.findBooks(name);
		                Program.printRecord(mems1);
		                break;         
	    		}
	    	}
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    		
	}

}
