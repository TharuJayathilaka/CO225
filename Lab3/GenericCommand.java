/*******************************************************************
                 Skeleton code 
********************************************************************/

public class GenericCommand { 
    /* this is the generic command 
     * your commands should reimplement this
     */
    
	protected static int count=0;
	
    public void handleCommand(String [] args)  { 
	System.out.println("Command not implemented!");
    }

    public void someThingWrong() {   
	System.out.println("Something Wrong in code!!!");
    }
	
	public void syntaxWrong1() {   // method to say if not enough arguments were given
	System.out.println("Error : Not enough input argument!!!");
    }
	
	public void syntaxWrong2() {   // method to say if more arguments were given
	System.out.println("Error : More input argument!!!");
    }
}

