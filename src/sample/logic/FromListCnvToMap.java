package sample.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import bean.Category;
import bean.DummyMiddleCategory;
import bean.MiddleCategory;
import test.data.CreateCategoryDataList;

public class FromListCnvToMap {

	
	public Map<String, List<MiddleCategory>> convertMap1() {
		
		CreateCategoryDataList createLogic = new CreateCategoryDataList();
		
		List<Category> cateList =  createLogic.create();
		
		Map<String, List<MiddleCategory>> res = cateList.stream().collect(
				Collectors.toMap(Category::getKey, k -> k.getMiddleCategoryList())
			);
		
		return res;
	}
	
	/**
	 * •Ê‚ÌƒNƒ‰ƒX‚É•ÏŠ·‚µ‚Ä“n‚·B
	 * @return
	 */
	public Map<String, List<DummyMiddleCategory>> convertMap2() {
		
		CreateCategoryDataList createLogic = new CreateCategoryDataList();
		
		List<Category> cateList =  createLogic.create();
		
		Map<String, List<DummyMiddleCategory>> res = cateList.stream().collect(
				Collectors.toMap(Category::getKey, k -> valueMapper1(k))
			);
		
		return res;
	}
	private List<DummyMiddleCategory> valueMapper1(Category category) {
		
		List<DummyMiddleCategory> dList = new ArrayList<>();
		
		String categoryKey = category.getKey();
				
		List<MiddleCategory> mCategoryList = category.getMiddleCategoryList();
		
		for (MiddleCategory mCategory : mCategoryList) {
			
			DummyMiddleCategory dummy = new DummyMiddleCategory();
			dummy.setCategoryKey(categoryKey);
			dummy.setKey(mCategory.getKey());
			dummy.setName(mCategory.getName());
			dList.add(dummy);
		}
		
		return dList;
	}
	
}
