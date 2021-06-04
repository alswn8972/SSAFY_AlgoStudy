import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1170 {
    static boolean button[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int b = Integer.parseInt(br.readLine());
        button = new boolean[10];
        for(int i = 0; i<10; i++)button[i] = true;

        if(b!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < b; i++) {
                String tmp = st.nextToken();
                button[Integer.parseInt(tmp)] = false;
            }
        }

        // + || - 만으로 가는 경우
        int res = Math.abs(n-100);

        // 가까운 번호로 이동후 + || -
        for(int i = 0; i<1000000; i++){
            int click = clickCount(i);
            if(click>0){
                int total = click + Math.abs(n-i);
                res = Math.min(total,res);
            }
        }
        System.out.println(res);
    }

    private static int clickCount(int num) {
        int res = 0;
        if(num == 0){
            if(!button[0]) return 0;
            else return 1;
        }

        while(num>0){
            if(!button[num%10])return 0;
            res++;
            num /= 10;
        }
        return res;
    }
}
