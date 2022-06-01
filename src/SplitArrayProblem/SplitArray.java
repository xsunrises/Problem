package SplitArrayProblem;

import java.util.Scanner;

public class SplitArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("nums = ");
        String[] scanner;
        scanner = scan.nextLine().split(",");
        int nums[] = new int[scanner.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(scanner[i]);
        }

        int xxx = xxx(nums);
        System.out.println(xxx);
    }

    public static int xxx(int[] nums) {
        int x = nums.length;
        int[] min = new int[x];
        int[] max = new int[x];
        max[0] = nums[0];
        min[x - 1] = nums[x - 1];
        for (int i = 1; i < x; i++) {
            max[i] = Math.max(max[i - 1], nums[i - 1]);
            min[x - i - 1] = Math.min(min[x - i], nums[x - i]);
        }
        for (int i = 1; i < x; i++) {
            //左侧最大小于右侧最小
            if (max[i] <= min[i - 1]) {
                return i;
            }
        }
        return -1;
    }


}
