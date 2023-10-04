package algorithm.graph.인접리스트;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void solution(int n, int[][] edge) {
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : edge) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        for (int i : graph.get(2)) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution(5, new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}});
    }
}
