import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00206_Reverse_Linked_List extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();
        List<Integer> inputIntList = new ArrayList<>();

        inputStrList.add("inputString");

        inputIntList.add(0);

        LC00206_Reverse_Linked_List lc = new LC00206_Reverse_Linked_List();

        //        tryYourAnswer(lc::reverseList, inputStrList);
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
}
