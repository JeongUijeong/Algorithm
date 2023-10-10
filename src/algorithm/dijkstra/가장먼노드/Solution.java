package algorithm.dijkstra.가장먼노드;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Solution {

    public int solution(int n, int[][] edge) {
        List<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int[] x : edge) {
            graph.get(x[0]).add(new Edge(x[1], 1));
            graph.get(x[1]).add(new Edge(x[0], 1));
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
        int max = 0;
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = 0;
            }
            max = Math.max(max, dis[i]);
        }
        int answer = 0;
        for (int i : dis) {
            if (max == i) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(
            T.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
