package sample.logic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Category;
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

		// 並列処理
		Map<String, List<MiddleCategory>> pararel = cateList.stream()
				.collect(Collectors.toConcurrentMap(Category::getKey, k -> k.getMiddleCategoryList()));

		// listのTOPにあるクラスの項目をkeyにする場合
		Map<Object, List<Category>> resGroupBy = cateList.stream().collect(Collectors.groupingBy(k -> k.getKey()));

		// これでも同じ
		Map<String, String> oparationTypeMapLamdba = Stream.of(OperationType.values())
				.collect(Collectors.toMap(s -> s.getKey(), s -> s.getName()));

		// EnumをMapへ変換[ key,name] HashMap
		Map<String, String> oparationTypeMap = Stream.of(OperationType.values())
				.collect(Collectors.toMap(OperationType::getKey, OperationType::getName));

		Map<String, String> memberTypeMap = Stream.of(MemberType.values())
				.collect(Collectors.toMap(MemberType::name, mt -> mt.getKey()));

		// 中身を確認する countは終端処理を何かしらきさいしないとpeekが動作しないのでつけている。
		oparationTypeMap.entrySet().stream()
				.forEach(opeMap -> System.out.println("key :" + opeMap.getKey() + ",value:" + opeMap.getValue()));

		System.out.println("---------------");
		// 中身を確認する
		memberTypeMap.entrySet().stream()
				.forEach(opeMap -> System.out.println("key :" + opeMap.getKey() + ",value:" + opeMap.getValue()));

		return res;
	}
}
