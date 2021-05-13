package tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[L+1];
        for(int i = 1; i<=L; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long answer = Integer.MIN_VALUE;
        int idx = -1;
        for(int d = 1; d<=L; d++){
            long sum = 0;
            for(int i = d; i<=L; i += d){
                sum += arr[i];
            }
            if(answer<sum){
                answer = sum;
                idx = d;
            }
        }
        if(answer <= 0){
            System.out.println("0 0");
            return;
        }
        System.out.println(idx+" "+answer);
    }
}
