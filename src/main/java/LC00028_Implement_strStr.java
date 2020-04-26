import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00028_Implement_strStr extends BaseMain {

    /**
     * 自己实现一个String.indexOf()方法
     */

    public static void main(String[] args) {

        List<Pair<String, String>> inputStrList = new ArrayList<>();

        inputStrList.add(new Pair<>("hello", "l"));
        inputStrList.add(new Pair<>("mississippi", "issipi"));
        inputStrList.add(new Pair<>("mississippi", "issippi"));
        inputStrList.add(new Pair<>("aaaaa", "bba"));
        inputStrList.add(new Pair<>("", "ll"));
        inputStrList.add(new Pair<>("hello", ""));


        LC00028_Implement_strStr lc = new LC00028_Implement_strStr();

        tryYourAnswer(lc::strStr, inputStrList);
    }


    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        if (haystack.equals("") && needle.equals("")) {
            return 0;
        }

        if (!haystack.equals("") && needle.equals("")) {
            return 0;
        }

        if (haystack.equals("") && !needle.equals("")) {
            return 0;
        }

        int head = 0;
        int tail = -1;
        boolean isBreak = false;

        for (; head < haystack.length(); head++) {
            // 循环条件
            if (needle.charAt(0) != haystack.charAt(head)) {
                continue;
            }

            // needle都比剩余字符长了，不用再比了
            if (head > haystack.length() - needle.length()) {
                break;
            }

            tail = tail >= haystack.length() - 1 ? haystack.length() - 1 : head;
            for (int i = 0; i < needle.length(); i++) {
                if (haystack.charAt(tail + i) != needle.charAt(i)) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                return head;
            } else {
                isBreak = false;
            }
        }
        return -1;
    }
}
