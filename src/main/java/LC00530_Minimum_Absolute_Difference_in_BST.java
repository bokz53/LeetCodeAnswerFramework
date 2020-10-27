import base.BaseMain;
import utils.TreeNode;
import utils.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00530_Minimum_Absolute_Difference_in_BST extends BaseMain {

    /**
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     *
     *
     * 示例：
     *
     * 输入：
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * 输出：
     * 1
     *
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     *
     */

    public static void main(String[] args) {

        List<TreeNode> inputStrList = new ArrayList<>();

        inputStrList.add(TreeNodeUtil.stringToTreeNode("[1,null,3,2]"));

        LC00530_Minimum_Absolute_Difference_in_BST lc = new LC00530_Minimum_Absolute_Difference_in_BST();

        tryYourAnswer(lc::getMinimumDifference, inputStrList);
    }

    private int preNodeValue = -1;
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        // init
        preNodeValue = Integer.MAX_VALUE;
        result = Integer.MAX_VALUE;

        this.itHelper(root);

        return result;
    }

    private void itHelper(TreeNode root) {
        if (null != root) {
            this.itHelper(root.left);

            if (this.preNodeValue != -1) {
                this.result = Integer.min(Math.abs(root.val - this.preNodeValue), this.result);
            }
            this.preNodeValue = root.val;

            this.itHelper(root.right);
        }
    }

    private int getTheMin(int n1, int n2, int n3) {
        return Math.min(Math.abs(n2-n1), Math.abs(n2-n3));
    }


}
