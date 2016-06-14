package sample.pettern.factorymethod.java7;

import sample.pettern.factory.bean.Bus;
import sample.pettern.factory.bean.Vehicle;

public class BusDriver extends VehicleDriver {
	@Override
	  public Vehicle getVehicle(){
	    return new Bus();
	  }
}
