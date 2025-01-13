package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 실버5_좌표정렬하기_11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<int[]> lst = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lst.add(new int[]{x, y});
        }
        lst.sort(Comparator.comparingInt((int[] point) -> point[0])
                .thenComparingInt(point -> point[1]));

        StringBuilder sb = new StringBuilder();
        for (int[] l : lst) {
            sb.append(l[0]).append(" ").append(l[1]).append("\n");
        }
        System.out.println(sb);
    }
}
