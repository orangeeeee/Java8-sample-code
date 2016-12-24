package sample.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Category;
import bean.LastCategory;
import bean.MiddleCategory;
import test.data.CreateCategoryDataList;

public class NestListClassSearch {

	/**
	 * [パターン1] 検索キーを持ったListを渡し、 Categoryデータが格納してあるListから検索キーListにマッチしたキーを持つ
	 * CategoryのListを返す。
	 */
	public void searchNestListKey() {

		CreateCategoryDataList createLogic = new CreateCategoryDataList();

		List<Category> cateList = createLogic.create();

		List<String> searchKeys = new ArrayList<>();
		searchKeys.add("A");
		searchKeys.add("B");
		// ここのAの部分を検索キーワードが詰まった配列にしたい。
		List<Category> temp = cateList.stream().filter(cate -> searchKeys.contains(cate.getKey()))
				.collect(Collectors.toList());

		temp.forEach(System.out::print);

		// 条件に合うものが存在するか確認する。

	}

	private final Function<String, Predicate<MiddleCategory>> mKeyMach = searchKey -> mc -> mc.getKey()
			.equals(searchKey);

	public void searchMacthConditon(String searchKey, List<MiddleCategory> middleCategoryList ) {

		// 167
		middleCategoryList.stream().filter(mc -> mc.getKey().equals(searchKey)).findFirst().get().getLastCategoryList()
				.stream().filter(lc -> this.isConditin(lc)).findFirst();

		// 引数を渡しているだけなのでメソッド参照に書き換えた 159
		middleCategoryList.stream().filter(mc -> mc.getKey().equals(searchKey)).findFirst().get().getLastCategoryList()
				.stream().filter(this::isConditin).findFirst();

		// 条件式を関数化 153
		middleCategoryList.stream().filter(mKeyMach.apply(searchKey)).findFirst().get().getLastCategoryList().stream()
				.filter(this::isConditin).findFirst();

		// LastCategoryの抽出を別メソッド化
		this.getLastCategory(middleCategoryList, searchKey).parallelStream().filter(this::isConditin).findFirst();

		// 並列処理へ変更
		Optional<LastCategory> result = this.getLastCategoryParallel(middleCategoryList, searchKey).parallelStream()
				.filter(this::isConditin).findAny();

		if (!result.isPresent()) {
			System.out.println("LastCategory is empty");
		}

		System.out.println("end");
	}

	/**
	 * 直列処理
	 * @param middleCategoryList
	 * @param searchKey
	 * @return
	 */
	private List<LastCategory> getLastCategory(List<MiddleCategory> middleCategoryList, String searchKey) {
		return middleCategoryList.stream().filter(mKeyMach.apply(searchKey)).findFirst().get().getLastCategoryList();
	}
	
	/**
	 * 並列処理
	 * @param middleCategoryList
	 * @param searchKey
	 * @return
	 */
	private List<LastCategory> getLastCategoryParallel(List<MiddleCategory> middleCategoryList, String searchKey) {
		return middleCategoryList.parallelStream().filter(mKeyMach.apply(searchKey)).findAny().get().getLastCategoryList();
	}

	private boolean isConditin(LastCategory lastCategory) {

		// 条件式を記載する。
		
		return true;
	}

	/**
	 * [パターン2] パターン1の応用 Categoryではなく、子供のMiddleCategoryのキーを元に検索し、
	 * MiddleカテゴリーのListを返す。
	 */
	public void searchNestListKey_2() {

		CreateCategoryDataList createLogic = new CreateCategoryDataList();

		List<Category> cateList = createLogic.create();

		List<String> searchKeys = new ArrayList<>();
		searchKeys.add("CG");
		searchKeys.add("CH");

		// ここのAの部分を検索キーワードが詰まった配列にしたい。
		// List<MiddleCategory> mCate =
		// cateList.stream().map(forEach(clist ->
		// clist.getMiddleCategoryList().stream()
		// .(mCate ->
		// searchKeys.contains(mCate.getKey())).collect(Collectors.toList()));

		// List<Category> temp =
		// cateList.stream().filter(cate -> searchKeys.contains(
		// cate.getMiddleCategoryList().forEach(mlist ->
		// mlist.getKey()))).collect(Collectors.toList());

		// temp.forEach(System.out::print);
	}
}
