package sample.logic;

import java.util.List;

import bean.Category;
import test.data.CreateCategoryDataList;

public class AbstractTestLogic {

	protected List<Category> createTestList() {

		// テストデータ作成
		CreateCategoryDataList createLogic = new CreateCategoryDataList();
		return createLogic.create();
	}

}
