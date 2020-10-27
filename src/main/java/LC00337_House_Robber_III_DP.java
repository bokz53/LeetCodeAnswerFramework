import base.BaseMain;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00337_House_Robber_III_DP extends BaseMain {

    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
     * 这个地区只有一个入口，我们称之为“根”。
     * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
     * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     *
     *
     * 示例 2:
     *
     * 输入: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     *
     *
 *           1
     *      / \
     *     2   3
     *      \   \
     *       5   7
     *
     */

    public Map<TreeNode, Integer> memo = new HashMap<>();

    public static void main(String[] args) {

        List<TreeNode> inputIntList = new ArrayList<>();


        TreeNode root0 = new TreeNode(1);
        root0.left = new TreeNode(2);
        root0.left.right = new TreeNode(5);

        root0.right = new TreeNode(3);
        root0.right.right = new TreeNode(7);

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.left.right = new TreeNode(3);

        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);


        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);


        inputIntList.add(root0);
        inputIntList.add(root1);
        inputIntList.add(root2);

        LC00337_House_Robber_III_DP lc = new LC00337_House_Robber_III_DP();

        tryYourAnswer(lc::helper, inputIntList, String::valueOf, String::valueOf);
    }


//    public int rob(TreeNode root) {
//
//        TreeNode pre = null;
//        TreeNode last = null;
//
//
//        if (root != null) {
//            System.out.println(root.val);
//
//            rob(root.left);
//
//            rob(root.right);
//
//        } else {
//            System.out.println("null");
//            return 0;
//        }
//        return 0;
//    }

//    private void rHelper (TreeNode root) {
//        if (root != null) {
//
//            if (root.left == null && root.right == null) {
//                // 加入底层map
//            } else {
//
//                System.out.println(root.val);
//
//                rob(root.left);
//
//                rob(root.right);
//            }
//
//        } else {
//            System.out.println("null");
//            return 0;
//        }
//        return 0;
//    }

    // 递龟+memo
    public int rob(TreeNode root) {

        memo.clear();

        int res = this.helper(root);

        return res;

    }


    public int helper(TreeNode root) {
        if (root != null) {
            int val = root.val;
            if (root.left != null && root.right != null) {
                if (memo.containsKey(root)) {
                    return memo.get(root);
                } else {
                    int max = Math.max(
                            helper(root.left) + helper(root.right),
                            ((val + helper(root.left.right) + helper(root.left.left) + helper(root.right.left) + helper(root.right.right)))
                    );
                    memo.put(root, max);
                    return max;
                }
            } else if (root.left != null) {
                if (memo.containsKey(root)) {
                    return memo.get(root);
                } else {
                    int max = Math.max(
                            (helper(root.left)),
                            ((val + helper(root.left.right) + helper(root.left.left)))
                    );
                    memo.put(root, max);
                    return max;
                }
            } else if (root.right != null) {
                if (memo.containsKey(root)) {
                    return memo.get(root);
                } else {
                    int max = Math.max(
                            (helper(root.right)),
                            ((val + helper(root.right.left) + helper(root.right.right)))
                    );
                    memo.put(root, max);
                    return max;
                }
            } else {
                return root.val;
            }
        } else {
            return 0;
        }
    }


    // 复制下来的
    public int answer(TreeNode root) {
        int[] rs = doRob(root);
        return Math.max(rs[0], rs[1]);
    }


    public int[] doRob(TreeNode root) {
        int[] result = new int[2]; //result[0]代表偷当前节点，result[1]代表不偷当前节点
        if (root == null) {
            return result;
        }
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        result[0] = left[1] + right[1] + root.val;
        result[1] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        return result;
    }




}


