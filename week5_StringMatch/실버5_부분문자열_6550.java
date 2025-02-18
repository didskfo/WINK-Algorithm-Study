package week5_StringMatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실버5_부분문자열_6550 {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String pattern;
            String text;
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                st = new StringTokenizer(str, " ");
                pattern = st.nextToken();
                text = st.nextToken();
                int idx = 0;
                for (int i = 0; i < text.length(); i++) {
                    if (pattern.charAt(idx) == text.charAt(i)) idx++;
                    if (idx == pattern.length()) break;
                }
                sb.append(idx == pattern.length() ? "Yes" : "No").append("\n");
            }
            System.out.print(sb);
        }
    }
}
