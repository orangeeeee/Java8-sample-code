package sample.logic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

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
	 * 別のクラスに変換して渡す。
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public Map<String, List<DummyMiddleCategory>> convertMap2() {
		
		CreateCategoryDataList createLogic = new CreateCategoryDataList();
		
		List<Category> cateList =  createLogic.create();
		
//		Map<String, List<DummyMiddleCategory>> res = cateList.stream().collect(
//				Collectors.toMap(　Category::getKey, k -> valueMapper1(k))
//			);
	
		return null;
	}
	
	//commonsのcopypropertyで良いかも。
	private List<DummyMiddleCategory> valueMapper1(Category category)  {
		
		List<DummyMiddleCategory> dList = new ArrayList<>();
		
		String categoryKey = category.getKey();
				
		List<MiddleCategory> mCategoryList = category.getMiddleCategoryList();
		
		for (MiddleCategory mCategory : mCategoryList) {
			
			DummyMiddleCategory dummy = new DummyMiddleCategory();
			//Exceptionの問題発生・・・どうやって呼びもとの例外処理を書こうかな・・・
//			BeanUtils.copyProperties(dummy, mCategory);
			dummy.setCategoryKey(categoryKey);
			dummy.setKey(mCategory.getKey());
			dummy.setName(mCategory.getName());
			dList.add(dummy);
		}
		
		return dList;
	}
	
}
