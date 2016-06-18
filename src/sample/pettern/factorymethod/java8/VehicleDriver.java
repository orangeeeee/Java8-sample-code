package sample.pettern.factorymethod.java8;

import sample.pettern.factory.bean.Vehicle;

@FunctionalInterface
public interface VehicleDriver {
	
	public Vehicle getVehicle();
		
	public default void driveVehicle() {
		getVehicle().drive();
	}
	
	public default void cleanVehicle() {
		getVehicle().clean();
	}
}
