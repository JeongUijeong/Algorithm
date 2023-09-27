package algorithm.dfsbfs.깊이우선탐색;

class Solution {

    public void dfs(int v) {
        if (v > 7) {
            return;
        } else {
            System.out.print(v + " ");
            dfs(v * 2);
            dfs(v * 2 + 1);
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.dfs(1);
    }
}
