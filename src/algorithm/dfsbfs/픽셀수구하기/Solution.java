package algorithm.dfsbfs.픽셀수구하기;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    int cnt;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public void dfs(int r, int c, int[][] board) {
        board[r][c] = 0;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
                && board[nr][nc] == 1) {
                dfs(nr, nc, board);
            }
        }
    }

    public int[] solution(int[][] board) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j, board);
                    list.add(cnt);
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(
            Arrays.toString(T.solution(
                new int[][]{{0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0},
                    {0, 0, 1, 1, 0}})));
        System.out.println(Arrays.toString(T.solution(
            new int[][]{{1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 1, 0, 0}, {1, 1, 0, 1, 0},
                {1, 0, 1, 0, 0}})));
        System.out.println(Arrays.toString(T.solution(
            new int[][]{{0, 0, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0}})));
        System.out.println(Arrays.toString(T.solution(
            new int[][]{{0, 0, 0, 0, 1}, {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0}})));
    }
}
