import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC076_Minimum_Window_Substring extends BaseMain {

    /**
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * 说明：
     * <p>
     * 如果 S 中不存这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     */

    public static void main(String[] args) {

        List<Pair<String, String>> inputStrList = new ArrayList<>();

        inputStrList.add(new Pair<>("ADOBECODEBANC", "ABC"));
        inputStrList.add(new Pair<>("a", "aa"));
        inputStrList.add(new Pair<>("a", "a"));


        LC076_Minimum_Window_Substring lc = new LC076_Minimum_Window_Substring();

        tryYourAnswer(lc::minWindow, inputStrList);
    }


    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> needs = new HashMap<>();
        int left = 0;
        int right = 0;
        boolean flag = false;

        String temp = "";

        String resStr = s;

        for (int i = 0; i < t.length(); i++) {
            // 遍历目标串，统计所有字符所需要的次数
            needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right <= s.length() - 1) {

            while (isExistInStr(needs, s.substring(left, right + 1))) {
                resStr = this.minWindowStr(s.substring(left, right + 1), resStr);
                left++;
                flag = true;
                //                temp = s.substring(left, right+1);
            }
            right++;
            //            temp = s.substring(left, right+1);
        }

        return !flag ? "" : resStr;
    }


    public boolean isExistInStr(Map<Character, Integer> needs, String field) {
        Map<Character, Integer> copy = new HashMap<>(needs);
        char[] chars = field.toCharArray();
        for (int i = 0; i < field.length(); i++) {
            // 遍历t，统计所有字符所需要的次数
            copy.replace(chars[i], copy.getOrDefault(chars[i], 0) - 1);
        }
        if (copy.values().stream().noneMatch(i -> i > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public String minWindowStr(String p1, String p2) {
        return p1.length() < p2.length() ? p1 : p2;
    }
}
