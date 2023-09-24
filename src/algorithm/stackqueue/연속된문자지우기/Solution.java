package algorithm.stackqueue.연속된문자지우기;

import java.util.Stack;

class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("acbbcaa"));
        System.out.println(T.solution("bacccaba"));
        System.out.println(T.solution("aabaababbaa"));
        System.out.println(T.solution("bcaacccbaabccabbaa"));
        System.out.println(T.solution("cacaabbc"));
    }
}
