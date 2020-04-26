import base.BaseMain;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC005_longestPalindrome extends BaseMain {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */


    public static void main(String[] args) {
        String str = "babad";

        LC005_longestPalindrome lc = new LC005_longestPalindrome();

        //        System.out.println(lc.isPalindrome("aabcdaa"));

        tryYourAnswer(lc::longestPalindromeAnswer, str);

        //        System.out.println(lc.longestPalindrome(str));
    }

    public String longestPalindrome(String s) {

        if ("".equals(s)) {
            return s;
        }

        char[] chars = s.toCharArray();
        int charsLength = chars.length;
        int maxPalindromeLength = 0;
        int palinStartIndex = 0;
        int palinEndIndex = 0;

        for (int i = 0; (i < charsLength) && (charsLength - 1 - i > maxPalindromeLength); i++) {

            for (int j = charsLength - 1; (j > i) && (maxPalindromeLength < j - i); j--) {
                if (chars[i] == chars[j] && isPalindrome(s.substring(i, j + 1))) {
                    maxPalindromeLength = Math.max(maxPalindromeLength, j - i);
                    palinStartIndex = i;
                    palinEndIndex = j;
                }
            }

        }
        return s.substring(palinStartIndex, palinEndIndex + 1);
    }

    public boolean isPalindrome(String str) {

        char[] chars = str.toCharArray();
        int charsLength = chars.length;
        boolean result = false;

        for (int i = 0; i <= chars.length / 2; i++) {
            if (!(chars[i] == chars[charsLength - 1 - i])) {
                break;
            }
            if ((i == charsLength - 1 - i) || ((i + 1) == charsLength - 1 - i)) {
                result = true;
                break;
            }
        }
        return result;
    }


    // __________________________________________


    /**
     * 中心扩展法
     * <p>
     * 事实上，只需使用恒定的空间，我们就可以在 O(n^2)O(n
     * 2
     * ) 的时间内解决这个问题。
     * <p>
     * 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。
     * <p>
     * 你可能会问，为什么会是 2n - 12n−1 个，而不是 nn 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 \textrm{“abba”}“abba” 的中心在两个 \textrm{‘b’}‘b’ 之间）。
     */

    public String longestPalindromeAnswer(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
