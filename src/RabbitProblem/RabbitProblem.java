package RabbitProblem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class RabbitProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("answer = ");
        String[] scanner;
        scanner = scan.nextLine().split(" ");
        int rabbit[] = new int[scanner.length];
        for (int i = 0; i < rabbit.length; i++) {
            rabbit[i] = Integer.valueOf(scanner[i]);
        }

        System.out.println(rabbit(rabbit));
    }
    /**
     * 出现了一个bug 待后续解决
     */
    public static int rabbit(int[] rabbits) {
        int[] count = new int[rabbits.length];
        int res = 0;
        //数量
        for (int rabbit : rabbits) {
            if (count[rabbit] == 0) {
                //此种颜色没有出现过,计算剩下的数量,加入到总数中
                count[rabbit] = rabbit;
                res += rabbit + 1;
            } else {
                //在已经出现的颜色数量减去一
                count[rabbit]--;
                //小于负数则此种颜色的所有兔子已经出现，是新的颜色
                if (count[rabbit] < 0) {
                    res += rabbit + 1;
                    //加入到总数中将其置为新的颜色剩余量
                    count[rabbit] = rabbit;
                }
            }
        }
        return res;
    }
}
