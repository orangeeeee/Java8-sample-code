package sample.pettern.factory.bean;

public class Bus implements Vehicle {
	
	  @Override
	  public void drive(){
	    System.out.println("Driving a Bus...");
	  }
	   
	  @Override
	  public void clean(){
	    System.out.println("Cleaning a Bus...");
	  }
}
