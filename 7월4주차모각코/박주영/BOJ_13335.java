import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {
    static int n, w, L, sum = 0, cnt = 0;
    static int[] trucks;
    static Queue<Integer> bridge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        trucks = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++){
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        bridge = new LinkedList<>();
        bridge.offer(trucks[0]);
        sum+=trucks[0];
        cnt++;

        int tc = 1;//trucks 다 돌때까지
        while(tc<n){
            if(bridge.size()==w && !bridge.isEmpty()) {
                sum-=bridge.poll();
            }

            if(sum+trucks[tc]<=L){
                bridge.offer(trucks[tc]);
                sum+=trucks[tc];
                tc++;
            }
            else{
                bridge.offer(0);
            }
            cnt++;
        }
        cnt+=w; //마지막 트럭이 다리에 들어감 + 다리길이
        System.out.println(cnt);
    }
}
