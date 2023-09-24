package algorithm.stackqueue.기능개발;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int calc(int p, int s) {
        return (100 - p) / s + (((100 - p) % s != 0) ? 1 : 0);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> pQ = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : progresses) {
            pQ.add(num);
        }
        int cnt = -1;
        int day = 0;
        for (int i = 0; i < pQ.size(); i++) {
            if (calc(progresses[i], speeds[i]) <= day) {
                hm.put(cnt, hm.getOrDefault(cnt, 0) + 1);
            } else {
                day = calc(progresses[i], speeds[i]);
                hm.put(++cnt, 1);
            }
        }
        int[] answer = new int[hm.size()];
        for (int i = 0; i < hm.size(); i++) {
            answer[i] = hm.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(
            T.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }
}
