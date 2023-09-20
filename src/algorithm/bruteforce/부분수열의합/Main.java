package algorithm.bruteforce.부분수열의합;

import java.util.Scanner;

// 문제 링크 : https://www.acmicpc.net/problem/1182
public class Main {

    static Scanner scan = new Scanner(System.in);

    static int N, S, ans; // 정수의 개수, 목표 합, 경우의 수
    static int[] nums; // N개의 정수

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    // k 번째 원소를 포함시킬 지 정하는 함수이다.
    // value:= k-1 번째 원소까지 골라진 원소들의 합이다.
    static void rec_func(int k, int value) {
        if (k == N + 1) { // 부분 수열을 하나 완성시킨 상태이다.
            // value 가 S 랑 같은 지 확인한다.
            if (value == S) {
                ans++;
            }
        } else {
            // k 번째 원소를 포함시킬 지 결정하고 재귀호출한다.
            // 포함시킬 경우
            rec_func(k + 1, value + nums[k]);
            // 포함시키지 않을 경우
            rec_func(k + 1, value);
        }
    }

    public static void main(String[] args) {
        // 입력 받는다.
        input();

        // 1번째 원소부터 M번째 원소를 조건에 맞는 모든 경우를 탐색하는 재귀 함수를 호출한다.
        rec_func(1, 0);

        // ans 가 정말 "진 부분집합"만 다루는 지 확인한다.
        // 목표 값이 0이라면 공집합일 떄, ans를 증가시키기 때문에 목표치가 0일 떄 ans--를 해준다.
        if (S == 0) {
            ans--;
        }

        // 답을 출력한다.
        System.out.println(ans);
    }
}
