package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드5_강의실배정_11000 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>(((q1, q2) -> {
            if (q1[0] != q2[0]) return q1[0] - q2[0];
            return q1[1] - q2[1];
        }));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            que.offer(new int[]{s, t});
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(0);
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] >= pq.peek()) pq.poll();
            pq.offer(cur[1]);
        }
        
        System.out.println(pq.size());
    }
}
