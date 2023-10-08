package algorithm.dijkstra.배달;

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

    public int solution(int N, int[][] road, int K) {
        List<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int[] x : road) {
            graph.get(x[0]).add(new Edge(x[1], x[2]));
            graph.get(x[1]).add(new Edge(x[0], x[2]));
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
        int answer = 0;
        for (int d : dis) {
            if (d <= K) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(5,
            new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
        System.out.println(T.solution(6,
            new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3},
                {5, 6, 1}}, 4));
    }
}
