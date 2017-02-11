package sample.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bean.Category;
import bean.DummyMiddleCategory;

public class DifferentListConvert extends AbstractTestLogic {

	public void execute() {
		List<Category> cateList = createTestList();
		List<Category> originList = new ArrayList<>();
		
		addExistingList(cateList, originList, "K");
		addExistingList2(cateList, originList, "B");
		
		originList.stream().forEach(c -> System.out.println(c.toString()));
		
	}

	private List<DummyMiddleCategory> sample1() {

		List<Category> cateList = createTestList();

		return cateList.stream().map(category -> convertDummyMiddleCategory(category))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private List<DummyMiddleCategory> sample2() {

		List<Category> cateList = createTestList();

		return cateList.stream().map(category -> convertDummyMiddleCategory(category)).collect(Collectors.toList());
	}

	private void addExistingList(List<Category> cateList, List<Category> originList, String seachKey) {

		cateList.stream().filter(category -> category.getKey().equals(seachKey))
				.collect(Collectors.toCollection(() -> originList));
	}

	private void addExistingList2(List<Category> cateList, List<Category> originList, String seachKey) {
		cateList.stream().filter(category -> category.getKey().equals(seachKey)).forEach(originList::add);
	}

	private DummyMiddleCategory convertDummyMiddleCategory(Category category) {
		// 変換処理
		return new DummyMiddleCategory();
	}

}
