import base.BaseMain;
import javafx.util.Pair;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00524_findLongestWord extends BaseMain {

    /**
     * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
     * 该字符串可以通过删除给定字符串的某些字符来得到。
     * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     *
     *
     * 示例 1:
     *
     * 输入:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     *
     * 输出:
     * "apple"
     *
     * ================================
     *
     * 示例 2:
     *
     * 输入:
     * s = "abpcplea", d = ["a","b","c"]
     *
     * 输出:
     * "a"
     */

    public static void main(String[] args) {


        List<Pair<String, List<String>>> inputStrList = new ArrayList<>();

        inputStrList.add(new Pair<>("mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq",
                Arrays.asList("ettphsiunoglotjlccurlre","ntgcykxhdfescxxypyew")));
        inputStrList.add(new Pair<>("bab", Arrays.asList("ba","ab","a","b")));
        inputStrList.add(new Pair<>("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        inputStrList.add(new Pair<>("abpcplea", Arrays.asList("a", "b", "c")));


        LC00524_findLongestWord lc = new LC00524_findLongestWord();
        tryYourAnswer(lc::findLongestWord, inputStrList);
    }

    public String findLongestWord(String s, List<String> d) {

        if ("".equals(s) || d.isEmpty()) {
            return "";
        }

        String result = "";
        for (String dic : d) {
            if (this.isDicInStr(dic, s)) {
                if (dic.length() > result.length() || (dic.length() == result.length() && dic.compareTo(result) < 0)) {
                    result = dic;
                }
            }
        }
        return result;
    }

    private boolean isDicInStr(String dic, String str) {

        if ("".equals(dic) || "".equals(str)) {
            return false;
        }

        int dicPointer = 0;
        int strPointer = 0;

        while (dicPointer < dic.length() && strPointer < str.length()) {

            if (str.charAt(strPointer) == dic.charAt(dicPointer)) {
                dicPointer++;
            }
            strPointer++;
        }

        return dicPointer >= dic.length();
    }

}
