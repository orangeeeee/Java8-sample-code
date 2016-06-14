package sample.pettern.factorymethod.java7;

import sample.pettern.factory.bean.Vehicle;

public abstract class VehicleDriver {
	
	  public abstract Vehicle getVehicle();
	  
	  public void driveVehicle(){
	    getVehicle().drive();
	  }
	  public void cleanVehicle(){
	    getVehicle().clean();
	  }
}
