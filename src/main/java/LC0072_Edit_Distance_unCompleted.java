import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0072_Edit_Distance_unCompleted extends BaseMain {

    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *  
     *
     * 示例 1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     *
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     *
     *
     * 这题的关键在于，想清楚每个操作的本质。
     * 每做一次操作，距离+1，且需要处理的字符数-1（根据操作的不同，可以给word1减或者给word2减）
     */

    public static void main(String[] args) {

        List<Pair<String, String>> inputStrList = new ArrayList<>();

//        inputStrList.add(new Pair<>("" ,""));
        inputStrList.add(new Pair<>("horse" ,"ros"));
        inputStrList.add(new Pair<>("intention" ,"execution"));

        LC0072_Edit_Distance_unCompleted lc = new LC0072_Edit_Distance_unCompleted();

        tryYourAnswer(lc::minDistance, inputStrList);
    }


    public int minDistance(String word1, String word2) {

        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int i = s1.length-1;
        int j = s2.length-1;

        return this.dp(s1,s2,i,j);
    }


    private int dp(char[] s1, char[] s2, int i, int j) {

        if (i == -1) {
            return j+1;
        }

        if (j == -1) {
            return i+1;
        }

        if (s1[i] == s2[j]) {
            return dp(s1, s2, i-1, j-1);
        } else {
            return this.getMin(
                    this.dp(s1,s2,i,j-1)+1,
                    this.dp(s1,s2,i-1,j)+1,
                    this.dp(s1,s2,i-1,j-1)+1
            );
        }

    }

    private int getMin(int i1, int i2, int i3) {
        return Math.min(Math.min(i1,i2), i3);
    }

}
