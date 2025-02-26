package week6_Np;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버3_N과M1_15649 {
    static int n, m;
    static boolean[] visit;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visit = new boolean[n+1];
            selected = new int[m];
            backTrack(0);
            System.out.println(sb);
        }
    }

    static void backTrack(int cnt) {
        if (cnt == m) {
            for (int a : selected) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                selected[cnt] = i;
                backTrack(cnt+1);
                visit[i] = false;
            }
        }
    }
}
