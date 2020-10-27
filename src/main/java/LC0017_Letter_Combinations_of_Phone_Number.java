import base.BaseMain;
import sun.java2d.pipe.OutlineTextRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 14:29
 */


public class LC0017_Letter_Combinations_of_Phone_Number extends BaseMain {


    /**
     * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射与电话按键相同
     * 注意 1 不对应任何字母。
     *
     *
     *
     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     */


    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();

        inputStrList.add("234");
        inputStrList.add("23");

        LC0017_Letter_Combinations_of_Phone_Number lc = new LC0017_Letter_Combinations_of_Phone_Number();
        tryYourAnswer(lc::letterCombinations, inputStrList, String::valueOf, i ->
                "\n" + "[ " +
                i.stream().reduce((s1, s2) -> s1.concat(", ").concat(s2)).orElse("") +
                " ]\n"
        );

    }


    private List<String> res = null;
    private static Map<Character, List<String>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        // 初始化
        this.res = new ArrayList<>();

        // 特判
        if (null == digits || "".equals(digits)) {
            return this.res;
        }

        this.dfs(digits, "");

        return this.res;
    }


    private void dfs(String digits, String preFix) {
        if (digits.length() <= 0) {

            this.res.add(preFix);
            return;
        }

        char c = digits.charAt(0);

        List<String> letters = map.get(c);
        for (String letter : letters) {
            this.dfs(digits.substring(1), preFix + letter);
        }
    }
}
