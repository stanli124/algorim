/** 所有可能的路径
 *  给定n个节点的有向无环图，请找出从节点0到节点n-1的路径
 */


package graph.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem797 {

    public static void main(String[] args) {
        problem797 a = new problem797();
        System.out.println(a.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>(); //保存所有路径
        LinkedList<Integer> path = new LinkedList<>();  //保存路径
        paths(graph, res, path, 0);
        return res;
    }

    public void paths(int[][] graph, List<List<Integer>> res , LinkedList<Integer> path, int inx){
        path.addLast(inx);
        if (inx == graph.length-1) {
            res.add(new ArrayList<>(path));
        }

//        for (int i = 0; i < graph[inx].length; i++) {
//            paths(graph, res, path, graph[inx][i]);
////            path.removeLast();
//        }

        for (int i : graph[inx]){
            paths(graph, res, path, i);
        }


        path.removeLast();

    }

}
