import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0022_Generate_parentheses extends BaseMain {

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */

    public static void main(String[] args) {

        List<Integer> inputIntList = new ArrayList<>();

        inputIntList.add(3);
        //        inputIntList.add(4);
        inputIntList.add(5);

        LC0022_Generate_parentheses lc = new LC0022_Generate_parentheses();

        tryYourAnswer(lc::generateParenthesis, inputIntList, i -> {
            StringBuilder sb = new StringBuilder();
            for (String item : i) {
                sb.append(item).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        });
    }


    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        List<String> result = new ArrayList<>();

        this.dfs("", n, n, result);

        return result;
    }

    private void dfs(String curString, int leftRemain, int rightRemain, List<String> resultList) {
        if (leftRemain == 0 && rightRemain == 0) {
            resultList.add(curString);
            return;
        }

        if (rightRemain > leftRemain) {
            return;
        }
        if (rightRemain > 0) {
            this.dfs(curString + ")", leftRemain, rightRemain - 1, resultList);
        }

        if (leftRemain > 0) {
            this.dfs(curString + "(", leftRemain - 1, rightRemain, resultList);
        }

    }

}
