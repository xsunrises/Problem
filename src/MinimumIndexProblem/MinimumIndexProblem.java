package MinimumIndexProblem;

import java.util.Scanner;

public class MinimumIndexProblem {
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

    public static int xxx(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
