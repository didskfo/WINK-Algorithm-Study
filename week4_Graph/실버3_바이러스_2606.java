package week4_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 실버3_바이러스_2606 {
    static int V, E, cnt = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            V = Integer.parseInt(br.readLine());
            E = Integer.parseInt(br.readLine());
            visit = new boolean[V+1];
            StringTokenizer st;
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            bfs();
            System.out.println(cnt);
        }
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visit[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int a : graph.get(cur)) {
                if (!visit[a]) {
                    que.offer(a);
                    visit[a] = true;
                    cnt++;
                }
            }
        }
    }
}
