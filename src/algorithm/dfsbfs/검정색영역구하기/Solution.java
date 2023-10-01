package algorithm.dfsbfs.검정색영역구하기;

public class Solution {

    int answer;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public void dfs(int r, int c, int[][] board) {
        board[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
                && board[nr][nc] == 1) {
                dfs(nr, nc, board);
            }
        }
    }

    public int solution(int[][] board) {
        answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    dfs(i, j, board);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(
            new int[][]{{0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0}}));
        System.out.println(T.solution(
            new int[][]{{1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 1, 0, 0}, {1, 1, 0, 1, 0},
                {1, 0, 1, 0, 0}}));
        System.out.println(T.solution(
            new int[][]{{0, 0, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0}}));
        System.out.println(T.solution(
            new int[][]{{0, 0, 0, 0, 1}, {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0}}));
    }
}
