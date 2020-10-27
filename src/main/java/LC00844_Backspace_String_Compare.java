import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00844_Backspace_String_Compare extends BaseMain {

    /**
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     *
     * 注意：如果对空文本输入退格字符，文本继续为空。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * 示例 2：
     *
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * 示例 3：
     *
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     * 示例 4：
     *
     * 输入：S = "a#c", T = "b"
     * 输出：false
     * 解释：S 会变成 “c”，但 T 仍然是 “b”。
     *
     */

    public static void main(String[] args) {

        List<Pair<String, String>> inputStrList = new ArrayList<>();

        inputStrList.add(new Pair<>("", "a"));
        inputStrList.add(new Pair<>("#", ""));
        inputStrList.add(new Pair<>("#", "#"));
        inputStrList.add(new Pair<>("ab#c", "ad#c"));
        inputStrList.add(new Pair<>("ab##", "c#d#"));
        inputStrList.add(new Pair<>("a##c", "#a#c"));
        inputStrList.add(new Pair<>("a#c", "b"));

        LC00844_Backspace_String_Compare lc = new LC00844_Backspace_String_Compare();

        tryYourAnswer(lc::backspaceCompare, inputStrList);
    }

// 双指针 right为读取指针，left为写入指针。
    // 读到退格则写入指针回退，读取指针继续向前，这样后面的字符会覆盖前面的字符，也就起到了退格的效果。
    public boolean backspaceCompare(String S, String T) {

        int rightS = 0;
        int rightT = 0;
        int leftS = 0;
        int leftT = 0;


        char[] sChar = S.toCharArray();
        char[] tChar = T.toCharArray();

        while (rightS < S.length() || rightT < T.length()) {
            while (rightS < S.length() && sChar[rightS] == '#') {
                leftS = Math.max(leftS - 1, 0);
                rightS = Math.min(rightS+1, S.length());
            }

            while (rightT < T.length() && tChar[rightT] == '#') {
                leftT = Math.max(leftT-1, 0);
                rightT = Math.min(rightT+1, T.length());
            }


            // copy
            if (rightS < S.length()) {
                sChar[leftS] = sChar[rightS];
                leftS++;
            }
            rightS++;


            if (rightT < T.length()) {
                tChar[leftT] = tChar[rightT];
                leftT++;
            }
            rightT++;
            // move pointer
        }

        if (leftS != leftT) {
            return false;
        }

        return this.compareChar(sChar, tChar, leftS);
    }

    private boolean compareChar(char[] c1, char[] c2, int destination) {
        int insideP = 0;
        while (insideP < destination) {
            if (c1[insideP] != c2[insideP]) {
                return false;
            }
            insideP++;
        }
        return true;
    }

}
