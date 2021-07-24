import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18513 {
    static int N, K;
    static ArrayList<Integer> sams = new ArrayList<>();
    static HashSet<Integer> v = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N; i++){
            int dir = Integer.parseInt(st.nextToken());
            sams.add(dir);
            v.add(dir); //샘 - 방문체크로 남겨놓기
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<sams.size(); i++){
            q.offer(sams.get(i));
        }
        long answer = 0; // 불행도 합
        long gap = 1;
        a:while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                 int cur = q.poll();

                 int r = cur+1;
                 int l = cur-1;
                 if(!v.contains(r)){
                     v.add(r);
                     q.offer(r);
                     answer+=gap;
                     if(--K == 0)break  a;
                 }
                 if(!v.contains(l)){
                     v.add(l);
                     q.offer(l);
                     answer+=gap;
                     if(--K == 0)break  a;
                 }
            }
            gap++;
        }

        System.out.println(answer);
    }
}
