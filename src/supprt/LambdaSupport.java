package supprt;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaSupport {

	public static Predicate<String> isNotEmpty() {
		return v -> !"".equals(v);
	}


	public static Function<String, String> toUpperCase() {
		return v -> v.toUpperCase();
	}
}
