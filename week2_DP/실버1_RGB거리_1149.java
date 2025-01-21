package week2_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버1_RGB거리_1149 {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[N][3];
            dp[0] = Arrays.copyOf(arr[0], 3);
            for (int i = 1; i < N; i++) {
                dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }
            System.out.println(Arrays.stream(dp[N - 1]).min().getAsInt());
        }
    }
}
