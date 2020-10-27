package utils;


/**
 * @author PanBingYu
 * @description
 * @date 2020-08-18 10:34
 */


public class ListNodeUtil {

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }


    public static String listNodeToString(ListNode input) {
        StringBuilder sb = new StringBuilder();
        while (input != null) {
            sb.append(input.val);
            if (input.next != null) {
                sb.append(", ");
            }
            input = input.next;
        }
        return sb.toString();
    }


}
