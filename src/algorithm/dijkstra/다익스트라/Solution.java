package algorithm.dijkstra.다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    public int vex;
    public int cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

class Solution {

    public int solution(int n, int[][] edges, int end) {
        List<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int[] x : edges) {
            graph.get(x[0]).add(new Edge(x[1], x[2]));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        pQ.offer(new Edge(1, 0));
        dis[1] = 0;
        while (!pQ.isEmpty()) {
            int len = pQ.size();
            for (int i = 0; i < len; i++) {
                Edge tmp = pQ.poll();
                if (dis[tmp.vex] < tmp.cost) {
                    continue;
                }
                for (Edge e : graph.get(tmp.vex)) {
                    if (dis[e.vex] > tmp.cost + e.cost) {
                        dis[e.vex] = tmp.cost + e.cost;
                        pQ.offer(new Edge(e.vex, dis[e.vex]));
                    }
                }
            }
        }
        return dis[end] == Integer.MAX_VALUE ? -1 : dis[end];
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(6, new int[][]{{1, 2, 12}, {1, 3, 4},
            {2, 1, 2}, {2, 3, 5}, {2, 5, 5}, {3, 4, 5}, {4, 2, 2}, {4, 5, 5}, {6, 4, 5}}, 5));
    }
}
