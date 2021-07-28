import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19699 {
    static int N, M, cows[];
    static HashSet<Integer> primes = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        cows = new int[N];
        for(int i = 0; i<N; i++){
            cows[i] = Integer.parseInt(st.nextToken());
        }

        combi(0,0,0);

        if(primes.size()==0){
            System.out.println(-1);
            return;
        }

        List<Integer> sorted = new ArrayList<>(primes);
        Collections.sort(sorted);
        for(int num: sorted){
            System.out.print(num+" ");
        }
    }

    private static void combi(int start, int cnt, int sum) {
        if(cnt == M){
            if(isPrime(sum)){
                primes.add(sum);
            }
            return;
        }
        for(int i = start; i<N; i++){
            combi(i+1, cnt+1, sum + cows[i]);
        }
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i<num; i++){
            if(num%i == 0)return false;
        }
        return true;
    }
}
