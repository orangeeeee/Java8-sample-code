package supprt.test;

import java.util.Arrays;
import java.util.List;

import static supprt.LambdaSupport.*;

public class LamdbaSupportTest {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("a", "b", "", "", "");

		//関数を返す static methodを用意するとシンプルになる。
		list.stream().filter(isNotEmpty()).map(toUpperCase()).findFirst();
		//
		//
		// // テストデータ作成
		// List<Category> cateList = createLogic.create();
		//
		// final String searchKey = "BG";
		// Optional<MiddleCategory> middleCategory =
		// cateList.stream().filter(predicate)
	}

}
