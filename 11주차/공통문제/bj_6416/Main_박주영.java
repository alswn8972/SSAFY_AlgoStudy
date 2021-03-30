package day0330;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main_박주영 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        int i = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        a:while (true) {
            boolean end = false;
            while (true) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                if (from == 0 && to == 0) {
                    end = true;
                    break;
                }
                if (from == -1 && to == -1) {
                    break a;
                }

                if (!map.containsKey(from)) {
                    map.put(from, 0);
                }
                if (!map.containsKey(to)) {
                    map.put(to, 1);
                } else {
                    map.put(to, map.get(to) + 1);
                }

            }


            int cnt0 = 0, cnt1 = 0;
            boolean flag = true;
            for (Integer key : map.keySet()) {
                if (map.get(key) == 0) {
                    cnt0++;
                    continue;
                }

                if (map.get(key) == 1) cnt1++;
                else { // map.get(key) > 1
                    flag = false;
                    break;
                }
            }

            if(map.size()==0){
                sb.append("Case ").append(i).append(" is a tree.\n");
            }
            else if (cnt0 == 1 && flag && cnt0 + cnt1 == map.size())
                sb.append("Case ").append(i).append(" is a tree.\n");
            else
                sb.append("Case ").append(i).append(" is not a tree.\n");

            map.clear();
            i++;
        }
        System.out.println(sb.toString());
    }
}
