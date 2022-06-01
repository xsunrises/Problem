package FormulaProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        String[][] arr = new String[T][3];
        for (int i = 0; i < T; i++) {
            String str = in.nextLine();
            // 直接按"*"分割不行，需要加上\\
            String[] str1 = str.split("\\*");
            String str2 = str1[1];
            String[] str3 = str2.split("\\=");
            arr[i][0] = str1[0];
            arr[i][1] = str3[0];
            arr[i][2] = str3[1];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int n1 = arr[i][0].length();
            int n2 = arr[i][1].length();
            int n3 = arr[i][2].length();
            int res = Integer.MAX_VALUE;
            int A = Integer.parseInt(arr[i][0]);
            int B = Integer.parseInt(arr[i][1]);
            int C = Integer.parseInt(arr[i][2]);
            // 只有一位，乘数和积都是一位的情况，如果另一位不是1位，则可以变成0*123=0，是2
            if (n3 == 1 && (n1 == 1 || n2 == 1)) {
                if ((n1 == 1 && n2 != 1) || (n1 != 1 && n2 == 1)) {
                    list.add(2);
                    continue;
                }
            }
            // 位数超出限制，是-1
            if (n3 < n1 + n2 - 1 || n3 > n1 + n2) {
                list.add(-1);
                continue;
            }
            int t1 = (int) Math.pow(10, n1);
            int t2 = (int) Math.pow(10, n2);
            // 遍历该位数最小值到最大值，如3位数从100到999
            for (int j = (int) Math.pow(10, n1 - 1); j < t1; j++) {
                for (int k = (int) Math.pow(10, n2 - 1); k < t2; k++) {
                    int p = j * k;
                    if (help1(p) == n3) {
                        res = Math.min(res, help2(A, j) + help2(B, k) + help2(C, p));
                    }
                }
            }
            list.add(res);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }
    public static int help1(int x) {
        int r = 0;
        while(x != 0) {
            r++;
            x /= 10;
        }
        return r;
    }
    public static int help2(int A, int B) {
        int r = 0;
        String a = String.valueOf(A);
        String b = String.valueOf(B);
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                r++;
            }
        }
        return r;
    }
}
