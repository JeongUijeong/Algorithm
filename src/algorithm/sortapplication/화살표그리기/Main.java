package algorithm.sortapplication.화살표그리기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 문제 링크 : https://www.acmicpc.net/problem/15970
public class Main {

    static Scanner scan = new Scanner(System.in);

    static int N; // 점의 개수
    static ArrayList<Integer>[] a; // 색깔별로 모은 배열 리스트

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N + 1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= N; i++) {
            int coord, color;
            coord = scan.nextInt();
            color = scan.nextInt();
            // color 인 색깔의 점이 coord에 놓여 있다.
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx) {
        // 색깔이 color 인 점의 idx 번째에 있는 점이 왼쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 왼쪽에 점이 없다면 무한대를 return 한다.
        if (idx == 0) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        // 색깔이 color 인 점의 idx 번째에 있는 점이 오른쪽으로 화살표를 그린다면
        // 화살표의 길이를 return 하는 함수. 오른쪽에 점이 없다면 무한대를 return 한다.
        if (idx + 1 == a[color].size()) {
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void pro() {
        // 색깔별로 정렬한다.
        for (int color = 1; color <= N; color++) {
            Collections.sort(a[color]);
        }

        int ans = 0;
        for (int color = 1; color <= N; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                int left = toLeft(color, i);
                int right = toRight(color, i);
                ans += Math.min(left, right);
            }
        }

        // 정답을 출력한다.
        System.out.println(ans);
    }

    public static void main(String[] args) {
        // 입력 받는다.
        input();

        // 정렬하고 출력한다.
        pro();
    }
}
