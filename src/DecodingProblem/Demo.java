package DecodingProblem;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int out = Decoding(s);
        System.out.println(out);
    }
    public static int Decoding(String s) {
        int n = s.length();
        int[] f = new int[n + 10];
        f[0] = 1;
        for(int i = 1; i <= n;i ++) {
            if(s.charAt(i - 1) != '0') f[i] += f[i - 1];
            if(i >= 2) {
                int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if(t >= 10 && t <= 26) f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
