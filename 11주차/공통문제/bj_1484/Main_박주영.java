package day0330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_박주영 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        long now = 1;
        long pre = 1;
        ArrayList<Long> res = new ArrayList<>();
        while(now<=50001){
            if(now*now - pre*pre == G){
                res.add(now);
            }
            if(now*now - pre*pre <= G){
                now++;
            }
            else if(now*now - pre*pre > G){
                pre++;
            }
        }
        if(res.size()==0){
            System.out.println(-1);
            return;
        }

        Collections.sort(res);
        for(int i =  0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
