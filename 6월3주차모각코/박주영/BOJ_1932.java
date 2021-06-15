import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    static int max = -1, n;
    static int[][] input, memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new int[n][n];
        memo = new int[n][n];
        StringTokenizer st = null;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<=i; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        memo[0][0] = input[0][0];
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=i; j++){
                if(j == 0)
                    memo[i][j] = memo[i-1][j] + input[i][j];
                else if(j == i)
                    memo[i][j] = memo[i-1][j-1] + input[i][j];
                else
                    memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j]) + input[i][j];
            }
        }
        for(int i = 0; i<n; i++){
            max = Math.max(memo[n-1][i], max);
        }
        System.out.println(max);
    }
}
