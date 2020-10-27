import base.BaseMain;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0099_Recover_Binary_Search_Tree extends BaseMain {

    /**
     * 二叉搜索树中的两个节点被错误地交换。
     *
     * 请在不改变其结构的情况下，恢复这棵树。
     *
     * 示例 1:
     *
     * 输入: [1,3,null,null,2]
     *
     *    1
     *   /
     *  3
     *   \
     *    2
     *
     * 输出: [3,1,null,null,2]
     *
     *    3
     *   /
     *  1
     *   \
     *    2
     *
     *
     * 示例 2:
     *
     * 输入: [3,1,4,null,null,2]
     *
     *   3
     *  / \
     * 1   4
     *    /
     *   2
     *
     * 输出: [2,1,4,null,null,3]
     *
     *   2
     *  / \
     * 1   4
     *    /
     *   3
     * 进阶:
     *
     * 使用 O(n) 空间复杂度的解法很容易实现。
     * 你能想出一个只使用常数空间的解决方案吗？
     *
     */

    public static void main(String[] args) {

        LC0099_Recover_Binary_Search_Tree lc = new LC0099_Recover_Binary_Search_Tree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        lc.recoverTree(root);
        lc.traverseView(root);
    }



    public void recoverTree(TreeNode root) {
        numbers = new ArrayList<>();
        wrongIndex = new ArrayList<>();

        this.traverse(root);

        if (wrongIndex.size() == 1) {
            wrongIndex.add(wrongIndex.get(0));
        }

        this.swap(root, wrongIndex);

    }

    List<Integer> numbers;
    List<Integer> wrongIndex;

    public void traverse(TreeNode root) {

        if (null == root) {
            return;
        }

        traverse(root.left);

        numbers.add(root.val);
        if (numbers.size() > 1) {
            // 比较
            if (numbers.get(numbers.size()-2) > root.val) {
                wrongIndex.add(numbers.get(numbers.size()-2));
            }
        }

        traverse(root.right);
    }

    public void swap(TreeNode root, List<Integer> wrongIndex) {
        if (null == root) {
            return;
        }

        swap(root.left, wrongIndex);

        if (root.val == wrongIndex.get(0) || root.val == wrongIndex.get(1)) {
            root.val = root.val == wrongIndex.get(0) ? wrongIndex.get(1) : wrongIndex.get(0);
        }

        swap(root.right, wrongIndex);
    }



    public void traverseView(TreeNode root) {

        if (null == root) {
            return;
        }

        traverseView(root.left);

        System.out.println(root.val);

        traverseView(root.right);

    }
}

