package algorithm.graph.컴퓨터개수.인접리스트;

import java.util.ArrayList;

public class Solution {

    ArrayList<ArrayList<Integer>> graph;
    int[] ch;
    int cnt;

    public void dfs(int v) {
        ch[v] = 1;
        cnt++;
        for (int x : graph.get(v)) {
            if (ch[x] == 0) {
                dfs(x);
            }
        }
    }

    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        ch = new int[n + 1];
        cnt = 0;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : edge) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        dfs(1);
        return n - cnt;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(11,
            new int[][]{{1, 2}, {1, 4}, {2, 3}, {4, 5}, {5, 6}, {7, 8}, {7, 10}, {8, 9},
                {10, 11}}));
        System.out.println(
            T.solution(12, new int[][]{{1, 2}, {1, 7}, {1, 8}, {1, 6}, {8, 11}, {11, 12}}));
        System.out.println(
            T.solution(14, new int[][]{{1, 6}, {1, 5}, {6, 7}, {7, 8}, {9, 8}, {3, 4}, {4, 14}}));
        System.out.println(
            T.solution(15, new int[][]{{1, 4}, {1, 5}, {9, 5}, {9, 6}, {7, 9}, {7, 14}}));
    }
}
