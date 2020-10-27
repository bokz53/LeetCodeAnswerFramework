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


public class LC00104_Maximum_Depth_of_Binary_Tree extends BaseMain {

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     */



    public static void main(String[] args) {

        List<TreeNode> inputStrList = new ArrayList<>();

        inputStrList.add(TreeNodeUtil.stringToTreeNode("[3,9,20,null,null,15,7]"));

        LC00104_Maximum_Depth_of_Binary_Tree lc = new LC00104_Maximum_Depth_of_Binary_Tree();

        tryYourAnswer(lc::maxDepth, inputStrList, i -> {
            return "";
        }, String::valueOf);
    }



    public int maxDepth(TreeNode root) {



        return 0;
    }
}
