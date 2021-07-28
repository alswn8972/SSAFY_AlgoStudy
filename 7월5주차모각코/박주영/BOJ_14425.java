import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425 {
    static int N, M, cnt=0;
    static HashSet<String> S = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            S.add(br.readLine());
        }
        for(int i = 0; i<M; i++){
            String input = br.readLine();
            if(S.contains(input)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}