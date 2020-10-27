import base.BaseMain;
import utils.ListNodeUtil;
import utils.TreeNode;
import utils.ListNode;
import utils.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00109_Convert_Sorted_List_to_Binary_Search_Tree extends BaseMain {

    /**
     *
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 
     * 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     *
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     *
     *
     *  单链表寻找中位数
     *  快慢指针法：两个指针都指向数组[0]，随后快指针一次动两格，慢的一次动一格。
     *  当快指针到达数组最后，或者快指针的下一个元素是数组最后时，慢指针就是中位数。
     *
     */

    public static void main(String[] args) {

        LC00109_Convert_Sorted_List_to_Binary_Search_Tree lc = new LC00109_Convert_Sorted_List_to_Binary_Search_Tree();

        List<ListNode> inputIntList = new ArrayList<>();

        inputIntList.add(ListNodeUtil.stringToListNode("[-10, -3, 0, 5, 9]"));
        inputIntList.add(ListNodeUtil.stringToListNode("[3,5,8]"));

        tryYourAnswer(lc::sortedListToBST, inputIntList, String::valueOf, TreeNodeUtil::treeNodeToString);
    }



    public TreeNode sortedListToBST(ListNode head) {

        List<Integer> nums = new ArrayList<>();

        ListNode cur = head;
        while (null != cur) {
            nums.add(cur.val);
            cur = cur.next;
        }
        Object[] arr = nums.toArray();

        if (arr.length == 1) {
            return new TreeNode((int) arr[0]);
        }

        return helper(arr);
    }

    private TreeNode helper(Object[] arr) {
        if (arr.length <= 0) {
            return null;
        }

        if (arr.length == 1) {
            return new TreeNode((int) arr[0]);
        }

        if (arr.length == 2) {
            TreeNode treeNode = new TreeNode((int) arr[0]);

            if ((int) arr[0] > (int) arr[1]) {
                treeNode.left = new TreeNode((int) arr[1]);
            } else {
                treeNode.right = new TreeNode((int) arr[1]);
            }
            return treeNode;
        }

        int mid = findMid(arr);
        TreeNode root = new TreeNode((int) arr[mid]);

        Object[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        Object[] rightArr = Arrays.copyOfRange(arr, mid+1, arr.length);

        root.left = helper(leftArr);
        root.right = helper(rightArr);
        return root;
    }

    private int findMid(Object[] arr) {
        int slow = 0;
        int fast = 0;

        while (fast < arr.length-2) {
            fast += 2;
            slow += 1;
        }
        return slow;
    }



    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 快慢指针找中心节点
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;

        // 以升序链表的中间元素作为根节点 root，递归的构建 root 的左子树与右子树。
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST2(head);
        root.right = sortedListToBST2(p.next);
        return root;
    }

}

