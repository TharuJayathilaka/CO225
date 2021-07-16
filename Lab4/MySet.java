
/* my array list: an array that behaves like a list 
 * E/16/156
 */

public class MySet<T/* Can we have any T */> { 

    int nextItem; 
    int currentCapacity; 
    T[] data; // DO NOT CHANGE

    private static int defaultSizeToCreate = 10; // how many elements to create 

    @SuppressWarnings("unchecked")
	
    public MySet(int elements) { 
		this.nextItem = 0; 
		this.defaultSizeToCreate = elements; /* can change the value of a static variable and can access without creating an object. 
	                                           if one object changes the value of the static variable, it will reflect in other objects too  */         
		this.currentCapacity = elements; 

		this.data = (T[]) new Object[this.defaultSizeToCreate]; 
    }
	
    public MySet() { 
		this(defaultSizeToCreate); 
    }

    public boolean isEmpty() {
		return this.nextItem == 0;
	}
	
    public boolean isFull() { 
		return false; /* never get filled */
	} 

    @SuppressWarnings("unchecked")
	
	
    public boolean add(T item) { 
		//data[nextItem] = null; // DO NOT CHANGE 

		/* if there is any element delete it 
		* then add the new element. 
		* How do you handle when the array is full: 
		* crate a new array with currentCapacity+defaultSizeToCreate, 
		* copy the old conents into that
		* Accessing array when full might be a problem
		*/
		
		//check whether the given item is already in the array or not
    	int i=0;
		//going through the entire array. if data[i]==null means end of the current array.
    	while(i<currentCapacity  && data[i]!=null)  {
			
    		if(item.equals(data[i])==true)  {
    			return false;
    		}
			
    		i++;
			
    	}
		// because array never gets filled, we have to check current capacity and nextitem
        if(currentCapacity <= nextItem)  {
			
			int j;
			// if array ps filled, crate a new array with currentCapacity+defaultSizeToCreate
    		T[] updatedata = (T[])new Object[currentCapacity+defaultSizeToCreate];
			//copy the old conents into that
    		for(j=0;j<currentCapacity;j++){
    			updatedata[j]=data[j];
    		}
			//make the new array as the current one
    		data=updatedata;
			// add the new elemant
    		data[currentCapacity]=item;
			//renew the capacity, because now the capacity has change
    		currentCapacity=currentCapacity+defaultSizeToCreate;
			//increase the next item to get another elemant
    		nextItem++;
			
    		return true;
			
    	}else{
			// add the new elemant
			data[nextItem]=item;
			//increase the next item to get another elemant
			nextItem++;
			//new nextitem should be null
			try {    	
    			data[nextItem] = null;// DO NOT CHANGE
    		}
    		catch(ArrayIndexOutOfBoundsException e){};
			
    		return true;
    	}	
    }


    public T remove() { 
		/* remove the first element in the array 
		* and copy the rest front. 
		* FIFO structure. 
		* If the ArrayList is empty return null
		*/
		
		// define a new item as firstelemant. to store the first item of the array
		T firstElement;
		
		/* Option 1: */
	
		if(isEmpty()){
			return null; 
		// IMPLEMENT THE REST 
		}else{
			//store the first element value
			firstElement=data[0];
			int m=0;
			//copy the rest front
			while(m < currentCapacity-1){
				data[m]=data[m+1];
				m++;
			}
			// the final element should be null because first one is removed and rest has copied to the front
			data[m]=null;
			return firstElement;
		}

		/* Option 2: 
		if(!isEmpty()) { 
			// IMPLEMENT THE REST
			//store the first element value
			firstElement=data[0];
			int n=0;
			//copy the rest front
			while(n < currentCapacity-1){
				data[n]=data[n+1];
				n++;
			}
			// the final element should be null because first one is removed and rest has copied to the front
			data[n]=null;
			return firstElement;
		}else{
			return null;
		// which option is better? why? 
		}    
		*/
	}


}
	 

	