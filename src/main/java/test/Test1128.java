package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test1128 {
    static Set set = new HashSet();
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=1; i<10; i++) {
            for(int j=0; j<10; j++) {
                dfs(i, j, 0);
            }
        }

        System.out.println(set.size()-1);
    }

    public static void dfs(int i, int j, int num) {
        set.add(num);
        int x = i + num*10;
        int y = j + num*10;
        if(x<=n && x!=0){
            dfs(i, j, x);
        }
        if(y<=n && y!=0){
            dfs(i, j, y);
        }
    }
}
