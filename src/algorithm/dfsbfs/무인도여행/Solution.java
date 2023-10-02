package algorithm.dfsbfs.무인도여행;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int food;

    public void dfs(int r, int c, char[][] board) {
        food += board[r][c] - 48; // char 숫자 -> int 숫자
        board[r][c] = 'X';
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
                && board[nr][nc] != 'X') {
                dfs(nr, nc, board);
            }
        }
    }

    public int[] solution(String[] maps) {
        char[][] board = new char[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            board[i] = maps[i].toCharArray();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'X') {
                    food = 0;
                    dfs(i, j, board);
                    list.add(food);
                }
            }
        }
        list.sort((o1, o2) -> o1 - o2);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return list.isEmpty() ? new int[]{-1} : answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(
            Arrays.toString(T.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }
}
