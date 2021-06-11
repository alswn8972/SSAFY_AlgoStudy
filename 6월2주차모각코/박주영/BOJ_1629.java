import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(sol(A,B,C));
    }

    private static long sol(long a, long b, long c) {
        if(b==1)return a%c;

        long tmp = sol(a,b / 2, c);

        if(b%2==1)
//            return (a*tmp*tmp)%c; // 모듈러 합동 공식 (a*b)%c = (a%c * b%c)%c
//            return ((a%c)*(tmp*tmp%c))%c;
//            return ((a%c)*((tmp*tmp%c)%c))%c;
            return (tmp*tmp%c)*a%c;
        return tmp*tmp%c;
    }
}
