package algorithm.dfsbfs.단어변환;

public class Solution {

    public boolean isDiffOne(String a, String b) {
        int diffCnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCnt++;
            }
        }
        if (diffCnt != 1) {
            return false;
        } else {
            return true;
        }
    }

    public int dfs(int idx, String begin, String target, String[] words, boolean[] check, int cnt) {
        // 타겟을 찾으면
        if (target.equals(begin)) {
            return cnt;
        }
        // 탐색 체크
        check[idx] = true;
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (i != idx && isDiffOne(begin, words[i]) && !check[i]) {
                result = dfs(i, words[i], target, words, check, cnt + 1);
            }
        }
        return result;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            boolean[] check = new boolean[words.length];
            if (isDiffOne(begin, words[i])) {
                answer = Math.min(answer, dfs(i, words[i], target, words, check, 1));
            }
        }
        // 타겟으로 변환할 수 없다면
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(
            T.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(
            T.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
