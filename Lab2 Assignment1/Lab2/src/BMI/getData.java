package BMI;

public class getData {
	private String Name;     //defining the variables
	private double weight;
	private double height;
	
	
	public String getName() {    // this will return the name
		return Name;
	}
	public void setName(String Name) {   // by this we can get the name
		this.Name = Name;
	}
	public double getWeight() {   // this will return the weight
		return weight;
	}
	public void setWeight(double weight) {  // in here this.weight can use inside the class
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void print() {  // a method to print names , height, weight
		System.out.print("Name: "+ this.Name+", Height(m): "+this.height+", Weight(Kg): "+this.weight);
	}
	public double bmiValue() {  // get the bmi value
		double bmi= this.weight/(this.height*this.height); 
		return bmi;
	}
}
