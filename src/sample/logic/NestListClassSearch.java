package sample.logic;

import java.util.ArrayList;
import java.util.Arrays;
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

	private final Function<String, Predicate<MiddleCategory>> mKeyMach 
		= searchKey -> mc -> mc.getKey().equals(searchKey);

	/**
	 * ネストクラスのList内検索のサンプル。
	 * 
	 * @param searchKey
	 * @param middleCategoryList
	 */
	public void searchMacthConditon(String searchKey, List<MiddleCategory> middleCategoryList) {
		
		Optional<MiddleCategory> middleCategory  
			= middleCategoryList.parallelStream().filter(mKeyMach.apply(searchKey)).findFirst();

		
		middleCategory.get();
		// middleCategoryList.stream().filter(mc ->
		// mc.getKey().equals(searchKey)).findFirst();

		// ---- FIXME NG 最初のfindFirstの結果がNoSuchElementExceptionの場合に落ちる。
		// ----------------------
		/**
		 * // 普通に書く middleCategoryList.stream().filter(mc ->
		 * mc.getKey().equals(searchKey)).findFirst().get().getLastCategoryList(
		 * ) .stream().filter(lc -> this.isConditin(lc)).findFirst();
		 * 
		 * // // 引数を渡しているだけなのでメソッド参照に書き換える 159
		 * middleCategoryList.stream().filter(mc ->
		 * mc.getKey().equals(searchKey)).findFirst().get().getLastCategoryList(
		 * ) .stream().filter(this::isConditin).findFirst();
		 * 
		 * middleCategoryList.stream().filter(mKeyMach.apply(searchKey)).
		 * findFirst().get().getLastCategoryList().stream()
		 * .filter(this::isConditin).findFirst();
		 * 
		 * 
		 * //絶対にデータが存在しているならこれでいい。存在していないと、.get()で落ちる。 Optional
		 * <LastCategory> result = Optional
		 * .ofNullable(this.getLastCategoryParallel2(middleCategoryList,
		 * searchKey).get().getLastCategoryList()) .orElse(new ArrayList
		 * <LastCategory>()).parallelStream().filter(this::isConditin).findAny()
		 * ;
		 */

		// --------------------------------------------------------------------------

		// // // LastCategoryの抽出を別メソッド化
		// this.getLastCategory(middleCategoryList,
		// searchKey).parallelStream().filter(this::isConditin).findFirst();
		//
		// // parallel streamに変更
		Optional<LastCategory> result = this.getLastCategoryParallel3(middleCategoryList, searchKey).parallelStream()
				.peek(e -> System.out.println("log :" + e.toString())).filter(this::isConditin).findAny();

		// これでも書けるけど長い
		Optional<LastCategory> result2 = Optional
				.ofNullable(this.getLastCategoryParallel2(middleCategoryList, searchKey).orElse(new MiddleCategory())
						.getLastCategoryList())
				.orElse(new ArrayList<LastCategory>()).parallelStream().filter(this::isConditin).findAny();

		if (!result.isPresent()) {
			System.out.println("LastCategory is empty");
		}

		System.out.println("end");
	}

	/**
	 * 並列処理
	 * 
	 * @param middleCategoryList
	 * @param searchKey
	 * @return List<LastCategory>
	 */
	private List<LastCategory> getLastCategoryParallel(List<MiddleCategory> middleCategoryList, String searchKey) {

		return Optional.ofNullable(middleCategoryList.parallelStream().filter(mKeyMach.apply(searchKey)).findFirst()
				.orElse(new MiddleCategory()).getLastCategoryList()).orElse(new ArrayList<LastCategory>());
	}

	/**
	 * 呼びもとにてNullAbleを使用する場合
	 * 
	 * @param middleCategoryList
	 * @param searchKey
	 * @return Optional<MiddleCategory>
	 */
	private Optional<MiddleCategory> getLastCategoryParallel2(List<MiddleCategory> middleCategoryList,
			String searchKey) {
		return middleCategoryList.parallelStream().filter(mKeyMach.apply(searchKey)).findFirst();
	}

	/**
	 * データが存在しないケースがある場合
	 * 
	 * @param middleCategoryList
	 * @param searchKey
	 * @return
	 */
	private List<LastCategory> getLastCategoryParallel3(List<MiddleCategory> middleCategoryList, String searchKey) {

		Optional<MiddleCategory> optMiddleCategory = middleCategoryList.parallelStream()
				.filter(mKeyMach.apply(searchKey)).findFirst();

		return optMiddleCategory.isPresent() ? optMiddleCategory.get().getLastCategoryList()
				: new ArrayList<LastCategory>();
	}

	/**
	 * 直列処理 絶対にデータが存在する場合
	 * 
	 * @param middleCategoryList
	 * @param searchKey
	 * @return List<LastCategory>
	 */
	private List<LastCategory> getLastCategory(List<MiddleCategory> middleCategoryList, String searchKey) {

		return Optional.ofNullable(middleCategoryList.parallelStream().filter(mKeyMach.apply(searchKey)).findFirst()
				.get().getLastCategoryList()).orElse(new ArrayList<LastCategory>());
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
