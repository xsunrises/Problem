package GasStationProblem;

import java.util.Scanner;

public class GasStationProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("gas = ");
        String[] scanner;
        scanner = scan.nextLine().split(" ");
        int gas[] = new int[scanner.length];
        for (int i = 0; i < gas.length; i++) {
            gas[i] = Integer.valueOf(scanner[i]);
        }

        System.out.print("cost = ");
        String[] scanners;
        scanners = scan.nextLine().split(" ");
        int cost[] = new int[scanners.length];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.valueOf(scanners[i]);
        }
        System.out.println(num(gas, cost));

    }

    public static int num(int[] gas, int[] cost) {
        //总油量
        int sum = 0;
        for(int i = 0;i < gas.length;i++){
            sum = gas[i] - cost[i] +sum;
        }
        //总油量转不完一圈返回-1
        if(sum < 0){
            return -1;
        }
        //剩余油量
        int gass = 0;
        //站点
        int station = 0;

        for(int i = 0;i < gas.length;i++){
            gass = gas[i] - cost[i] + gass;
            //到达下一个站点没油了，就从下一个站点重新计算
            if(gass < 0){
                gass = 0;
                station = i + 1;
            }
        }
        return station;
    }
}
