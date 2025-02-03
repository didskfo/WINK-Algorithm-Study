package week3_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 골드5_회의실배정_1931 {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] time = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                time[i][0] = Integer.parseInt(st.nextToken());
                time[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(time, (t1, t2) -> t1[1] != t2[1] ? t1[1] - t2[1] : t1[0] - t2[0]);
            int endTime = time[0][1];
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (endTime <= time[i][0]) {
                    cnt++;
                    endTime = time[i][1];
                }
            }
            System.out.println(cnt);
        }
    }
}
