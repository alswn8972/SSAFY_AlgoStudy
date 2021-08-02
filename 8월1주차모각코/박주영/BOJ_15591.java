import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15591 {
    static int N, Q;
    static List<int[]>[] moo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        moo = new List[N+1];
        for(int i = 1; i<=N; i++){
            moo[i] = new ArrayList<>();
        }
        for(int i = 1; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            moo[p].add(new int[]{q,r});
            moo[q].add(new int[]{p,r});
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<Q; i++){
            st = new StringTokenizer(br.readLine()," ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cnt = sol(k, v);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int sol(int k, int v) {
        int cnt = 0;
        // v 정점부터 시작해서 최소비용>=k 인것들만 추천 cnt++
        Queue<Integer> q = new LinkedList<>(); //정점, 최소비용
        q.add(v);
        boolean[] visited = new boolean[N+1];
        visited[v] = true;
        while (!q.isEmpty()){
            int cur = q.poll();
            for(int[] vertex: moo[cur]){
                if(visited[vertex[0]])continue;
                if(vertex[1]>=k){
                    q.add(vertex[0]);
                    visited[vertex[0]] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
