package SpaceHeaterProblem;

import java.util.Arrays;
import java.util.Scanner;

public class SpaceHeaterProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("houses = ");
        String[] housesScan;
        housesScan = scan.nextLine().split(" ");
        int houses[] = new int[housesScan.length];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.valueOf(housesScan[i]);
        }

        System.out.print("heaters = ");
        String[] heatersScan;
        heatersScan = scan.nextLine().split(" ");
        int heaters[] = new int[heatersScan.length];
        for (int i = 0; i < heaters.length; i++) {
            heaters[i] = Integer.valueOf(heatersScan[i]);
        }

        System.out.println(spaceHeaterProblem(houses,heaters));
    }
    public static int spaceHeaterProblem(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int edge = 0;
        if(houses[0] < heaters[0])  edge = heaters[0]-houses[0];
        if(houses[houses.length-1] > heaters[heaters.length-1]) edge = Math.max(edge, houses[houses.length-1]-heaters[heaters.length-1]);
        int left = 0, right = 0, index_heater = 0;
        int max = 0;
        while(index_heater < heaters.length-1){
            while(left < houses.length && houses[left] < heaters[index_heater]) {
                ++left;
            }
            right = left;
            while(right < houses.length && houses[right] < heaters[index_heater+1]) {
                ++right;
            }
            int temp_max = 0;
            for(int i = left; i < right; ++i){
                temp_max = Math.max(temp_max, Math.min(heaters[index_heater+1]-houses[i], houses[i]-heaters[index_heater]));
                if(temp_max > max)  max = temp_max;
            }
            ++index_heater;
        }
        return Math.max(max, edge);
    }
}
