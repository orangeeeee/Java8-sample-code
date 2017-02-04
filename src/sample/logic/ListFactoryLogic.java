package sample.logic;

import java.time.LocalDateTime;
import java.util.List;

public class ListFactoryLogic {

	public void excecute() {
		
		ObjectListFactory factory = new ObjectListFactory();
		factory.add("start");
		factory.add(null);
		factory.add(LocalDateTime.now());
		factory.add("end");
		
		List<Object> resultList = factory.get();
		resultList.stream().forEach(obj -> System.out.println(obj.toString()));
	}
}
