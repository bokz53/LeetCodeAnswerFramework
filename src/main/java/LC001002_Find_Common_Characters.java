import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC001002_Find_Common_Characters extends BaseMain {

    /**
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
     * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：["bella","label","roller"]
     * 输出：["e","l","l"]
     * 示例 2：
     *
     * 输入：["cool","lock","cook"]
     * 输出：["c","o"]
     */

    public static void main(String[] args) {
        List<String[]> inputStrList = new ArrayList<>();

        inputStrList.add(new String[]{"bella","label","roller"});
        inputStrList.add(new String[]{"cool","lock","cook"});
        inputStrList.add(new String[]{"aerf"});

        LC001002_Find_Common_Characters lc = new LC001002_Find_Common_Characters();

        tryYourAnswer(lc::commonChars, inputStrList, Arrays::toString, String::valueOf);
    }


    // 每一个单词都会新建一个数组，这个单词里没出现过的字母，数量为0.
    // 那么再64行取min的时候，就会把前面出现过的覆盖掉，达成减枝
    public List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }




}
