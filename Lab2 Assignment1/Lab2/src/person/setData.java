package person;


import BMI.getData;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class setData {
	public static void main(String args[]) throws IOException{
	   Scanner sc=new Scanner(new BufferedReader(new FileReader("input.txt")));
	   String [][] array=new String[6][3]; 
	   while(sc.hasNextLine()){ 
		   for(int i=0;i<6;i++){
			   String[] line=sc.nextLine().trim().split(","); 
			   for(int j=0;j<3;j++){
				   array[i][j]=line[j]; 
			   }
		   }
	   }
	   
	   getData object[]=new getData[6];
	   
	   for(int p=0;p<6;p++){
		   
		   object[p]= new getData();
		                             //transfer strings to double values
		   double H=Double.parseDouble(array[p][2]);
		   double W=Double.parseDouble(array[p][1]);
		                             // give values to the variables of objects
		   object[p].setName(array[p][0]);
		   object[p].setWeight(H);
		   object[p].setHeight(W);
		                            //get the bmi value
		   double B =object[p].bmiValue();
		   object[p].print();
		   System.out.print(", BMI: "+B+",");
		    if(B>25) {       // print the status
				System.out.println(" Status: You are overweight.");
			}else if(B>18.5) {
				System.out.println(" Status: You are healthy.");
			}else {
				System.out.println(" Status: Not healthy.");
			}
	   } 
	}
}