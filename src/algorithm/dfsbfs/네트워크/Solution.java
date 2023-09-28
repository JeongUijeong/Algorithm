package algorithm.dfsbfs.네트워크;

public class Solution {

    public int dfs(int idx, int[][] computers, boolean[] check) {
        if (check[idx]) {
            return 0;
        }
        check[idx] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[idx][i] == 1) {
                dfs(i, computers, check);
            }
        }
        return 1;
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                answer += dfs(i, computers, check);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
