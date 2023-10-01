package algorithm.dfsbfs.줄다리기;

import java.util.Stack;

public class Solution {

    int answer;
    int[][] hate;
    int[] ch;
    Stack<Integer> pm = new Stack<>();

    public void dfs(int level) {
        if (level == 7) {
            answer++;
        } else {
            for (int i = 1; i < 8; i++) {
                if (!pm.empty() && hate[pm.peek()][i] == 1) {
                    continue;
                }
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(i);
                    dfs(level + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public int solution(int[][] fight) {
        answer = 0;
        hate = new int[8][8];
        ch = new int[8];
        for (int[] x : fight) {
            hate[x[0]][x[1]] = 1;
            hate[x[1]][x[0]] = 1;
        }
        dfs(0);
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
