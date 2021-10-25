import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long left = 0;
        long right = n/2;
        while(left<=right){
            long r = (left+right)/2;
            long c = n-r;

            long val = (r+1)*(c+1);
            if(val == k){
                System.out.println("YES");
                return;
            }
            else if(val<k){
                left = r+1;
            }
            else if(val>k){
                right = r-1;
            }
        }
        System.out.println("NO");
    }
}
