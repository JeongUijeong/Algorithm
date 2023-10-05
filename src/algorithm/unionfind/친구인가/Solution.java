package algorithm.unionfind.친구인가;

public class Solution {

    int[] unf;

    public int find(int v) {
        if (v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);//find(unf[v]);
        }
    }

    public void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public String solution(int n, int[][] friend, int s1, int s2) {
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int[] f : friend) {
            union(f[0], f[1]);
        }
        return find(s1) == find(s2) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(
            T.solution(9, new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 5}, {6, 7}, {7, 8}, {8, 9}}, 3,
                8));
    }
}
