import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_n진수게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        System.out.println(solution(n,m,t,p));
    }

    private static String solution(int n, int m, int t, int p) {
        StringBuilder answer =new StringBuilder();
        StringBuilder all=new StringBuilder();
        int num=0;
        while(all.length()<m*t){
            all.append(Integer.toString(num, n));
            num++;
        }
        for(int i = p-1; i<m*t; i+=m){
            answer.append(all.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}
