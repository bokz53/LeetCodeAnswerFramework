import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 14:29
 */


public class LC004_findMedianSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        LC004_findMedianSortedArrays lc = new LC004_findMedianSortedArrays();
        System.out.println(lc.findMedianSortedArrays(nums1, nums2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list1 = Arrays.stream(nums1).collect(ArrayList::new,
                ArrayList::add,
                ArrayList::addAll);
        List<Integer> list2 = Arrays.stream(nums2).collect(ArrayList::new,
                ArrayList::add,
                ArrayList::addAll);

        List<Integer> list3 = new ArrayList<>(list1);
        list3.addAll(list2);

        list3 = list3.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        double mid = 0;
        if (list3.size() % 2 == 0) {
            mid = (list3.get(list3.size() / 2 - 1) + list3.get(list3.size() / 2)) / 2.0;
        } else {
            mid = list3.get(list3.size() / 2);
        }

        return mid;

    }

    public double findMedianSortedArrayAnswer(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
