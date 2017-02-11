package sample.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Category;
import bean.Paging;
import test.data.CreateCategoryDataList;

public class LimitOffSet {

	public static Paging paging;

	static {
		// Pagingの初期値設定
		paging = new Paging();
		paging.setCurrentPage(2);
		paging.setTotalCount(15);
		paging.setTotalPage(3);
	}

	public void execute() {

		List<Category> cateList = this.getList();

		Stream<String> namesStream = Arrays.asList("hoge hoge", "foo bar", "naoki", "kishida").stream();
		System.out.println(namesStream.anyMatch(s -> s.length() > 7)); // true
		System.out.println(namesStream.noneMatch(s -> s.length() > 7)); // true

		// 次ページ分のリストを取得
		List<Category> nextCateList = getNextPageList(cateList);
		// 前ページ分のリストを取得
		List<Category> prevCateList = getPrevPageList(cateList);

		// 取得リストの中身を確認
		nextCateList.stream().forEach(nl -> System.out.println(nl.getKey()));
		System.out.println("-----prev------");
		prevCateList.stream().forEach(pl -> System.out.println(pl.getKey()));
	}

	/**
	 * 次ページのリストを取得
	 * @param cateList
	 * @return resultList
	 */
	private List<Category> getNextPageList(List<Category> cateList) {

		final int nextPageNumber = paging.getCurrentPage() + 1;
		final int limit = nextPageNumber * Paging.PAGE_LIMIT_NUMBER;
		final int offset = limit - Paging.PAGE_LIMIT_NUMBER + 1;
		List<Category> resultList = getTargetList(cateList, offset, limit);
		// paging.setCurrentPage(paging.getCurrentPage() + 1);
		return resultList;
	}
	
	/**
	 * 前ページのリストを取得
	 * @param cateList
	 * @return resultList
	 */
	private List<Category> getPrevPageList(List<Category> cateList) {

		int nextPageNumber = paging.getCurrentPage() - 1;
		int limit = nextPageNumber * Paging.PAGE_LIMIT_NUMBER;
		int offset = limit - Paging.PAGE_LIMIT_NUMBER;
		List<Category> resultList = getTargetList(cateList, offset, limit);
		// paging.setCurrentPage(paging.getCurrentPage() - 1);
		return resultList;
	}

	/**
	 * 指定された開始と終了位置のリストを取り出す。
	 * 
	 * @param cateList
	 * @param offset
	 * @param limit
	 * @return targetList
	 */
	private List<Category> getTargetList(List<Category> cateList, final int offset, final int limit) {

		return cateList.stream().skip(offset).limit(limit).
				collect(Collectors.toCollection(ArrayList::new));
	}

	/**
	 * テストデータ用のリストを取得
	 * 
	 * @return テスト用リスト
	 */
	private List<Category> getList() {
		CreateCategoryDataList createLogic = new CreateCategoryDataList();
		return createLogic.create();
	}
}