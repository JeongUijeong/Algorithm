package algorithm.bruteforce.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] solution(int[] answers) {
        int[] scores = new int[]{0, 0, 0};
        int[] nums1 = new int[]{1, 3, 4, 5};
        int[] nums2 = new int[]{3, 1, 2, 4, 5};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == i % 5 + 1) {
                scores[0]++;
            }
            if (answers[i] == (i % 2 == 0 ? 2 : nums1[i / 2 % 4])) {
                scores[1]++;
            }
            if (answers[i] == nums2[i % 10 / 2]) {
                scores[2]++;
            }
        }
        List<Integer> list = new ArrayList<>();
        int max = Arrays.stream(scores).max().orElse(0);
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(
            Arrays.toString(T.solution(new int[]{1, 2, 3, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 2})));
    }
}
