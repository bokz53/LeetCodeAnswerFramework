import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00944_Rotting_Oranges extends BaseMain {

    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * <p>
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * <p>
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     */

    public static void main(String[] args) {


        int[][] a1 = {
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };
        int[][] a2 = {
                {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
        };
        int[][] a3 = {
                {0}
        };
        int[][] a4 = {
                {1, 2}
        };
        int[][] a5 = {
                {0, 1}
        };

        LC00944_Rotting_Oranges lc = new LC00944_Rotting_Oranges();
        System.out.println(lc.answer(a1));
        System.out.println(lc.answer(a2));
        System.out.println(lc.answer(a3));
        System.out.println(lc.answer(a4));
        System.out.println(lc.answer(a5));
    }


    public int orangesRotting(int[][] grid) {
        int result = -1;

        if (grid.length == 0 || grid[0].length == 0) {
            return result;
        }

        int rowLength = grid.length;
        int colLength = grid[0].length;

        AtomicInteger goodCounter = new AtomicInteger(this.countGood(grid, grid.length, grid[0].length));
        int[][] preGrid = new int[rowLength + 1][colLength + 1];

        List<int[]> badLocationList = this.findBadLocation(grid, grid.length, grid[0].length);

        // 开始腐烂
        while (!Arrays.deepEquals(preGrid, grid)) {
            preGrid = this.copyArray(grid, grid.length, grid[0].length);
            badLocationList.forEach(curBad -> {
                grid[curBad[0]][curBad[1]] = 3;
                if (curBad[0] < rowLength - 1 && grid[curBad[0] + 1][curBad[1]] == 1) {
                    grid[curBad[0] + 1][curBad[1]] = 2;
                    goodCounter.getAndDecrement();
                }
                if (curBad[1] < colLength - 1 && grid[curBad[0]][curBad[1] + 1] == 1) {
                    grid[curBad[0]][curBad[1] + 1] = 2;
                    goodCounter.getAndDecrement();
                }
                if (curBad[0] > 0 && grid[curBad[0] - 1][curBad[1]] == 1) {
                    grid[curBad[0] - 1][curBad[1]] = 2;
                    goodCounter.getAndDecrement();
                }
                if (curBad[1] > 0 && grid[curBad[0]][curBad[1] - 1] == 1) {
                    grid[curBad[0]][curBad[1] - 1] = 2;
                    goodCounter.getAndDecrement();
                }
            });
            result++;
            badLocationList = this.findBadLocation(grid, grid.length, grid[0].length);
            if ((badLocationList.size() == 0 && goodCounter.get() <= 0)) {
                return result;
            }
        }

        return -1;
    }


    /**
     * BFS广度优先搜索：
     * 一开始，我们找出所有腐烂的橘子，将它们放入队列，作为第 0 层的结点。
     * 然后进行 BFS 遍历，每个结点的相邻结点可能是上、下、左、右四个方向的结点，注意判断结点位于网格边界的特殊情况。
     * 由于可能存在无法被污染的橘子，我们需要记录新鲜橘子的数量。在 BFS 中，每遍历到一个橘子（污染了一个橘子），就将新鲜橘子的数量减一。
     * 如果 BFS 结束后这个数量仍未减为零，说明存在无法被污染的橘子。
     */
    public int answer(int[][] grid) {
        int result = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        int goodCount = 0;
        LinkedList<int[]> rottingList = new LinkedList<>();

        // 记录下坏的位置以及好的数量
        for (int i = 0; i <= rowLength - 1; i++) {
            for (int j = 0; j <= colLength - 1; j++) {
                if (grid[i][j] == 1) {
                    goodCount++;
                } else if (grid[i][j] == 2) {
                    rottingList.add(new int[]{i, j});
                }
            }
        }

        while (goodCount > 0 && !rottingList.isEmpty()) {
            result++;
            // 一次性处理完本轮中的坏橙子，再进入下一轮。所以有两层循环
            int n = rottingList.size();
            for (int i = 0; i < n; i++) {
                int[] curBad = rottingList.poll();
                if (curBad[0] < rowLength - 1 && grid[curBad[0] + 1][curBad[1]] == 1) {
                    grid[curBad[0] + 1][curBad[1]] = 2;
                    goodCount--;
                    // 向队列中加入新的坏橙子
                    rottingList.add(new int[]{curBad[0] + 1, curBad[1]});
                }
                if (curBad[1] < colLength - 1 && grid[curBad[0]][curBad[1] + 1] == 1) {
                    grid[curBad[0]][curBad[1] + 1] = 2;
                    goodCount--;
                    rottingList.add(new int[]{curBad[0], curBad[1] + 1});
                }
                if (curBad[0] > 0 && grid[curBad[0] - 1][curBad[1]] == 1) {
                    grid[curBad[0] - 1][curBad[1]] = 2;
                    goodCount--;
                    rottingList.add(new int[]{curBad[0] - 1, curBad[1]});
                }
                if (curBad[1] > 0 && grid[curBad[0]][curBad[1] - 1] == 1) {
                    grid[curBad[0]][curBad[1] - 1] = 2;
                    goodCount--;
                    rottingList.add(new int[]{curBad[0], curBad[1] - 1});
                }
            }
        }

        if (goodCount > 0) {
            return -1;
        } else {
            return result;
        }
    }


    private List<int[]> findBadLocation(int[][] grid, int rowLength, int colLength) {
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i <= rowLength - 1; i++) {
            for (int j = 0; j <= colLength - 1; j++) {
                if (grid[i][j] == 2) {
                    temp.add(new int[]{i, j});
                }
            }
        }
        return temp;
    }

    private int[][] copyArray(int[][] grid, int rowLength, int colLength) {
        int[][] temp = new int[rowLength][colLength];
        for (int i = 0; i <= rowLength - 1; i++) {
            temp[i] = Arrays.copyOf(grid[i], colLength);
        }
        return temp;
    }

    private int countGood(int[][] grid, int rowLength, int colLength) {
        int result = 0;
        for (int i = 0; i <= rowLength - 1; i++) {
            for (int j = 0; j <= colLength - 1; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
