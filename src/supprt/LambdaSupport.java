package supprt;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import bean.MiddleCategory;

public class LambdaSupport {
	// Functionを使用して、戻り値としてfilterの引数であるPredicateを返す。
	private final Function<String, Predicate<MiddleCategory>> mKeyMach = searchKey -> (mc -> mc.getKey()
			.equals(searchKey));

	public static Predicate<String> isNotEmpty() {
		return v -> !"".equals(v);
	}

	public static Function<String, String> toUpperCase() {
		return v -> v.toUpperCase();
	}

	public static Function<String, Predicate<String>> isEqual() {
		return t -> v -> v.equals(t);
	}

	public static <T> Optional<T> opt(T value) {
		return Optional.ofNullable(value);
	}
}
