/**
 * 网络延迟时间
 * 给你一个列表times，表示信号经过 有向边的 传递时间。
 * times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点，wi是一个信号从源节点到目标节点的时间。
 * 现在，从某个节点K发出一个信号。需要多久才能使所有节点收到信号，返回-1。
 */

package graph.middle;

import java.util.*;





public class problem743 {

    public static void main(String[] args) {



    }

    static class State{
        int id;
        int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<Integer[]>[] graph = new LinkedList[n+1];
        graph = buildGraph(n, times);

        int[] dist = dijkstra(k, graph);

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            res = res > dist[i] ? res : dist[i];
        }
        return res;
    }


    public static int[] dijkstra(int start, List<Integer[]>[] graph){
        int[] distTo = new int[graph.length];
        //distTo[i]是start到其它节点的最小值
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;

        Queue<State> pq = new PriorityQueue<>((a,b)->{
            return a.distFromStart - b.distFromStart;
        });

        pq.offer(new State(start, 0));//每个节点的distFromStart都是在运算过程中动态更新的

        while (!pq.isEmpty()){
            State curState = pq.poll();
            int curId = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curId]) continue;


            //将当前节点的相邻节点装入队列
            for (Integer[] neighbor : graph[curId]){
                int nextNodeId = neighbor[0];
                //到下一个节点的距离
                int distToNextNode = distTo[curId] + neighbor[1];
                //到下一个节点的距离 比 之前到下一个节点的值 小，就更新到下一个节点距离值
                if (distToNextNode < distTo[nextNodeId]){
                    distTo[nextNodeId] = distToNextNode;
                    pq.offer(new State(nextNodeId, distToNextNode));
                }
            }
        }
        return distTo;
    }


    public static List<Integer[]>[] buildGraph(int n, int[][] times){
        List<Integer[]>[] graph = new LinkedList[n+1];   //邻接表结构
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>(); //初始化图中所有节点
        }

        for (int i = 0; i < times.length; i++) {
            Integer[] pair = new Integer[2];
            pair[0] = times[i][1]; //目标节点
            pair[1] = times[i][2]; //到目标节点的权值
            graph[times[i][0]].add(pair);
        }

        return graph;
    }

}
