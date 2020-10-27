import base.BaseMain;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00110_Balanced_Binary_Tree extends BaseMain {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     *
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     *
     */

    public static void main(String[] args) {

        LC00110_Balanced_Binary_Tree lc = new LC00110_Balanced_Binary_Tree();

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(7);

        root1.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);

        List<TreeNode> inputIntList = new ArrayList<>();

        inputIntList.add(root1);

        tryYourAnswer(lc::isBalanced2, inputIntList);
    }



    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }


    // 自底向上
    public boolean isBalanced2(TreeNode root) {
       return helper(root) >= 0;
    }

    private int helper(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

