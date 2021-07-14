import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429 {
    static int N,K,answer;
    static int[] w;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        w = new int[N];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++){
            w[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        permu(0, 500);
        System.out.println(answer);
    }

    private static void permu(int cnt, int num) {
        if(cnt == N){
            answer++;
            return;
        }
        for(int i = 0; i<N; i++){
            if(v[i])continue;

            v[i] = true;
            if(num-K+w[i]>=500)
                permu(cnt+1, num-K+w[i]);
            v[i] = false;
        }
    }
}
