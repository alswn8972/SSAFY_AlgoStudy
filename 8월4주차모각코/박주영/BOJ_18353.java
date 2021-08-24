import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n+1];
        arr[0] = 10000001;
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];

        for(int i = 1; i<=n; i++){
            for(int j = 0; j<i; j++){
                if(arr[j]>arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(n - dp[n]);
    }
}
