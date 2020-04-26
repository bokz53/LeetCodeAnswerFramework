import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0011_Container_With_Most_Water extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();
        List<int[]> inputIntList = new ArrayList<>();

        inputStrList.add("inputString");

        inputIntList.add(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        inputIntList.add(new int[]{1, 8});
        inputIntList.add(new int[]{1, 2, 1});
        inputIntList.add(new int[]{2, 3, 4, 5, 18, 17, 6});

        LC0011_Container_With_Most_Water lc = new LC0011_Container_With_Most_Water();

        tryYourAnswer(lc::answer, inputIntList);
    }

    public int maxArea(int[] height) {

        if (height.length < 2) {
            return 0;
        }

        int[] sore = new int[height.length];

        int firstMax = 0;
        int firstMaxIndex = 0;
        // 找出第一个最高的值
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] >= firstMax) {
                firstMaxIndex = i;
            }
            firstMax = Math.max(firstMax, height[i]);
        }

        for (int j = 0; j < height.length; j++) {
            sore[j] = (Math.min(firstMax, height[j]) * Math.abs(firstMaxIndex - j));
        }


        int result = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            result = Math.max(result, sore[i]);
        }

        return result;
    }


    public int answer(int[] height) {

        // 一开始两个指针一个指向开头一个指向结尾，此时容器的底是最大的，接下来随着指针向内移动，会造成容器的底变小，
        // 在这种情况下想要让容器盛水变多，就只有在容器的高上下功夫。
        // 那我们该如何决策哪个指针移动呢？我们能够发现不管是左指针向右移动一位，还是右指针向左移动一位，容器的底都是一样的，
        // 都比原来减少了 1。这种情况下我们想要让指针移动后的容器面积增大，就要使移动后的容器的高尽量大，
        // 所以我们选择指针所指的高较小的那个指针进行移动，这样我们就保留了容器较高的那条边，放弃了较小的那条边，
        // 以获得有更高的边的机会。


        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int result = 0;

        while (leftIndex < rightIndex) {
            result = Math.max(result, this.getVolum(leftIndex, rightIndex, height));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return result;
    }

    public int getVolum(int left, int right, int[] height) {
        return Math.min(height[left], height[right]) * (right - left);
    }


    public int wtf(int[] height) {
        // 定义左右指针, 分别指向数组的左右两端
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int midPointer;
        int maxCapacity = 0;
        int lessPointer;

        // 循环 条件: 左指针在右指针的左侧
        while (true) {
            // 获取指针指向的更小元素并与距离相乘获取容量
            // 判断是否左右指针当前元素和x之间的容量是否大于当前记录的容量
            lessPointer = height[leftPointer] > height[rightPointer] ? rightPointer : leftPointer;
            if ((rightPointer - leftPointer) * height[lessPointer] > maxCapacity) {
                // 记录左右指针当前元素和x之间形成的容量
                maxCapacity = (rightPointer - leftPointer) * height[lessPointer];
            }
            // 移动指向元素较小的指针到更大的元素的位置
            // 特殊情况处理, 当左右指针所指向元素大小相同
            if (height[leftPointer] == height[rightPointer]) {
                midPointer = leftPointer;
                // 使用中间指针移动至大于左右指针指向元素的元素位置
                while (height[midPointer] <= height[leftPointer]) {
                    midPointer++;
                    if (midPointer >= rightPointer) {
                        return maxCapacity;
                    }
                }
                // 判断中指针与左右指针之间的距离, 移动距离中指针最近的指针到中指针的位置以获取最大的距离 错误
                //                if ((midPointer - leftPointer) > (rightPointer - midPointer)) {
                //                    rightPointer = midPointer;
                //                } else {
                //                    leftPointer = midPointer;
                //                }
                leftPointer = midPointer;
            } else {
                // 移动左指针
                if (height[leftPointer] == height[lessPointer]) {
                    while (height[leftPointer] <= height[lessPointer]) {
                        leftPointer++;
                        if (rightPointer <= leftPointer) {
                            return maxCapacity;
                        }
                    }
                } else {
                    // 移动右指针
                    while (height[rightPointer] <= height[lessPointer]) {
                        rightPointer--;
                        if (rightPointer <= leftPointer) {
                            return maxCapacity;
                        }
                    }
                }
            }
        }
    }
}
