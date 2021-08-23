import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16432 {
    static int N;
    static ArrayList<Integer>[] riceCake;
    static boolean[][] v;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        riceCake = new ArrayList[N];
        v = new boolean[N][10];
        res = new int[N];
        StringTokenizer st = null;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            riceCake[i] = new ArrayList<>();
            for(int j = 0; j<num; j++){
                riceCake[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        find(0, -1);
        System.out.println("-1");
    }

    private static void find(int cnt, int prev) {
        if(cnt == N){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<N; i++){
                sb.append(res[i]+"\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
            return;
        }

        for(int i = 0; i<10; i++){
            if(prev != -1 && i==prev)continue;
            if(v[cnt][i])continue;
            if(riceCake[cnt].contains(i)){
                v[cnt][i] = true;
                res[cnt] = i;
                find(cnt+1, i);
            }
        }
    }
}
