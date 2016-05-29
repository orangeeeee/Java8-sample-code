package sample.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bean.Category;
import bean.MiddleCategory;
import test.data.CreateCategoryDataList;

public class NestListClassSearch {

	/**
	 * [パターン1]
	 * 検索キーを持ったListを渡し、
	 * Categoryデータが格納してあるListから検索キーListにマッチしたキーを持つ
	 * CategoryのListを返す。
	 */
	public void searchNestListKey() {

		CreateCategoryDataList createLogic = new CreateCategoryDataList();

		List<Category> cateList = createLogic.create();

		List<String> searchKeys = new ArrayList<>();
		searchKeys.add("A");
		searchKeys.add("B");
		//ここのAの部分を検索キーワードが詰まった配列にしたい。
		List<Category> temp = 
				cateList.stream().filter(cate -> searchKeys.contains(cate.getKey())).collect(Collectors.toList());
		
		temp.forEach(System.out::print);
	}
	/**
	 * [パターン2]
	 * パターン1の応用
	 * Categoryではなく、子供のMiddleCategoryのキーを元に検索し、
	 * MiddleカテゴリーのListを返す。
	 */
	public void searchNestListKey_2() {

		CreateCategoryDataList createLogic = new CreateCategoryDataList();

		List<Category> cateList = createLogic.create();

		List<String> searchKeys = new ArrayList<>();
		searchKeys.add("CG");
		searchKeys.add("CH");
		
		//ここのAの部分を検索キーワードが詰まった配列にしたい。
//		List<MiddleCategory> mCate =
//		cateList.stream().map(forEach(clist -> clist.getMiddleCategoryList().stream()
//				.(mCate -> searchKeys.contains(mCate.getKey())).collect(Collectors.toList()));
		
//		List<Category> temp = 
//				cateList.stream().filter(cate -> searchKeys.contains(
//						cate.getMiddleCategoryList().forEach(mlist -> mlist.getKey()))).collect(Collectors.toList());
		
//		temp.forEach(System.out::print);
	}
}
