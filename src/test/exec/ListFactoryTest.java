package test.exec;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import sample.logic.ListFactoryLogic;

public class ListFactoryTest {

	public static void main(String[] args) {

//		ListFactoryLogic logic = new ListFactoryLogic();
//		logic.excecute();
		  final List<String> friends = 
				    Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

		String lineSepaFriends = friends.stream().collect(Collectors.joining(""));
		System.out.println(lineSepaFriends);
	}

}
