package algorithm.bruteforce.boj15651;

import java.util.Scanner;

// 문제 링크 : https://www.acmicpc.net/problem/15651
public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M; // 행, 열
    static int[] selected; // 선택한 M개의 원소를 담을 배열

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    // Recursion Function : 재귀함수
    // M개를 다 골랐으면, 조건에 맞는 탐색을 한 번 성공한 것이다.
    // 아직 M개를 고르지 않았다면, k~M번째 원소를 조건에 맞게 고르는 모든 방법을 탐색한다.
    static void recFunc(int k) {
        if (k == M + 1) { // M개를 다 골랐으면,
            // 탐색 결과가 담긴 selected[1...M] 배열을 sb에 담는다.
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else { // 아직 M개를 고르지 않았다면,
            // 1~N 까지를 k번 원소로 한 번씩 정하고,
            // 매번 k+1번부터 M번 원소로 재귀호출한다.
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;
                recFunc(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // 입력 받는다.
        input();

        // 1번째 원소부터 M번째 원소를 조건에 맞는 모든 경우를 탐색하는 재귀 함수를 호출한다.
        recFunc(1);

        // 답을 출력한다.
        System.out.println(sb.toString());
    }
}
