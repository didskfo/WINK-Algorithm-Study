package week6_Np;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 골드1_외판원순회_2098 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static int INF = 11000000;
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dp = new int[n][(1<<n)-1];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1); //방문하지 않은 상태를 의미하는 -1로 초기화
            }
            System.out.println(dfs(0, 1));
        }
    }

    static int dfs(int cur, int bitMask) {
        if (bitMask == (1 << n)-1) { //모든 도시를 방문 완료한 상태일 때
            return map[cur][0] == 0 ? INF : map[cur][0]; //만약 길이 없는 상태이면 INF 반환
        }
        if (dp[cur][bitMask] != -1) { //이미 방문한 적 있는 경우
            return dp[cur][bitMask];
        }
        dp[cur][bitMask] = INF; //최소비용을 찾기 위해 INF로 초기화
        for (int i = 0; i < n; i++) {
            if ((bitMask & (1 << i)) == 0 && map[cur][i] != 0) { //방문하지 않았고 길이 있는 경우
                dp[cur][bitMask] = Math.min(dp[cur][bitMask], dfs(i, bitMask | (1<<i)) + map[cur][i]); //현재 값과 다음 도시를 방문한 경우 중 최소값으로 갱신한다
            }
        }
        return dp[cur][bitMask];
    }
}
