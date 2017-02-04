package test.exec;

import java.util.List;

import bean.Category;
import bean.MiddleCategory;
import sample.logic.NestListClassSearch;
import test.data.CreateCategoryDataList;

public class NestListClassSearchTest {

	public static void main(String[] args) {

		CreateCategoryDataList createLogic = new CreateCategoryDataList();

		List<Category> cateList = createLogic.create();
		List<MiddleCategory> middleCategoryList = cateList.get(0).getMiddleCategoryList();
		
		NestListClassSearch logic = new NestListClassSearch();
		logic.searchMacthConditon("AG",middleCategoryList);
		
		//flatMapにてネストクラスが持つList<MiddleCategory>を検索する。
		logic.searchByFlatMap();
	}
}
