package algorithm.bruteforce.카펫;

import java.util.Arrays;

public class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int w = brown / 2 + 2;
        for (int i = w - 3; i > 2; i--) {
            if (yellow == (i - 2) * (w - i - 2)) {
                answer[0] = i;
                answer[1] = w - i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(10, 2)));
        System.out.println(Arrays.toString(T.solution(8, 1)));
        System.out.println(Arrays.toString(T.solution(24, 24)));
    }
}
