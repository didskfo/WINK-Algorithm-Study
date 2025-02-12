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

            Arrays.sort(time, (t1, t2) -> t1[1] != t2[1] ? t1[1] - t2[1] : t1[0] - t2[0]); // 끝나는 시간이 빠른 순서대로 정렬 (같으면 시작 시간이 빠른 순서)
            int endTime = time[0][1]; // 가장 먼저 끝나는 시간
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (endTime <= time[i][0]) { // 앞에가 끝나고 시작하는 회의면 선택
                    cnt++;
                    endTime = time[i][1]; // 끝나는 시간 갱신하기
                }
            }
            System.out.println(cnt);
        }
    }
}
