package sample.pettern.factorymethod.java8;

import sample.pettern.factory.bean.Bus;
import sample.pettern.factory.bean.Car;

public class FactoryMethodPatternV8exec {

	public static void main(String[] args) {

		/**
			以下は、FunctionalInterfaceであるVehicleDriverを実行する。
			その際、public Vehicle getVehicle();を() -> new Carを実装として実行する。
			戻り値がVehicleなので、CarもBusも成り立つ。
			戻り値がvoidなら特に渡した関数は関係ない為、エラーにはならない。
			ただし、その場合、継承元のクラスを元に各メソッドが処理を行えない為、
			Factory Methodパターンは不成立になる。
			
			試してみたが、FunctionalInterfaceでない場合（抽象メソッドが複数ある場合、
			handleVehicle(Car::new);がmust be FunctionalInterfaceと怒られる。
			もう少し詳しく書きたい・・・
		 */
		handleVehicle(Car::new);
		handleVehicle(() -> new Car());
		handleVehicle(Bus::new);
		
	}

	static void handleVehicle(VehicleDriver vDriver) {
		System.out.println("Handling a new vehicle...");
		vDriver.driveVehicle();
		vDriver.cleanVehicle();
	}
	
	/* ----　decompile結果　----------
		package sample.pettern.factorymethod.java8;
		
		import java.io.PrintStream;
		import java.lang.invoke.LambdaMetafactory;
		import sample.pettern.factory.bean.Car;
		import sample.pettern.factory.bean.Vehicle;
		import sample.pettern.factorymethod.java8.VehicleDriver;
		
		public class FactoryMethodPatternV8exec {
		    public static void main(String[] args) {
		        FactoryMethodPatternV8exec.handleVehicle((VehicleDriver)LambdaMetafactory.metafactory(null, null, null, ()Lsample/pettern/factory/bean/Vehicle;, <init>(), ()Lsample/pettern/factory/bean/Vehicle;)());
		        FactoryMethodPatternV8exec.handleVehicle((VehicleDriver)LambdaMetafactory.metafactory(null, null, null, ()Lsample/pettern/factory/bean/Vehicle;, lambda$0(), ()Lsample/pettern/factory/bean/Vehicle;)());
		        FactoryMethodPatternV8exec.handleVehicle((VehicleDriver)LambdaMetafactory.metafactory(null, null, null, ()Lsample/pettern/factory/bean/Vehicle;, <init>(), ()Lsample/pettern/factory/bean/Vehicle;)());
		    }
		
		    static void handleVehicle(VehicleDriver vDriver) {
		        System.out.println("Handling a new vehicle...");
		        vDriver.driveVehicle();
		        vDriver.cleanVehicle();
		    }
		
		    private static Vehicle lambda$0() {
		        return new Car();
		    }
		}
	 */
}


