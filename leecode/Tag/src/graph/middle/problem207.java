/** 课程表
 *  你这个学期必须选修numCourse门课程，在选修某些课程之前需要一些先修课程。先修课程按数组prerequisites给出
 *  其中prerequisites[i] = [ai, bi]，表示如果要学习课程ai，就必须先学习课程bi。
 *  请你判断是否可能完成所有课程的学习，如果可以，返回true；否则返回false；
 */


package graph.middle;

import java.util.*;

public class problem207 {
    // 记录一次递归堆栈中的节点
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录图中是否有环
    boolean hasCycle = false;

    public static void main(String[] args) {
//        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //构建一个图，如果图中存在环，那么则无法完成所有课程的学习；
        //这种解法只能考虑两个节点之间有环，这两个节点是挨在一起连续的，不能考虑跨节点之间的环
//        boolean[][] graph = new boolean[numCourses][numCourses];
//        for (int i = 0; i < prerequisites.length; i++) {
//            graph[prerequisites[i][0]][prerequisites[i][1]] = true;
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            int m = prerequisites[i][0];
//            int n = prerequisites[i][1];
//            if (graph[m][n] == true && graph[n][m] == true) return false;
//        }
//
//        return true;


            //逻辑有问题
//        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
//        for (int i = 0; i < prerequisites.length; i++) {
//            ArrayList<Integer> node = graph.getOrDefault(prerequisites[i][0], new ArrayList<>()); //拿到当前节点已经有的有向边
//            node.add(prerequisites[i][1]);    //向当前节点添加边
//            graph.put(prerequisites[i][0], node);
//        }
//
//        boolean[] visited = new boolean[numCourses]; //访问数组
//
//        for (int i : graph.keySet()){
//            ArrayList<Integer> node = graph.get(i);
//            visited[i] = true;
//            for (int j = 0; j < node.size(); j++) {
//                if (visited[node.get(j)]) return false;
//                visited[node.get(j)] = true;
//            }
//        }
//
//        return true;
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites){
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }


        return !hasCycle;
    }

    public void traverse(List<Integer>[] graph, int s){
        if (onPath[s]) {
            // 出现环
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序代码位置
        onPath[s] = false;
    }


}
