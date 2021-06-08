import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int origin = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            Queue<Oper> q = new LinkedList<>();
            q.offer(new Oper(origin,""));
            String res = "";
            boolean[] visited = new boolean[10001];
            visited[origin] = true;
            while(!q.isEmpty()){
                Oper cur = q.poll();
                if(cur.num == target){
                    res = cur.oper;
                    break;
                }
                int d = doD(cur.num);
                int s = doS(cur.num);
                int l = doL(cur.num);
                int r = doR(cur.num);
                if(!visited[d]) {
                    q.offer(new Oper(d, cur.oper + "D"));
                    visited[d] = true;
                }
                if(!visited[s]) {
                    q.offer(new Oper(s, cur.oper + "S"));
                    visited[s] = true;
                }
                if(!visited[l]) {
                    q.offer(new Oper(l, cur.oper + "L"));
                    visited[l] = true;
                }
                if(!visited[r]) {
                    q.offer(new Oper(r, cur.oper + "R"));
                    visited[r] = true;
                }

            }
            System.out.println(res);
        }
    }

    static class Oper{
        int num;
        String oper;

        public Oper(int num, String oper) {
            this.num = num;
            this.oper = oper;
        }
    }

    private static int doR(int cur) {
        return cur/10+((cur%10)*1000);
    }

    private static int doL(int cur) {
        return (cur%1000)*10 + cur/1000;
    }

    private static int doS(int cur) {
        if(cur == 0) return 9999;
        return cur-1;
    }

    private static int doD(int cur) {
        return (cur*2)%10000;
    }
}
