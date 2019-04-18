package testDay1;
import java.util.Scanner;
public class helloworld {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入数字，选择要执行的操作");
        System.out.println("1--继续下一关");
        System.out.println("2--重玩该关卡");
        System.out.println("0--退出");
        int n=sc.nextInt();
        while (n!=1){
            if (n==2){
                System.out.println("继续本关卡！");
                n=sc.nextInt();
            }
            if (n==0){
                System.out.println("退出！");
                n=sc.nextInt();
            }
        }
        System.out.println("下一关开始啦！");


        }
    }
