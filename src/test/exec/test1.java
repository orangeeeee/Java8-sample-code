package test.exec;

import java.util.List;
import java.util.Map;

import bean.DummyMiddleCategory;
import bean.MiddleCategory;
import sample.logic.FromListCnvToMap;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		FromListCnvToMap logic = new FromListCnvToMap();
		
		Map<String, List<MiddleCategory>> map1 = logic.convertMap1();
		
		Map<String, List<DummyMiddleCategory>>  map2 = logic.convertMap2();
		
		System.out.println(map1);
		System.out.println(map2);
		
	}

}
