package algorithm.sortapplication.수열정렬;

import java.util.Arrays;
import java.util.Scanner;

// 문제 링크 : https://www.acmicpc.net/problem/1015
public class Main {

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static int N; // 배열의 길이
    static int[] P; // 수열
    static Elem[] B; // 수열 P에 적용했을 때 비내림차순이 되는 수열

    static void input() {
        N = scan.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            // Elem 의 정의에 맞게 B[i] 에 값을 넣어준다.
            B[i].num = scan.nextInt();
            B[i].idx = i;
        }
    }

    static class Elem implements Comparable<Elem> {

        // A 배열의 idx 위치를 기억하는 변수
        // A[idx]의 원래 값
        public int num, idx;

        @Override
        public int compareTo(Elem other) {
            // 정렬 조건에 맞게 정렬한다.
            // 1. num 의 비내림차순
            if (num != other.num) {
                return num - other.num;
            }
            // 2. num이 같으면 idx 오름차순
            // Object 솔트에서 팀 솔트를 사용하므로 인덱스가 오름차순으로 정렬된다.
            // 따라서 idx로 정렬할 필요가 없다.
            return idx - other.idx;
        }
    }

    static void pro() {
        // B 배열을 정렬한다.
        Arrays.sort(B);

        // B 배열의 값을 이용해서 P 배열을 채운다.
        for (int bIdx = 0; bIdx < N; bIdx++) {
            P[B[bIdx].idx] = bIdx;
        }

        // 정답을 출력한다.
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        // 입력 받는다.
        input();

        // 정렬하고 출력한다.
        pro();
    }
}
