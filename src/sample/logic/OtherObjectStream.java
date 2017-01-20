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

		// Array.asList
		Arrays.asList(MemberType.values()).stream().filter(mt -> mt.getKey().equals(searchKey)).findFirst();
		// Array.asList ⇨ Stream.of
		Stream.of(MemberType.values()).filter(mt -> mt.getKey().equals(searchKey)).findFirst();

		MemberType memberType = this.get(MemberType.class, searchKey).orElseThrow(SystemException::new);
		MemberType memberType2 = this.get(MemberType.class, searchKey).orElse(null);

		String name = this.getName(MemberType.class, searchKey);
	}

	/**
	 * 指定のキーに対するKubunをimplementsしているenumの型を返す。
	 * 
	 * @param clazz
	 * @param keyValue
	 * @return Optional<E> 区分値の型
	 */
	private <E extends Enum<E>> Optional<E> get(Class<E> clazz, String keyValue) {

		return Stream.of(clazz.getEnumConstants())
				.filter(k -> k instanceof kubun && ((kubun) k).getKey().equals(keyValue)).findFirst();
	}
	//nameを返す。
	private <E extends Enum<E>> String getName(Class<E> clazz, String keyValue) {

		Optional<E> result =  Stream.of(clazz.getEnumConstants())
				.filter(k -> k instanceof kubun && ((kubun) k).getKey().equals(keyValue)).findFirst();
		return result.isPresent() ? null : result.get().name();
	}

}
