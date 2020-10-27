import base.BaseMain;
import utils.TreeNode;
import utils.linked.LinkedTreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00116_Populating_Next_Right_Pointers_in_Each_Node extends BaseMain {

    /**
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
     * 则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有next 指针都被设置为 NULL。
     *
     */

    public static void main(String[] args) {

        List<TreeNode> inputStrList = new ArrayList<>();

        inputStrList.add(LinkedTreeNodeUtil.stringToTreeNode("[1,2,3,4,5,6,7]"));

        LC00116_Populating_Next_Right_Pointers_in_Each_Node lc = new LC00116_Populating_Next_Right_Pointers_in_Each_Node();

        tryYourAnswer(lc::connect, inputStrList);
    }


    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                TreeNode nextNode = count <= 1 ? null : queue.peek();

                // 做的事情
                node.next = nextNode;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }

        }
        return root;
    }


    // 双百
    public TreeNode answer(TreeNode root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        TreeNode cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            TreeNode dummy = new TreeNode(0);
            //pre表示访下一层节点的前一个节点
            TreeNode pre = dummy;

            //然后开始遍历当前层的链表
            //因为是完没二叉树，如果有左子节点就一定有右子节点
            while (cur != null && cur.left != null) {
                //让pre节点的next指向当前节点的左子节点，也就是把它串起来
                pre.next = cur.left;
                //然后再更新pre
                pre = pre.next;

                //pre节点的next指向当前节点的右子节点，
                pre.next = cur.right;
                pre = pre.next;
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }

}
