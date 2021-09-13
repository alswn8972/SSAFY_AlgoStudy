import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12782 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            char[] n = st.nextToken().toCharArray();
            char[] m = st.nextToken().toCharArray();
            int cnt0=0;
            int cnt1=0;
            for(int i = 0; i<n.length; i++){
                if(n[i]==m[i])continue;
                if(n[i] == '0')cnt0++;
                else cnt1++;
            }
            sb.append(cnt0>cnt1?cnt0:cnt1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
