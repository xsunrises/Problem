package VerticalPrintProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VerticalPrintProblem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("s = ");
        String s = scan.nextLine();
        System.out.println(xxx(s));
    }

    public static List<String> xxx(String s) {
        List<String> list = new ArrayList<>();
        String[] str = s.split(" ");
        int len = str.length;
        int maxLen = 0;
        for(int i = 0 ; i < len ; i ++){
            maxLen = Math.max(maxLen,str[i].length());
        }
        for(int i = 0 ; i < maxLen ; i ++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < len ; j ++){
                if(str[j].length() > i){
                    sb.append(str[j].charAt(i));
                }else {
                    sb.append(" ");
                }
            }
            //去除空格
            list.add(sb.toString().replaceFirst("\\s++$", ""));
        }
        return list;
    }
}
