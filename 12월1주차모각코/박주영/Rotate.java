public class Rotate {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int[] cnt = new int[1000000001];

        int max = -1;
        for(int i = 0; i<A.length; i++){
            cnt[A[i]]++;
            if(max<A[i])
                max = A[i];
        }

        int res = -1;
        for(int i = 0; i<max+1; i++){
            if(cnt[i]%2 == 0) continue;
            res = i;
            break;
        }
        return res;
    }
}