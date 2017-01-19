package sample.logic;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import emum.MemberType;
import emum.kubun;
import exception.SystemException;

public class OtherObjectStream {
	

	public void test() {
		
		String searchKey = "2";
		
		MemberType memberType =  this.get(MemberType.class, searchKey).orElseThrow(SystemException::new);
		MemberType memberType2 =  this.get(MemberType.class, searchKey).orElse(null);

		//Array.asList
		Arrays.asList(MemberType.values()).stream().filter(mt -> mt.getKey().equals(searchKey)).findFirst();
		//Array.asList ⇨ Stream.of
		Stream.of(MemberType.values()).filter(mt -> mt.getKey().equals(searchKey)).findFirst();
		
	}
	
	@SuppressWarnings("rawtypes")
	private <E extends Enum> Optional<E> get(Class<E> clazz, String keyValue) {
		
		return Stream.of(clazz.getEnumConstants()).filter(k -> k instanceof Enum && ((kubun) k).getKey().equals(keyValue)).findFirst();
	
	}

}
