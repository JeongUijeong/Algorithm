package algorithm.stackqueue.스킬트리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            Queue<Character> queue = new LinkedList<>();
            for (char c : skill.toCharArray()) {
                queue.offer(c);
            }
            boolean flag = true;
            for (char c : skill_tree.toCharArray()) {
                if (queue.contains(c)) {
                    if (queue.peek() == c) {
                        queue.poll();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(T.solution(skill, skill_trees));
    }
}
