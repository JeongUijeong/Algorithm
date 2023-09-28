package algorithm.dfsbfs.미로의최단거리통로;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[][] board) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        board[0][0] = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = p[0] + dr[j];
                    int nc = p[1] + dc[j];
                    if (nr == 6 && nc == 6) {
                        return level + 1;
                    } else if (nr >= 0 && nr < 7 && nc >= 0 && nc < 7 && board[nr][nc] == 0) {
                        board[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
