package sample.pettern.factorymethod.java7;

import sample.pettern.factory.bean.Car;
import sample.pettern.factory.bean.Vehicle;

public class CarDriver extends VehicleDriver {
	  @Override
	  public Vehicle getVehicle(){
	    return new Car();
	  }
}
