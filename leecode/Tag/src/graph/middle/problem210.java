/**
 * 课程表||
 * 求出为了学完所有课程所 安排的学习顺序。
 */

package graph.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class problem210 {

    public static void main(String[] args) {
        int[] res = findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        //计算入度
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (Integer n : graph[i]){
                indegree[n] += 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0){
                q.offer(i); //当前节点入度为0
            }
        }

        int[] res = new int[numCourses];
        int count = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            res[count++] = cur;
            for (int next : graph[cur]){
                indegree[next]--;
                if (indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        if (count!=numCourses){
            return new int[]{};
        }


        return res;
    }


    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses]; //只是申明了一个变量，没有初始化；所以引用类型默认的初始值是null

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1]; //学习课程to之前 要学习的课程
            int to = prerequisites[i][0];
            graph[from].add(to);
        }

        return graph;
    }

}
