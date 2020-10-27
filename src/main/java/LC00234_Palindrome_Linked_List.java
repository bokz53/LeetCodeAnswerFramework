import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00234_Palindrome_Linked_List extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        List<ListNode> inputStrList = new ArrayList<>();

        inputStrList.add(null);


        LC00234_Palindrome_Linked_List lc = new LC00234_Palindrome_Linked_List();

        tryYourAnswer(lc::isPalindrome, inputStrList);
    }


    public boolean isPalindrome(ListNode head) {

        ListNode slowP = head;
        ListNode fastP = head;

        while (head != null) {



        }

        return true;
    }
}
