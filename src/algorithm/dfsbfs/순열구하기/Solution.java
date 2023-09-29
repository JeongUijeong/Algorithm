package algorithm.dfsbfs.순열구하기;

import java.util.Stack;

public class Solution {

    Stack<Integer> pm = new Stack<>();

    public void dfs(int level, int n, int m, int[] ch) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(i);
                    dfs(level + 1, n, m, ch);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public void solution(int n, int m) {
        int[] ch = new int[n + 1];
        dfs(0, n, m, ch);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution(3, 2);
    }
}
