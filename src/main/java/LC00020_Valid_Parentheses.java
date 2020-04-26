import base.BaseMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00020_Valid_Parentheses extends BaseMain {

    /**
     * 判读输入的括号是否有效（是否一一闭合），会有{}[]()3种括号混合输入。
     */

    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();

        inputStrList.add("(");
        inputStrList.add("((");
        inputStrList.add("(((((((((()");
        inputStrList.add("()");
        inputStrList.add("()[]{}");
        inputStrList.add("");
        inputStrList.add("(]");
        inputStrList.add("([)]");
        inputStrList.add("{[]}");

        LC00020_Valid_Parentheses lc = new LC00020_Valid_Parentheses();

        tryYourAnswer(lc::isValid, inputStrList);
    }


    public boolean isValid(String s) {

        if (s == null || "".equals(s)) {
            return true;
        }

        char MID_PARENT_LEFT = '[';
        char BIG_PARENT_LEFT = '{';
        char SMALL_PARENT_LEFT = '(';
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <= s.length() - 1; i++) {

            char c = chars[i];
            char need = '0';

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                if (stack.size() > s.length() - 1 - i) {
                    return false;
                }
            } else {
                Character pop;
                try {
                    pop = stack.pop();
                } catch (Exception e) {
                    return false;
                }

                switch (c) {
                    case ')': {
                        need = SMALL_PARENT_LEFT;
                        break;
                    }

                    case ']': {
                        need = MID_PARENT_LEFT;
                        break;
                    }

                    case '}': {
                        need = BIG_PARENT_LEFT;
                        break;
                    }
                    default: {
                        return false;
                    }
                }
                if (pop != need) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
