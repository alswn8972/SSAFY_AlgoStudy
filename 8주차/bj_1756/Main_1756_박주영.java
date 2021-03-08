import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1756_박주영 {
    static int d, n, top;
    static int oven[], pizza[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        oven = new int[d];
        pizza = new int[n];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<d; i++){
            oven[i] = Integer.parseInt(st.nextToken());
        }

        // 오븐 지름 재설정
        int pre = oven[0];
        for(int i = 1; i<d; i++){
            if(oven[i]>pre){
                oven[i] = pre;
            }
            pre = oven[i];
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<n; i++){
            pizza[i] = Integer.parseInt(st.nextToken());
        }

        top = d;
        for(int i = 0; i<n; i++) {
            sol(0,top-1, pizza[i]);
        }
        System.out.println(top+1);
    }

    private static void sol(int start, int end, int target) {
        int tmp = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(oven[mid]>=target){
                tmp = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        top = tmp;
    }
}
