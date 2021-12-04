import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
    static int K, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while(TC-->0){
            K = Integer.parseInt(br.readLine());
            arr = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

        }
    }
}
