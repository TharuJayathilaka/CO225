public class Quit extends GenericCommand { 

    /* Quit command 
     * Only quit should be there. 
     * no arguments, 
     */ 
    public void handleCommand(String [] args) { 
    
	count++;   //  take the count to display it at last
	
	if(!args[0].equals("quit")) someThingWrong();    // should give quit as an argument to assess this 

	if(args.length != 1) {   // if along with quit another arguments also given, print an error message
	    System.out.println("Usage: quit");
	    return;
	}
    
	System.out.println("Executed "+ count + " commands since starting ");  // print the count of the commands
	
	System.exit(0); // Exit of the system that we have created
	
    }

}