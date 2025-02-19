package week5_StringMatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버5_부분문자열_6550 {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s;
            String t;
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) { //입력받은 문자열이 있는 동안만
                st = new StringTokenizer(str, " ");
                s = st.nextToken();
                t = st.nextToken();
                int idx = 0; //s의 인덱스
                for (int i = 0; i < t.length(); i++) { //i는 t의 인덱스
                    if (s.charAt(idx) == t.charAt(i)) idx++; //문자가 일치하는 경우 s의 idx 증가
                    if (idx == s.length()) break; //s 전체 확인 완료한 경우 break
                }
                sb.append(idx == s.length() ? "Yes" : "No").append("\n"); //for문이 완료되었을 때 s가 t의 부분문자열인지 여부
            }
            System.out.print(sb);
        }
    }
}
