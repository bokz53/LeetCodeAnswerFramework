/**
 * @author PanBingYu
 * @description
 * @date 2019-12-16 17:51
 */


public class LC003_lengthOfLongestSubString {


    public static void main(String[] args) {

        LC003_lengthOfLongestSubString t = new LC003_lengthOfLongestSubString();

        String str = "abcabcbb";
        System.out.println(t.lengthOfLongestSubstring("au"));


    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int leftIndex = 0;
        for (int i = 1; i < chars.length; i++) {

            for (int j = leftIndex; j < i; j++) {
                if (chars[j] == chars[i]) {
                    maxLength = Math.max(maxLength, i - leftIndex);
                    leftIndex = j + 1;
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);
    }
}
