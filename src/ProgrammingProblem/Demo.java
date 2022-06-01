package ProgrammingProblem;

import java.util.Scanner;

public class Demo {
    static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //项目个数n
        int n = in.nextInt();
        //三个团队人力总和team[i]
        int[] team = new int[3];
        for (int i = 0; i < 3; i++) {
            team[i] = in.nextInt();
        }
        //每个项目预估价值value[i]
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
        }
        //每个项目所需人力person[i][0]
        int[][] person = new int[n][3];
        for (int i = 0; i < n; i++) {
            person[i][0] = in.nextInt();
            person[i][1] = in.nextInt();
            person[i][2] = in.nextInt();
        }
        Programming(person, team, value, 0, 0);
        System.out.println(res);
    }

    public static void Programming(int[][] person, int[] team, int[] value, int index, int cur){
        int n = person.length;
        // 终止条件
        if (index == n) {
            res = Math.max(res, cur);
            return;
        }
        for (int i = index; i < n; i++) {
            //只有每个团队的人力综合大于每一个项目的人力需求才进行计算
            if (team[0] >= person[i][0] && team[1] >= person[i][1] && team[2] >= person[i][2]) {
                cur += value[i];
                //剩余人力
                team[0] -= person[i][0];
                team[1] -= person[i][1];
                team[2] -= person[i][2];
                Programming(person, team, value, i + 1, cur);
                cur -= value[i];
                team[0] += person[i][0];
                team[1] += person[i][1];
                team[2] += person[i][2];
            }else
                Programming(person, team, value, i + 1, cur);
        }
    }

    public static void xxx() {

    }
}