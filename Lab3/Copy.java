import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Copy extends GenericCommand { 
    
	 public void handleCommand(String [] args) { 
        
		count++;      //  take the count to display it at last
		
	    if(!args[0].equals("copy")) {   // should give copy as an argument to assess this
			someThingWrong();    
		}
		if(args.length < 3) {   // if not enough arguments were given
			syntaxWrong1();
		}			
          
		if(args.length > 3) {   // if more arguments were given
			syntaxWrong2();
		}	  
		
		if(args.length == 3) {    // if the syntax and input arguments are correct
		    FileInputStream instream=null;
		    FileOutputStream outstream=null;
			
			try{
				File sourceFile=new File(args[1]);
				File destinationFile=new File(args[2]);
				
				instream  = new FileInputStream(sourceFile);
				outstream = new FileOutputStream(destinationFile);
				
				byte[] buffer = new byte [1024];
				
				int len;
				
				while((len=instream.read(buffer))>0){  // using read and write method copying input stream to output stream
					outstream.write(buffer,0,len);
				}
				
				instream.close();  // closing the streams
				outstream.close();
				                                    // print a message to say task has been completed successfully
				System.out.println("\n File has copied successfully from "+args[1]+" to "+args[2]+" \n"); 
			
		    }catch(IOException e) { 
	        // IOException is more generic (FileNotFound is a type of a 
	        // IOException, so catching only that is sufficient 
	           return; 
	        }
		   
		}
		 
	}
}