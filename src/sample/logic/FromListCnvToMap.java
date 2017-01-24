package sample.logic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Category;
import bean.DummyMiddleCategory;
import bean.MiddleCategory;
import emum.MemberType;
import emum.OperationType;
import test.data.CreateCategoryDataList;

public class FromListCnvToMap {

	public Map<String, List<MiddleCategory>> convertMap1() {

		CreateCategoryDataList createLogic = new CreateCategoryDataList();

		List<Category> cateList = createLogic.create();

		// listのTOPにあるクラスの項目以外をkeyにする場合
		Map<String, List<MiddleCategory>> res = cateList.stream()
				.collect(Collectors.toMap(Category::getKey, k -> k.getMiddleCategoryList()));

		//並列処理
		Map<String, List<MiddleCategory>> pararel = cateList.stream()
				.collect(Collectors.toConcurrentMap(Category::getKey, k -> k.getMiddleCategoryList()));

		// listのTOPにあるクラスの項目をkeyにする場合
		Map<Object, List<Category>> resGroupBy = cateList.stream().collect(Collectors.groupingBy(k -> k.getKey()));
		
		//これでも同じ
		Map<String, String> oparationTypeMapLamdba = Stream.of(OperationType.values())
				.collect(Collectors.toMap(s -> s.getKey(), s -> s.getName()));

		// EnumをMapへ変換[ key,name] HashMap
		Map<String, String> oparationTypeMap = Stream.of(OperationType.values())
				.collect(Collectors.toMap(OperationType::getKey, OperationType::getName));
		
		Map<String, String> memberTypeMap = Stream.of(MemberType.values())
				.collect(Collectors.toMap(MemberType::name, mt -> mt.getKey()));

		// 中身を確認する countは終端処理を何かしらきさいしないとpeekが動作しないのでつけている。
		oparationTypeMap.entrySet().stream()
				.peek(opeMap -> System.out.println("key :" + opeMap.getKey() + ",value:" + opeMap.getValue())).count();

		System.out.println("---------------");
		// 中身を確認する
		memberTypeMap.entrySet().stream()
				.peek(opeMap -> System.out.println("key :" + opeMap.getKey() + ",value:" + opeMap.getValue())).count();

		return res;
	}

	/**
	 * 別のクラスに変換して渡す。
	 * 
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public Map<String, List<DummyMiddleCategory>> convertMap2() {

		CreateCategoryDataList createLogic = new CreateCategoryDataList();

		List<Category> cateList = createLogic.create();

		// Map<String, List<DummyMiddleCategory>> res =
		// cateList.stream().collect(
		// Collectors.toMap( Category::getKey, k -> valueMapper1(k))
		// );

		return null;
	}

	// commonsのcopypropertyで良いかも。
	private List<DummyMiddleCategory> valueMapper1(Category category) {

		List<DummyMiddleCategory> dList = new ArrayList<>();

		String categoryKey = category.getKey();

		List<MiddleCategory> mCategoryList = category.getMiddleCategoryList();

		for (MiddleCategory mCategory : mCategoryList) {

			DummyMiddleCategory dummy = new DummyMiddleCategory();
			// Exceptionの問題発生・・・どうやって呼びもとの例外処理を書こうかな・・・
			// BeanUtils.copyProperties(dummy, mCategory);
			dummy.setCategoryKey(categoryKey);
			dummy.setKey(mCategory.getKey());
			dummy.setName(mCategory.getName());
			dList.add(dummy);
		}

		return dList;
	}

}
