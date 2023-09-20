package algorithm.simulation.청소로봇3;

import java.util.Arrays;

class Solution {

    public int[] solution(int[][] board, int k) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int r = 0, c = 0;
        int d = 1;
        int n = board.length;
        int cnt = 0;
        while (cnt < k) {
            cnt++;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || (board[nr][nc] == 1)) {
                d = (d + 1) % 4;
            } else {
                r = nr;
                c = nc;
            }
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}