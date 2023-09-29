package algorithm.dfsbfs.중복순열구하기;

import java.util.Stack;

class Solution {

    Stack<Integer> pm = new Stack<>();

    public void dfs(int level, int n, int m) {
        if (level == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm.push(i);
                dfs(level + 1, n, m);
                pm.pop();
            }
        }
    }

    public void solution(int n, int m) {
        dfs(0, n, m);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution(3, 2);
    }
}
