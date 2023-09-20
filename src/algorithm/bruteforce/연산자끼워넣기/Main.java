package algorithm.bruteforce.연산자끼워넣기;

import java.util.Scanner;

// 문제 링크 : https://www.acmicpc.net/problem/14888
public class Main {

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N, max, min; // 숫자 개수, 최댓값, 최솟값
    static int[] nums, operators; // 숫자 배열, 연산자 배열
    static int[] order; // 몇 번째 계산에서 몇 번 연산자를 사용했는지 기록할 배열

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수이다.
    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        } else if (operator == 2) {
            return operand1 - operand2;
        } else if (operator == 3) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    // order[1..N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k, int value) {
        if (k == N) { // 모든 연산자들을 전부 나열하는 방법을 찾았다면,
            // 정한 연산자 순서대로 계산해서 최솟값과 최댓값을 갱신한다.
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else { // k 번째 연산자는 무엇을 선택할 것인가?
            // 4가지 연산자들 중에 뭘 쓸 것인지 선택하고 재귀호출 한다.
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) { // 사용할 수 있는 상태라면,
                    operators[cand]--; // 사용할 수 있는 횟수 감소시킨다.
                    order[k] = cand; // k 번째에 cand 번 연산자를 사용했음을 기록한다.
                    int newValue = calculator(value, cand, nums[k + 1]); // 계산한다.
                    rec_func(k + 1, newValue); // 재귀호출한다.
                    operators[cand]++; // cand번 연산자를 사용했음을 취소한다.
                    order[k] = 0; // 사용 기록 초기화한다.
                }
            }
        }
    }

    public static void main(String[] args) {
        // 입력 받는다.
        input();

        // 1번째 원소부터 M번째 원소를 조건에 맞는 모든 경우를 탐색하는 재귀 함수를 호출한다.
        rec_func(1, nums[1]);

        // 답을 출력한다.
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }
}
