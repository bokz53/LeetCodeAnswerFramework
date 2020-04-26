import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC019_Remove_Nth_Node_From_End_of_List extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        //        ListNode listNode4 = new ListNode(null, 4);
        //        ListNode listNode3 = new ListNode(listNode4, 3);
        ListNode listNode3 = new ListNode(null, 3);
        ListNode listNode2 = new ListNode(listNode3, 2);
        ListNode listNode1 = new ListNode(listNode2, 1);

        LC019_Remove_Nth_Node_From_End_of_List lc = new LC019_Remove_Nth_Node_From_End_of_List();


        lc.readList(lc.reverseList2(listNode1));
    }


    public void readList(ListNode listNode) {

        System.out.println(listNode.val);

        if (listNode.next != null) {
            readList(listNode.next);
        }

    }

    public ListNode reverseList(ListNode listNode, ListNode lastListNode) {
        if (listNode == null) {
            return null;
        }
        ListNode nextListNode = listNode.next;

        listNode.next = lastListNode;
        if (nextListNode != null) {
            return reverseList(nextListNode, listNode);
        } else {
            return listNode;
        }
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode theTail = reverseList2(head.next);

        head.next.next = head;
        head.next = null;
        return theTail;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode theTail = reverseList(head, null);
        ListNode currentNode = theTail;
        ListNode previousNode = null;
        for (int i = 1; i < n; i++) {
            if (currentNode != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            } else {
                return null;
            }
        }
        if (previousNode != null) {
            previousNode.next = currentNode.next;
        } else {
            theTail = currentNode.next;
            currentNode.next = null;
            return reverseList(theTail, null);
        }
        return reverseList(theTail, null);
    }

    public ListNode answer(ListNode head, int n) {
        ListNode theHead = new ListNode();
        theHead.next = head;
        ListNode firstPoint = theHead;
        ListNode secondPoint = theHead;

        for (int i = 0; i <= n; i++) {
            firstPoint = firstPoint.next;
        }
        while (firstPoint != null) {
            firstPoint = firstPoint.next;
            secondPoint = secondPoint.next;
        }
        secondPoint.next = secondPoint.next.next;

        return theHead.next;
    }


}

class ListNode {
    public ListNode next;
    public int val;

    public ListNode() {
    }


    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }
}
