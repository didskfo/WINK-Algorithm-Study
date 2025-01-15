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
        PriorityQueue<int[]> que = new PriorityQueue<>((q1, q2) -> Integer.compare(q1[0], q2[0]));
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            que.offer(new int[]{s, t});
        }

        // 강의 종료 시간 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (!pq.isEmpty() && cur[0] >= pq.peek()) pq.poll(); // 앞 강의 종료시간보다 현 강의 시작시간이 뒤라면 강의실 재사용 가능
            pq.offer(cur[1]); // 현 강의 종료시간 추가
        }

        System.out.println(pq.size());
    }
}
