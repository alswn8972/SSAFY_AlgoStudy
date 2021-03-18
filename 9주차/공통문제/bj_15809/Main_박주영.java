import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_박주영 {
    static int N, M;
    static int[][] parents;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void make() throws IOException {
        for(int i = 0; i<N; i++){
            parents[i][0] = i;
            parents[i][1] = Integer.parseInt(br.readLine());
        }
    }
    private static int find(int a){
        if(parents[a][0] == a) return a;
        return parents[a][0] = find(parents[a][0]);
    }
    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b)return false;
        parents[b][0] = a;
        parents[a][1] += parents[b][1];
        return true;
    }
    private static boolean fight(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b)return false;

        if(parents[a][1]>parents[b][1]){
            parents[b][0] = a;
            parents[a][1] = parents[a][1] - parents[b][1];
        }
        else if(parents[a][1]<parents[b][1]){
            parents[a][0] = b;
            parents[b][1] = parents[b][1]-parents[a][1];
        }
        else{
            parents[a][0] = -1;
            parents[b][0] = -1;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N][2];
        make();

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(oper==1){
                union(a,b);
            }
            else if(oper==2){
                fight(a,b);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            if(parents[i][0] == -1 || parents[i][0]!=i)continue;
            list.add(parents[i][1]);
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(list.size());
        System.out.println(sb.toString());

    }
}
