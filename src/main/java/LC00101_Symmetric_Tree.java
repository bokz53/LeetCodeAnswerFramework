import base.BaseMain;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00101_Symmetric_Tree extends BaseMain {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     *  
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *  
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     */

    public static void main(String[] args) {

        List<TreeNode> inputStrList = new ArrayList<>();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);

        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);

        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        inputStrList.add(root1);

        LC00101_Symmetric_Tree lc = new LC00101_Symmetric_Tree();

        tryYourAnswer(lc::isSymmetric, inputStrList);
    }


    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }



}


