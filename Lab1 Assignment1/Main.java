import java.math.*;
import java.util.Random; // for random
import java.io.*; // for file IO

class Main{
   public static void main(String [] args) {
        Student student[]= new Student[62];  // making the object array of students
        Student extra=new Student();      // another object called extra to get the average attendance percentage of all the students
        
		/* Reading a file. 
	       */
		
        BufferedReader descriptor = null;
	    String line = null;
	    String [] names = new String[62]; // 61 names
	    try {
	         descriptor = new BufferedReader(
			    new FileReader("co225-classlist.txt"));

	         for(int i=0; i < names.length; i++) // assume file has 61 lines
		         names[i] = descriptor.readLine();
	             descriptor.close();

	    }catch(IOException e) {
	    // IOException is more generic (FileNotFound is a type of a
	    // IOException, so catching only that is sufficient
	         System.out.println("Bad things happen, what do you do!" + e);
	         return;
        }

	/* we will run only if no exceptions were thrown
	      for(int i=0; i < names.length; i++)
	         System.out.println(names[i]);   */

       
	     double percentage;    
         for(int i=0; i < 61; i++){   // a loop to get all the students and their attendance to check the percentage below 80%.
            student[i]= new Student();  // this one make new student object.But this is in a for loop.So in each time this will create a new object
            percentage=student[i].attendancePercentage();  // get the percentage using the methods in class student
            if(percentage<80.0){
                System.out.println("Name: " + names[i] + "\t Percentage: "+ percentage);
            }
        }
        extra.average();
    }
}

