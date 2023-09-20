package algorithm.bruteforce.nqueen;

import java.util.Scanner;

// 문제 링크 : https://www.acmicpc.net/problem/9663
public class Main {

    static Scanner scan = new Scanner(System.in);

    static int N, ans; // 체스 크기, 경우의 수
    static int[] col; // 체스 열

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    // Queen이 공격할 수 있는지 체크해주는 함수
    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) { // 같은 열에 Queen이 있는 경우
            return true;
        }
        if (r1 - c1 == r2 - c2) { // 역 대각선에 Queen이 있는 경우
            return true;
        }
        if (r1 + c1 == r2 + c2) { // 대각선에 Queen이 있는 경우
            return true;
        }
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++) {
                    // (i, col[i])에 Queen을 놓아도 되는지 체크한다.
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 입력 받는다.
        input();

        // 1번째 원소부터 M번째 원소를 조건에 맞는 모든 경우를 탐색하는 재귀 함수를 호출한다.
        rec_func(1);

        // 답을 출력한다.
        System.out.println(ans);
    }
}
