package week2_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 실버2_가장긴증가하는부분수열_11053 {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[N];
            for (int i = 0; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j] && dp[i] < dp[j]+1) {
                        dp[i] = dp[j]+1;
                    }
                }
            }
            System.out.println(Arrays.stream(dp).max().getAsInt());
        }
    }
}
