import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6068 {
    static class Node implements Comparable<Node>{
        int total,end;

        public Node(int t, int s) {
            this.total = t;
            this.end = s;
        }

        @Override
        public int compareTo(Node o) {
            return -(this.end-o.end);
        }
    }
    static PriorityQueue<Node> todos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        todos = new PriorityQueue<>();
        StringTokenizer st = null;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            todos.add(new Node(t,s));
        }

        Node first = todos.poll();
        int start = first.end - first.total;
        while(!todos.isEmpty()){
            Node cur = todos.poll();
            if(start<cur.end){
                start -= cur.total;
            }else{
                start = cur.end - cur.total;
            }
            if(start<0){
                start = -1;
                break;
            }
        }
        System.out.println(start);
    }
}
