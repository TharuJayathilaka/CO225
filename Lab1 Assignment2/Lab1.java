 class Lab1 {

    public static void showMaxima(int [] array) {
	  // implement
	    int maxElement=0;
        int len=array.length , i ;  //get the length of the array as len
        for(i=1;i<len-1;i++){ 
            if((array[i-1]<array[i])&&(array[i]>array[i+1])){   // compare the elements of the array to get the local maximum
              maxElement=i;
			  System.out.println("The local maximas in the set is "+maxElement +" element. And it's value is "+array[i]);  // print the maximun element and its value.
            }
        }
    }

    public static void main(String [] args) {
	  int [] array = {0, 1, 2, 1, 0, -1, 2, 3, 5, 6, 7, 4, 3, 4, 6, 5, 4};
	  showMaxima(array);
    }
	
}