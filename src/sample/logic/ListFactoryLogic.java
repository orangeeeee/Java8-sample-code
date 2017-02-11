package sample.logic;

import java.util.Arrays;
import java.util.List;

public class ListFactoryLogic {

	public void excecute() {

		ObjectListFactory factory = new ObjectListFactory();
//		factory.add("start");
//		factory.add(null);
//		factory.add(LocalDateTime.now());
//		factory.add("end");
//
//		List<Object> resultList = factory.get();
//		resultList.stream().forEach(obj -> System.out.println(obj.toString()));

		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		factory.addList(friends);
		factory.get().stream().forEach(obj -> System.out.println(obj.toString()));
		
	}
}
