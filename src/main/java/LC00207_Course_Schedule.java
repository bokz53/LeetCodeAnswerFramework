import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00207_Course_Schedule extends BaseMain {

    /**
     * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
     *
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，
     * 你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     *
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * 示例 2:
     *
     * 输入: 2, [[1,0],[0,1]]
     * 输出: false
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
     *  
     *
     * 提示：
     *
     * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
     * 你可以假定输入的先决条件中没有重复的边。
     * 1 <= numCourses <= 10^5
     *
     */

    public static void main(String[] args) {

        List<Pair<Integer, int[][]>> inputIntList = new ArrayList<>();

        inputIntList.add(new Pair<>(2, new int[][]{new int[]{1,0}}));

        LC00207_Course_Schedule lc = new LC00207_Course_Schedule();

        tryYourAnswer(lc::canFinish, inputIntList, i -> i.getKey() + "=" + Arrays.toString(i.getValue()), String::valueOf);
    }


    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    // 深度优先
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        // 添加边
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        //
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }

        visited[u] = 2;
    }


    int[] indeg;

    // 广度优先
    public boolean can2(int numCourses, int[][] prerequisites) {

        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }

        indeg = new int[numCourses];

        // 添加边
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            // 计算入度
            indeg[info[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] <= 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int u = queue.poll();

            for (int v : edges.get(u)) {
                indeg[v]--;
                if (indeg[v] <= 0) {
                    queue.offer(v);
                }
            }

        }

        return visited == numCourses;
    }

}


