package week6_Np;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버1_연산자끼워넣기_14888 {
    static int n;
    static int[] arr;
    static int[] oper = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 4; i++) {
                oper[i] = Integer.parseInt(st.nextToken());
            }
            backTrack(1, arr[0]);
            System.out.println(max);
            System.out.println(min);
        }
    }

    static void backTrack(int cnt, int res) {
        if (cnt == n) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                if (i == 0) backTrack(cnt+1, res+arr[cnt]);
                else if (i == 1) backTrack(cnt+1, res-arr[cnt]);
                else if (i == 2) backTrack(cnt+1, res*arr[cnt]);
                else {
                    if (arr[cnt] != 0) {
                        backTrack(cnt+1, res/arr[cnt]);
                    }
                }
                oper[i]++;
            }
        }
    }
}
