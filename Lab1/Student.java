import java.math.*;
import java.util.Random; // for random
import java.io.*; // for file IO



public class Student{  //making the public class student
    final int maxAttendance;    // a fixed value through out the code
    static double total=0.0;    // initial value of total is 0
    public Student(){
        maxAttendance=45;       // value of the maximum attendance
        //total=0;
    }

    public double attendancePercentage(){   // a method to get the percentage of each student
        int randomAttendance = (int)(Math.random() * 45);    //generating the random numbers in between 0 and 45
        //System.out.println(randomAttendance);
        total+=randomAttendance;     // to get the total attendance of all the student 
        double Percentage = (double)((randomAttendance*100)/45);  // casting integer value to a double value
        return Percentage;
    }
    public void average(){         // a method to get average attendance percentage of all the students
        double a=(total*100)/(61*45);
        System.out.println("\n Average attendance percentage of all the students is  " + a);
    }
}




