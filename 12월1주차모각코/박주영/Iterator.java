// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

class Iterator {
    public static void main(String[] args) {
        solution(1041);
    }
    public static int solution(int N) {
        // write your code in Java SE 8
        int res = 0;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> indexs = new ArrayList<>();
        int idx = 0;
        while(N!=0){
            int tmp = N%2;
            if(tmp == 1) {
                indexs.add(idx);
            }
            list.add(tmp);
            N /= 2;
            idx++;
        }
        if(indexs.size() <= 1) return res;

        //contain binary gap
        for(int i = 0; i<indexs.size() - 1; i++){
            int tmp = Math.abs(indexs.get(i)-indexs.get(i+1)) - 1;
            res=Math.max(res, tmp);
        }

        return res;
    }
}
