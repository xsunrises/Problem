package UppercaseProblem;

import java.util.Scanner;

public class UppercaseProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("title = ");
        String title = scan.nextLine();

        String s = xxx(title);

        System.out.println(s);
    }

    public static String xxx(String title) {
        StringBuilder sb=new StringBuilder();
        //将title根据空格分割成数组
        String [] arr=title.split(" ");
        //遍历数组，字符串长度大于2的就将第一个字母截取出来变成大写，后面的变成小写，<=2就全部小写
        for(String temp:arr){
            if(temp.length()<=2){
                sb.append(temp.toLowerCase());
            }else{
                sb.append(temp.substring(0,1).toUpperCase());
                sb.append(temp.substring(1).toLowerCase());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
