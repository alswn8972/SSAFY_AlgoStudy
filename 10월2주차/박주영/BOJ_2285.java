import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2285 {
    static class Node implements Comparable<Node>{
        long x, a;

        public Node(long x, long a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Node o) {
            int res = (int)(this.x-o.x);
            return res == 0 ? (int)(this.a-o.a) : res;
        }
    }
    static Node[] positions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        positions = new Node[n];
        long mid = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");

            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            positions[i] = new Node(x,a);
            mid += a;
        }
        mid = (mid+1)/2;
        Arrays.sort(positions);

        long sum = 0;
        for(Node node: positions){
            sum += node.a;
            if(sum>=mid){
                System.out.println(node.x);
                break;
            }
        }
    }
}
