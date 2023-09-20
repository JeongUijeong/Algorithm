package algorithm.sortapplication.카드;

import java.util.Arrays;
import java.util.Scanner;

// 문제 링크 : https://www.acmicpc.net/problem/11652
public class Main {

    static Scanner scan = new Scanner(System.in);

    static int N; // 카드 개수
    static long[] a; // 카드 배열

    static void input() {
        N = scan.nextInt();
        a = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextLong();
        }
    }

    static void pro() {
        // 배열을 정렬한다.
        Arrays.sort(a, 1, N + 1);

        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = a[1];
        int modeCnt = 1;
        int curCnt = 1;

        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지, 새로운 숫자가 나왔는 지를 판단하여
        // curCnt를 갱신해주고, 최빈값을 갱신하는 작업이다.
        for (int i = 2; i <= N; i++) {
            if (a[i] == a[i - 1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }
            if (modeCnt < curCnt) {
                modeCnt = curCnt;
                mode = a[i];
            }
        }

        // 정답을 출력한다.
        System.out.println(mode);
    }

    public static void main(String[] args) {
        // 입력 받는다.
        input();

        // 정렬하고 출력한다.
        pro();
    }
}
