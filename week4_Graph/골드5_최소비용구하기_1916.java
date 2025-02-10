package week4_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 골드5_최소비용구하기_1916 {
    static class Node implements Comparable<Node>{
        int dest;
        int cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }
    static int N, M, start, end;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visit;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            visit = new boolean[N+1];
            dist = new int[N+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            StringTokenizer st;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, c));
            }
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            dist[start] = 0;
            dijkstra();
            System.out.println(dist[end]);
        }
    }

    static void dijkstra() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start, 0));
        while (!que.isEmpty()) {
            int cur = que.poll().dest;
            if (!visit[cur]) {
                visit[cur] = true;
                for (Node node : graph.get(cur)) {
                    if (dist[node.dest] > dist[cur] + node.cost) {
                        dist[node.dest] = dist[cur] + node.cost;
                        que.add(new Node(node.dest, dist[node.dest]));
                    }
                }
            }
        }
    }
}
