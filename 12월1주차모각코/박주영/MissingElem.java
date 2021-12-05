import java.util.*;

class MissingElem {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int res = 0;
        Arrays.sort(A);
        int max = A.length+2;
        boolean[] check = new boolean[max];
        for(int i: A){
            check[i] = true;
        }
        for(int i = 1; i<max; i++){
            if(check[i])continue;
            res = i;
            break;
        }

        return res;
    }
}