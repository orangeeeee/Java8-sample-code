package sample.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import bean.Category;
import bean.LastCategory;
import bean.MiddleCategory;
import test.data.CreateCategoryDataList;

public class NestListClassSearch extends AbstractTestLogic {

	/**
	 * flatMapを使用し、ネストしたListをstreamで検索する。
	 */
	public void searchByFlatMap() {
		// テストデータ作成
		List<Category> cateList = createTestList();

		cateList.stream().filter(c -> true).findFirst().get()
			.getMiddleCategoryList().stream().filter(m -> true)
				.findFirst().get();

		final String searchKey = "BG";
		Optional<MiddleCategory> middleCategory = cateList.stream()
				.flatMap(c -> c.getMiddleCategoryList().stream())
				.filter(mc -> mc.getKey().equals(searchKey)).findFirst();

		if (middleCategory.isPresent()) {
			System.out.println("success get middleCategory:");
			System.out.println(middleCategory.toString());
		}

		// もう一段階ネストしたクラスのリストを検索する。
		final String searchKeyForLast = "BGK";
		Optional<LastCategory> lastCategory = cateList.stream()
				.flatMap(c -> c.getMiddleCategoryList().stream())
				.flatMap(mc -> mc.getLastCategoryList().stream())
				.filter(lc -> lc.getKey().equals(searchKeyForLast))
				.findFirst();
		
		// パフォーマンスを意識するとこうなることもある。
		cateList.stream().flatMap(c -> c.getMiddleCategoryList().stream())
				.filter(mc -> mc.getKey().equals("BG"))
				.flatMap(mc -> mc.getLastCategoryList().stream())
				.filter(lc -> lc.getKey().equals(searchKeyForLast))
				.findFirst();

		if (lastCategory.isPresent()) {
			System.out.println("success get lastCategory:");
			System.out.println(lastCategory.toString());
		}
	}

	// Functionを使用して、戻り値としてfilterの引数であるPredicateを返す。
	private final Function<String, Predicate<MiddleCategory>> mKeyMach = searchKey -> (mc -> mc.getKey()
			.equals(searchKey));

	/**
	 * 一番上のクラスから順にfilterで絞る。
	 * 
	 * @param searchKey
	 * @param middleCategoryList
	 */
	public void searchMacthConditon(String searchKey, List<MiddleCategory> middleCategoryList) {

		Optional<MiddleCategory> optMiddleCategory = middleCategoryList.stream()
				.filter(mc -> mc.getKey().equals(searchKey)).findFirst();

		MiddleCategory middleCategory = optMiddleCategory.orElse(null);

		middleCategoryList.stream().filter(mKeyMach.apply(searchKey)).findFirst();

		optMiddleCategory.get();
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
}
