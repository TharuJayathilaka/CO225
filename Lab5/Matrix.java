public class Matrix extends Thread { 

    private static int [][] a; 
    private static int [][] b; 
    private static int [][] c; 
	private static int row,col,dim; // variables for threads

    /* You might need other variables as well */

    public Matrix(int[][] A,int[][] B,int[][] C,int row, int col, int dim) { // need to change this, might need some information 
	     this.a=A;    
         this.b=B;
         this.c=C;
         this.row=row;    
         this.col=col;
		 this.dim=dim;
	
    }
	
	public void run(){
         for(int k=0;k<dim;k++){
               c[row][col]+=a[row][k]*b[k][col];        
         }      
          //System.out.println("Thread "+row+","+col+" complete.");        
    }  
	

    public static int [][] multiply(int [][] a, int [][] b) {

	/* check if multipication can be done, if not 
	 * return null 
	 * allocate required memory 
	 * return a * b
	 */

		int x = a.length; // number of rows in A matrix
		int y = b[0].length; // number of columns in B matrix

		int z1 = a[0].length; // number of columns in A matrix
		int z2 = b.length; // number of rows in B matrix

		if(z1 != z2) { // the ONLY need for matrix multiplication is being checked in here. 
		               //That is number of columns in A matrix = number of rows in B matrix
			System.out.println("Cannnot multiply");
			return null;
		}
	    // until here its the sample code
		
		
		int[][] c=new int[x][y];
		
		//create threads for each element of resultant matrix
		Matrix[][] thread= new Matrix[x][y]; 
	

		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++) {
				thread[i][j]=new Matrix(a,b,c,i,j,z1);
				//start() the thread will return to the runnable state 
				thread[i][j].start();
				try{
					//join() method will keep waiting if the referenced thread is blocked or is taking too long to process
					thread[i][j].join();
				}
				catch(InterruptedException e){}
			}
		}  

		return c;

	}
	/*
	1. How to use threads to parallelize the operation? 
		Multithreading is a teachnique that allows for concurrent execution of two or more parts of a program. If we use threads to gain each element of the
		resultant matrix using concurrent execution, rather than gaining one element and then next it's easy for us and it reduce the running time a lot.
	
	2. How may threads to  use? 
		We have to use 3 threads. There are three elemants in the resultant matrix, so we have to use 3 threads
	
	3. How to allocate work for each thread (recall it is the run function which all the threads execute) 
		A process is a collection of code , memory, data and resourses.A thread is a sequence of code that is executed within the scope of the process.
		We can have multiple threads executing concurrently within the same process.
		But here I have used join method which called on the thread instance, a thread will not start running until another thread finish executing.
	
	4. How to synchronize? 
		join() method allows one thread to wait until another thread to complete its execution as synchronized block can be use to prevent two different threads
		If thread  is interrupted it will throw InterruptedException
	*/
   
   
}