package FruitProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 购买水果最便宜方案问题
 */
public class Demo {
    static Scanner in = new Scanner(System.in);
    //输入总小时数
    static int n = in.nextInt();
    //输入水果超市个数
    static int m = in.nextInt();

    //new一个m行3列的数组，第12列代表小时，第3列代表价格
    static int[][] arr = new int[m][3];

    public static void main(String[] args) {
        input();
        //Order_1();
        Order_2();
        Traverse();
    }
    public  static void input() {
        //输入X[0]x[1]x[2]—第2~m+1行
        for (int i = 0; i < m; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
            arr[i][2] = in.nextInt();
        }
    }
    public static void Order_1() {
        // lambda表达式,按价格(arr[i][2])从小到大排列(比较器排序)
        Arrays.sort(arr, (a, b) -> (a[2] - b[2]));
    }

    public static void Order_2() {
        //使用匿名内部类实现comparator接口
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[2]-a2[2];
            }
        });
    }

    public static void Traverse() {
        int res = 0;
        //外层遍历小时数
        for (int i = 1; i <= n; i++) {
            //内层遍历超市数
            for (int j = 0; j < m; j++) {
                //如果小时数在arr[j][0]到arr[j][1]之间，取arr[j][2]加等，跳出j循环（已经找到第i小时的最便宜水果了）
                if (arr[j][0] <= i && arr[j][1] >= i) {
                    res += arr[j][2];
                    System.out.println("第" + i + "小时选" + arr[j][2] + "元水果；");
                    break;
                }
            }
        }
        System.out.println("共" + res + "元。");
    }
}
