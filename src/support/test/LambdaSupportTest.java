package support.test;

import static support.LambdaSupport.isEqual;
import static support.LambdaSupport.isNotEmpty;
import static support.LambdaSupport.toUpperCase;
import static support.LambdaSupport.opt;

import java.util.Arrays;
import java.util.List;

import bean.Category;
import test.data.CreateCategoryDataList;


public class LambdaSupportTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d", "");


        list.stream().filter(isNotEmpty()).map(toUpperCase()).findFirst();

        String code = "b";
        // 関数を返す static methodを用意するとシンプルになる。
        list.stream().filter(isEqual().apply(code)).map(toUpperCase()).findFirst();

        String abcString = null;
        System.out.println(//
                opt(abcString).map(toUpperCase()).orElse(null));

        Category category = null;//new Category();
        System.out.println(//
                opt(category).orElse(new Category()));
    }

    private static List<Category> createTestList() {

        // テストデータ作成
        CreateCategoryDataList createLogic = new CreateCategoryDataList();
        return createLogic.create();
    }
}
