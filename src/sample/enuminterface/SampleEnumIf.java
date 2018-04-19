package sample.enuminterface;

import java.util.Optional;
import java.util.stream.Stream;

import emum.kubun;

public interface SampleEnumIf<E extends Enum<E>> {
	   /**　コード値を返却する　*/
    String getCode();

	static <E extends Enum<E>> Optional<E> ofCode(Class<E> clazz, String keyValue) {

		return Stream.of(clazz.getEnumConstants())
				.filter(k -> k instanceof kubun && ((kubun) k)
						.getKey().equals(keyValue)).findFirst();
	}

}
