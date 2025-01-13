package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 실버4_국영수_10825 {
    static class Student {
        String name;
        int korean;
        int english;
        int math;
        public Student (String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Student> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            lst.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        lst.sort((s1, s2) -> {
            if (s1.korean != s2.korean) return s2.korean - s1.korean; 
            if (s1.english != s2.english) return s1.english - s2.english; 
            if (s1.math != s2.math) return s2.math - s1.math; 
            return s1.name.compareTo(s2.name); 
        });

        StringBuilder sb = new StringBuilder();
        lst.forEach(s -> sb.append(s.name).append("\n"));
        System.out.println(sb);
    }
}
