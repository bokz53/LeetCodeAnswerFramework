import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00336_Palindrome_Pairs extends BaseMain {

    /**
     * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：["abcd","dcba","lls","s","sssll"]
     * 输出：[[0,1],[1,0],[3,2],[2,4]]
     * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
     * 示例 2：
     *
     * 输入：["bat","tab","cat"]
     * 输出：[[0,1],[1,0]]
     * 解释：可拼接成的回文串为 ["battab","tabbat"]
     *
     */

    public static void main(String[] args) {

        List<String[]> inputIntList = new ArrayList<>();

        inputIntList.add(new String[]{"a","abc","aba",""});
        inputIntList.add(new String[]{"abcd","dcba","lls","s","sssll"});
        inputIntList.add(new String[]{"bat","tab","cat"});
        inputIntList.add(new String[]{"a",""});

        LC00336_Palindrome_Pairs lc = new LC00336_Palindrome_Pairs();

        tryYourAnswer(lc::palindromePairs, inputIntList);
    }

    ArrayList<int[]> maybe;

    public List<List<Integer>> palindromePairs(String[] words) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        maybe = new ArrayList<>();

        // 可能性检测
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ("".equals(words[i])) {

                    if (this.isPalindrome(words[j])) {
                        result.add(Arrays.asList(i, j));
                        result.add(Arrays.asList(j, i));
                    } else {
                        continue;
                    }

                } else if (("".equals(words[j]) && this.isPalindrome(words[i]))) {
                    if (this.isPalindrome(words[i])) {
                        result.add(Arrays.asList(i, j));
                        result.add(Arrays.asList(j, i));
                    } else {
                        continue;
                    }
                } else {
                    if (this.simpleCheck(words[i], words[j])) {
                        maybe.add(new int[]{i, j});
                    }
                    if (this.simpleCheck(words[j], words[i])) {
                        maybe.add(new int[]{j, i});
                    }
                }
            }
        }

        for (int[] ints : maybe) {
            if (this.isPalindrome(words[ints[0]] + words[ints[1]])) {
                result.add(Arrays.asList(ints[0], ints[1]));
            }
        }
        return result;
    }

    private boolean simpleCheck(String s1 , String s2) {
        return s1.charAt(0) == s2.charAt(s2.length()-1);
    }

    private boolean isPalindrome(String str) {

        char[] chars = str.toCharArray();
        int charsLength = chars.length;
        boolean result = false;

        for (int i = 0; i <= chars.length / 2; i++) {
            if (!(chars[i] == chars[charsLength - 1 - i])) {
                break;
            }
            if ((i == charsLength - 1 - i) || ((i + 1) == charsLength - 1 - i)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
