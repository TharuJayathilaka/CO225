package searchData;

import contacts.person; 
import java.io.BufferedReader; // for random 
import java.io.FileReader; // for file IO
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws IOException{ //read the given contacts file
		   Scanner sc=new Scanner(new BufferedReader(new FileReader("contacts.txt")));
		   String [][] array=new String[16][3]; 
		   while(sc.hasNextLine()){ 
			   for(int i=0;i<16;i++){
				   String[] line=sc.nextLine().trim().split(",");    // separating strings by the comma
				   for(int j=0;j<3;j++){
					   array[i][j]=line[j];    // give all the strings to arrays
				   }
			   }
		   }

 
	
	
	       String input=args[0]; //get input String
	       String name=input.substring(2,input.length()); //get name using substring
	       String firstLetter=input.substring(0,1); //get the first letter using substring

	       person object[]=new person[16];  //create new 16 objects
	       int count=0;
	   
	       for(int p=0;p<16;p++){
		   
	           object[p]= new person();   //use those new objects and assign values to variables
		                             // give values to the variables of objects
		       object[p].setFirstName(array[p][0]);
		       object[p].setLastName(array[p][1]);
		       object[p].setPhoneNumber(array[p][2]);
		  
	
	           if((firstLetter.equals("F"))&&(name.equals(object[p].getFirstName()))){  // comparing "F" and the name
		          System.out.println("Name: "+object[p].getFirstName()+" "+object[p].getLastName()+" , Phone Number: "+object[p].getPhoneNumber());
	          }else if((firstLetter.equals("L"))&&(name.equals(object[p].getLastName()))){   // comparing "L" and the name
		         System.out.println("Name: "+object[p].getFirstName()+" "+object[p].getLastName()+" , Phone Number: "+object[p].getPhoneNumber());
	          }else {
		         //System.out.println("There is no phone number matching to that name.");
		         count++;
              }
	     }
	     if(count==16){   // check the errors 
	         if((!firstLetter.equals("F"))&&(!firstLetter.equals("L"))){  //if not valid syntax was used in command line
		         System.out.println("Should type F or L to define first name or last name");
	         }else{   // if that particular name is not present in the given contact list
		         System.out.println("There is no phone number matching to that name.");
		     }
	     }
     }
}

