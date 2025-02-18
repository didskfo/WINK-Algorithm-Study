package week5_StringMatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 실버5_문서검색_1543 {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String text = br.readLine();
            String pattern = br.readLine();
            int answer = 0;
            for (int i = 0; i <= text.length()-pattern.length(); i++) {
                boolean check = true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i+j) != pattern.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    answer++;
                    i += pattern.length()-1;
                }
            }
            System.out.println(answer);
        }
    }
}
