package sample.logic;

import java.util.List;
import java.util.Optional;

import bean.Category;
import emum.OperationType;
import exception.SystemException;
import test.data.CreateCategoryDataList;

public class OptionalSample {

	private static List<Category> cateList;

	static {

		CreateCategoryDataList createLogic = new CreateCategoryDataList();

		cateList = createLogic.create();
	}

	public void exeduteT() {

		try {

			usage1();

		} catch (SystemException e) {
			System.out.println("SystemException");
		}

	}

	/**
	 * とりあえず作ってみたけど、この使い方どうなんだろう。
	 */
	private void usage1() {

		Optional<String> optType = getOperationType("new", "");

		optType.orElseThrow(SystemException::new);

		if (optType.isPresent()) {

			System.out.println(optType.get());

			// get使って、equalsって・・・
			if (optType.get().equals(OperationType.NEW.getKey())) {

				// execute insert;
			} else if (optType.get().equals(OperationType.CHANGE.getKey())) {
				// execute update
			} else if (optType.get().equals(OperationType.DELETE.getKey())) {
				// execute delete
			} else {
				System.out.println("inner isPresent() else");
			}
		}
	}

	/**
	 * この使い方は良い例だと思う。 Level:Good
	 * http://www.nurkiewicz.com/2013/08/optional-in-java-8-cheat-sheet.html
	 */
	private void usage2() {
		Optional<String> opt = Optional.of("");
		int len = opt.map(String::length).orElseGet(() -> slowDefault());
	}

	private int slowDefault() {
		return -999;
	}

	/**
	 * nullを返す可能性がある場合のサンプル。
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	private Optional<String> getOperationType(String param1, String param2) {

		// 空だとダメ
		String result = null;

		if (!param1.isEmpty()) {

			if ("new".equals(param1)) {
				result = OperationType.NEW.getKey();
			}

		} else if (!param2.isEmpty()) {

			if ("change".equals(param2)) {
				result = OperationType.CHANGE.getKey();
			} else if ("delete".equals(param2)) {

				result = OperationType.DELETE.getKey();
			}
		}

		return Optional.ofNullable(result);
	}

}
