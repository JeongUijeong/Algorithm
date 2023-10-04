package algorithm.graph.인접행렬;

public class Solution {

    public void solution(int n, int[][] edge) {
        int[][] graph = new int[n + 1][n + 1];
        for (int[] x : edge) {
            graph[x[0]][x[1]] = 1;
            graph[x[1]][x[0]] = 1;
        }
        for (int i = 0; i <= n; i++) {
            if (graph[2][i] == 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution(5, new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}});
    }
}
