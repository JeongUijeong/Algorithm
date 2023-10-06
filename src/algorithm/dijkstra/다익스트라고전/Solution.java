package algorithm.dijkstra.다익스트라고전;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dist = new int[n + 1];
        int[] ch = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int[] x : edges) {
            graph.get(x[0]).add(new Edge(x[1], x[2]));
        }
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int j = 1; j <= n; j++) {
                if (ch[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    idx = j;
                }
            }
            ch[idx] = 1;
            for (Edge ob : graph.get(idx)) {
                if (dist[ob.vex] > dist[idx] + ob.cost) {
                    dist[ob.vex] = dist[idx] + ob.cost;
                }
            }
        }
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(6, new int[][]{{1, 2, 12}, {1, 3, 4},
            {2, 1, 2}, {2, 3, 5}, {2, 5, 5}, {3, 4, 5}, {4, 2, 2}, {4, 5, 5}, {6, 4, 5}}, 5));
    }
}
