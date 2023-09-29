package algorithm.dfsbfs.아이템줍기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                board[i][j] = -1;
            }
        }
        for (int[] rect : rectangle) {
            for (int i = rect[1] * 2 + 1; i < rect[3] * 2; i++) {
                for (int j = rect[0] * 2 + 1; j < rect[2] * 2; j++) {
                    board[i][j] = 0;
                }
            }
            for (int i = rect[1] * 2; i <= rect[3] * 2; i++) {
                if (board[i][rect[0] * 2] != 0) {
                    board[i][rect[0] * 2] = 1;
                }
                if (board[i][rect[2] * 2] != 0) {
                    board[i][rect[2] * 2] = 1;
                }
            }
            for (int i = rect[0] * 2; i <= rect[2] * 2; i++) {
                if (board[rect[1] * 2][i] != 0) {
                    board[rect[1] * 2][i] = 1;
                }
                if (board[rect[3] * 2][i] != 0) {
                    board[rect[3] * 2][i] = 1;
                }
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterY*2, characterX*2});
        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = p[0] + dr[j];
                    int nc = p[1] + dc[j];
                    if (nr == itemY*2 && nc == itemX*2) {
                        return (level + 1)/2;
                    }else if (nr > 0 && nr < 101 && nc > 0 && nc < 101 && board[nr][nc] == 1) {
                        board[nr][nc] = 2;
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
        System.out.println(
            T.solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7,
                8));
    }
}
