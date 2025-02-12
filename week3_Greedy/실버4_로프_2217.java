package week3_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 실버4_로프_2217 {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr); // 오름차순 정렬 -> for문에서 반대 순서로 확인
    
            int maxWeight = 0;
            for (int i = 0; i < N; i++) {
                if (maxWeight < arr[N-i-1]*(i+1)) { // 현재 중량을 들어올릴 경우가 최대 중량일 때
                    maxWeight = arr[N-i-1]*(i+1);
                } 
            }
            System.out.println(maxWeight);
        }
    }
}
