package algorithm.dfsbfs.퍼즐조각채우기;

public class Solution {

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(
            new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}},
            new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}},
            new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}}));
    }
}
