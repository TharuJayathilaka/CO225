import java.io.BufferedReader; // for random 
import java.io.FileReader; // for file IO
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

public class Less extends GenericCommand {

 
	public void handleCommand(String [] args) { 
	
        count++;   //  take the count to display it at last
		
	    if(!args[0].equals("less")) {   // should give less as an argument to assess this
			someThingWrong();
		}
        if(args.length < 2) {   // if not enough arguments were given
			syntaxWrong1();
		}			
          
		if(args.length > 2) {   // if more arguments were given
			syntaxWrong2();
		}		  
		  
	    if(args.length == 2) {   // Reading a file
		    Scanner descriptor = null; 
	        String line = null;  
	        try { 
	            descriptor = new Scanner(new BufferedReader(
			    new FileReader(args[1])));   // take the file name as argument 
				
				System.out.println("\n");  // to separate the content of the file

	            while(descriptor.hasNextLine()){ 
		            System.out.println(descriptor.nextLine());   //print the lines of the text
		        }

	            descriptor.close();    
				
				System.out.println("\n");    // to separate the content of the file

	        }catch(IOException e) { 
	        // IOException is more generic (FileNotFound is a type of a 
	        // IOException, so catching only that is sufficient 
	           return; 
	        }
			
			return;
	    } 
	}
}
