import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20168 {
    static int N, M, A, B, C;
    static Map<Integer, Integer>[] maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maps = new Map[N+1];
        for(int i = 1; i<N+1; i++){
            maps[i] = new HashMap<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            maps[from].put(to, val);
            maps[to].put(from, val);
        }

        for(int key: maps[A].keySet()){
            boolean[] visit = new boolean[11];
            visit[A] = true;
            visit[key] = true;
            sol(key, maps[A].get(key), 0, visit, 0);
        }

        if(maxMin.size() == 0) System.out.println(-1);
        else System.out.println(maxMin.poll());
    }
    static PriorityQueue<Integer> maxMin = new PriorityQueue<>();
    private static void sol(int v, Integer val, int sum, boolean[] visit, int max) {
        if(sum+val>C) {
            return;
        }
        if(max<val)max = val;
        if(v == B){
            maxMin.add(max);
            return;
        }
        for(int key : maps[v].keySet()){
            if(visit[key])continue;
            visit[key] = true;
            sol(key, maps[v].get(key), sum+val, visit, max);
            visit[key] = false;
        }
    }
}
