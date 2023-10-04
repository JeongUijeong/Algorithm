package algorithm.graph.컴퓨터개수.인접행렬;

public class Solution {

    int[][] graph;
    int[] ch;
    int cnt;

    public void dfs(int v) {
        ch[v] = 1;
        cnt++;
        for (int i = 1; i < graph.length; i++) {
            if (graph[v][i] == 1 && ch[i] == 0) {
                dfs(i);
            }
        }
    }

    public int solution(int n, int[][] edge) {
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        cnt = 0;
        for (int[] x : edge) {
            graph[x[0]][x[1]] = 1;
            graph[x[1]][x[0]] = 1;
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
