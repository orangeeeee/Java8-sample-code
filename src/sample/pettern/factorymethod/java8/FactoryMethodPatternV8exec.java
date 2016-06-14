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
	
	/* javapでのコンパイル結果を見るとやはり、getVehicle()が実行された後にVehicleをnewしている。
	 
		javap -v FactoryMethodPatternV8exec.class 
		Classfile /Users/orangeeeee/eclipse_workspace/Java8-sample-code/bin/sample/pettern/factorymethod/java8/FactoryMethodPatternV8exec.class
		  Last modified 2016/06/14; size 1797 bytes
		  MD5 checksum be275209a87f2bd2ff9325da9be31cfc
		  Compiled from "FactoryMethodPatternV8exec.java"
		public class sample.pettern.factorymethod.java8.FactoryMethodPatternV8exec
		  minor version: 0
		  major version: 52
		  flags: ACC_PUBLIC, ACC_SUPER
		Constant pool:
		   #1 = Class              #2             // sample/pettern/factorymethod/java8/FactoryMethodPatternV8exec
		   #2 = Utf8               sample/pettern/factorymethod/java8/FactoryMethodPatternV8exec
		   #3 = Class              #4             // java/lang/Object
		   #4 = Utf8               java/lang/Object
		   #5 = Utf8               <init>
		   #6 = Utf8               ()V
		   #7 = Utf8               Code
		   #8 = Methodref          #3.#9          // java/lang/Object."<init>":()V
		   #9 = NameAndType        #5:#6          // "<init>":()V
		  #10 = Utf8               LineNumberTable
		  #11 = Utf8               LocalVariableTable
		  #12 = Utf8               this
		  #13 = Utf8               Lsample/pettern/factorymethod/java8/FactoryMethodPatternV8exec;
		  #14 = Utf8               main
		  #15 = Utf8               ([Ljava/lang/String;)V
		  #16 = NameAndType        #17:#18        // getVehicle:()Lsample/pettern/factorymethod/java8/VehicleDriver;
		  #17 = Utf8               getVehicle
		  #18 = Utf8               ()Lsample/pettern/factorymethod/java8/VehicleDriver;
		  #19 = InvokeDynamic      #0:#16         // #0:getVehicle:()Lsample/pettern/factorymethod/java8/VehicleDriver;
		  #20 = Methodref          #1.#21         // sample/pettern/factorymethod/java8/FactoryMethodPatternV8exec.handleVehicle:(Lsample/pettern/factorymethod/java8/VehicleDriver;)V
		  #21 = NameAndType        #22:#23        // handleVehicle:(Lsample/pettern/factorymethod/java8/VehicleDriver;)V
		  #22 = Utf8               handleVehicle
		  #23 = Utf8               (Lsample/pettern/factorymethod/java8/VehicleDriver;)V
		  #24 = InvokeDynamic      #1:#16         // #1:getVehicle:()Lsample/pettern/factorymethod/java8/VehicleDriver;
		  #25 = InvokeDynamic      #2:#16         // #2:getVehicle:()Lsample/pettern/factorymethod/java8/VehicleDriver;
		  #26 = Utf8               args
		  #27 = Utf8               [Ljava/lang/String;
		  #28 = Fieldref           #29.#31        // java/lang/System.out:Ljava/io/PrintStream;
		  #29 = Class              #30            // java/lang/System
		  #30 = Utf8               java/lang/System
		  #31 = NameAndType        #32:#33        // out:Ljava/io/PrintStream;
		  #32 = Utf8               out
		  #33 = Utf8               Ljava/io/PrintStream;
		  #34 = String             #35            // Handling a new vehicle...
		  #35 = Utf8               Handling a new vehicle...
		  #36 = Methodref          #37.#39        // java/io/PrintStream.println:(Ljava/lang/String;)V
		  #37 = Class              #38            // java/io/PrintStream
		  #38 = Utf8               java/io/PrintStream
		  #39 = NameAndType        #40:#41        // println:(Ljava/lang/String;)V
		  #40 = Utf8               println
		  #41 = Utf8               (Ljava/lang/String;)V
		  #42 = InterfaceMethodref #43.#45        // sample/pettern/factorymethod/java8/VehicleDriver.driveVehicle:()V
		  #43 = Class              #44            // sample/pettern/factorymethod/java8/VehicleDriver
		  #44 = Utf8               sample/pettern/factorymethod/java8/VehicleDriver
		  #45 = NameAndType        #46:#6         // driveVehicle:()V
		  #46 = Utf8               driveVehicle
		  #47 = InterfaceMethodref #43.#48        // sample/pettern/factorymethod/java8/VehicleDriver.cleanVehicle:()V
		  #48 = NameAndType        #49:#6         // cleanVehicle:()V
		  #49 = Utf8               cleanVehicle
		  #50 = Utf8               vDriver
		  #51 = Utf8               Lsample/pettern/factorymethod/java8/VehicleDriver;
		  #52 = Utf8               lambda$0
		  #53 = Utf8               ()Lsample/pettern/factory/bean/Vehicle;
		  #54 = Class              #55            // sample/pettern/factory/bean/Car
		  #55 = Utf8               sample/pettern/factory/bean/Car
		  #56 = Methodref          #54.#9         // sample/pettern/factory/bean/Car."<init>":()V
		  #57 = Utf8               SourceFile
		  #58 = Utf8               FactoryMethodPatternV8exec.java
		  #59 = Utf8               BootstrapMethods
		  #60 = Methodref          #61.#63        // java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
		  #61 = Class              #62            // java/lang/invoke/LambdaMetafactory
		  #62 = Utf8               java/lang/invoke/LambdaMetafactory
		  #63 = NameAndType        #64:#65        // metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
		  #64 = Utf8               metafactory
		  #65 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
		  #66 = MethodHandle       #6:#60         // invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
		  #67 = MethodType         #53            //  ()Lsample/pettern/factory/bean/Vehicle;
		  #68 = MethodHandle       #8:#56         // newinvokespecial sample/pettern/factory/bean/Car."<init>":()V
		  #69 = MethodType         #53            //  ()Lsample/pettern/factory/bean/Vehicle;
		  #70 = MethodType         #53            //  ()Lsample/pettern/factory/bean/Vehicle;
		  #71 = Methodref          #1.#72         // sample/pettern/factorymethod/java8/FactoryMethodPatternV8exec.lambda$0:()Lsample/pettern/factory/bean/Vehicle;
		  #72 = NameAndType        #52:#53        // lambda$0:()Lsample/pettern/factory/bean/Vehicle;
		  #73 = MethodHandle       #6:#71         // invokestatic sample/pettern/factorymethod/java8/FactoryMethodPatternV8exec.lambda$0:()Lsample/pettern/factory/bean/Vehicle;
		  #74 = MethodType         #53            //  ()Lsample/pettern/factory/bean/Vehicle;
		  #75 = MethodType         #53            //  ()Lsample/pettern/factory/bean/Vehicle;
		  #76 = Methodref          #77.#9         // sample/pettern/factory/bean/Bus."<init>":()V
		  #77 = Class              #78            // sample/pettern/factory/bean/Bus
		  #78 = Utf8               sample/pettern/factory/bean/Bus
		  #79 = MethodHandle       #8:#76         // newinvokespecial sample/pettern/factory/bean/Bus."<init>":()V
		  #80 = MethodType         #53            //  ()Lsample/pettern/factory/bean/Vehicle;
		  #81 = Utf8               InnerClasses
		  #82 = Class              #83            // java/lang/invoke/MethodHandles$Lookup
		  #83 = Utf8               java/lang/invoke/MethodHandles$Lookup
		  #84 = Class              #85            // java/lang/invoke/MethodHandles
		  #85 = Utf8               java/lang/invoke/MethodHandles
		  #86 = Utf8               Lookup
		{
		  public sample.pettern.factorymethod.java8.FactoryMethodPatternV8exec();
		    descriptor: ()V
		    flags: ACC_PUBLIC
		    Code:
		      stack=1, locals=1, args_size=1
		         0: aload_0
		         1: invokespecial #8                  // Method java/lang/Object."<init>":()V
		         4: return
		      LineNumberTable:
		        line 6: 0
		      LocalVariableTable:
		        Start  Length  Slot  Name   Signature
		            0       5     0  this   Lsample/pettern/factorymethod/java8/FactoryMethodPatternV8exec;
		
		  public static void main(java.lang.String[]);
		    descriptor: ([Ljava/lang/String;)V
		    flags: ACC_PUBLIC, ACC_STATIC
		    Code:
		      stack=1, locals=1, args_size=1
		         0: invokedynamic #19,  0             // InvokeDynamic #0:getVehicle:()Lsample/pettern/factorymethod/java8/VehicleDriver;
		         5: invokestatic  #20                 // Method handleVehicle:(Lsample/pettern/factorymethod/java8/VehicleDriver;)V
		         8: invokedynamic #24,  0             // InvokeDynamic #1:getVehicle:()Lsample/pettern/factorymethod/java8/VehicleDriver;
		        13: invokestatic  #20                 // Method handleVehicle:(Lsample/pettern/factorymethod/java8/VehicleDriver;)V
		        16: invokedynamic #25,  0             // InvokeDynamic #2:getVehicle:()Lsample/pettern/factorymethod/java8/VehicleDriver;
		        21: invokestatic  #20                 // Method handleVehicle:(Lsample/pettern/factorymethod/java8/VehicleDriver;)V
		        24: return
		      LineNumberTable:
		        line 20: 0
		        line 21: 8
		        line 22: 16
		        line 24: 24
		      LocalVariableTable:
		        Start  Length  Slot  Name   Signature
		            0      25     0  args   [Ljava/lang/String;
		
		  static void handleVehicle(sample.pettern.factorymethod.java8.VehicleDriver);
		    descriptor: (Lsample/pettern/factorymethod/java8/VehicleDriver;)V
		    flags: ACC_STATIC
		    Code:
		      stack=2, locals=1, args_size=1
		         0: getstatic     #28                 // Field java/lang/System.out:Ljava/io/PrintStream;
		         3: ldc           #34                 // String Handling a new vehicle...
		         5: invokevirtual #36                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
		         8: aload_0
		         9: invokeinterface #42,  1           // InterfaceMethod sample/pettern/factorymethod/java8/VehicleDriver.driveVehicle:()V
		        14: aload_0
		        15: invokeinterface #47,  1           // InterfaceMethod sample/pettern/factorymethod/java8/VehicleDriver.cleanVehicle:()V
		        20: return
		      LineNumberTable:
		        line 27: 0
		        line 28: 8
		        line 29: 14
		        line 30: 20
		      LocalVariableTable:
		        Start  Length  Slot  Name   Signature
		            0      21     0 vDriver   Lsample/pettern/factorymethod/java8/VehicleDriver;
		}
		SourceFile: "FactoryMethodPatternV8exec.java"
		BootstrapMethods:
		  0: #66 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
		    Method arguments:
		      #67 ()Lsample/pettern/factory/bean/Vehicle;
		      #68 newinvokespecial sample/pettern/factory/bean/Car."<init>":()V
		      #69 ()Lsample/pettern/factory/bean/Vehicle;
		  1: #66 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
		    Method arguments:
		      #70 ()Lsample/pettern/factory/bean/Vehicle;
		      #73 invokestatic sample/pettern/factorymethod/java8/FactoryMethodPatternV8exec.lambda$0:()Lsample/pettern/factory/bean/Vehicle;
		      #74 ()Lsample/pettern/factory/bean/Vehicle;
		  2: #66 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
		    Method arguments:
		      #75 ()Lsample/pettern/factory/bean/Vehicle;
		      #79 newinvokespecial sample/pettern/factory/bean/Bus."<init>":()V
		      #80 ()Lsample/pettern/factory/bean/Vehicle;
		InnerClasses:
		     public static final #86= #82 of #84; //Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
	 
	 
	 */
}
