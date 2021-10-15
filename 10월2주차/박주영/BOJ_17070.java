
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070 {
    static int N, cnt;
    static int[][] map;
    static class Node{
        int[] arr;
        boolean v[][];

        public Node(int[] arr, boolean[][] v) {
            this.arr = arr;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i = 1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 1; j<N+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(map[N][N] == 1) {
            System.out.println(0);
            return;
        }

        cnt = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] v = new boolean[N+1][N+1];
        v[1][2] = true;
        q.add(new Node(new int[]{1,2,1}, v));
        while(!q.isEmpty()){
            Node cur = q.poll();
            int r = cur.arr[0], c = cur.arr[1], d = cur.arr[2];
            if(r==N && c==N){
                cnt++;
                continue;
            }
            if(r+1<=N && c+1<=N){
                if(!cur.v[r+1][c+1] && map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0){
                    cur.v[r+1][c+1] = true;
                    q.add(new Node(new int[]{r+1,c+1,0}, cur.v));
                    cur.v[r+1][c+1] = false;
                }
            }
            switch (d){
                case 0:
                    // 대각선
                    if(c+1<=N && !cur.v[r][c+1] && map[r][c+1]==0){
                        cur.v[r][c+1] = true;
                        q.add(new Node(new int[]{r,c+1,1}, cur.v));
                        cur.v[r][c+1] = false;
                    }
                    if(r+1<=N && !cur.v[r+1][c] && map[r+1][c]==0){
                        cur.v[r+1][c] = true;
                        q.add(new Node(new int[]{r+1,c,2}, cur.v));
                        cur.v[r+1][c] = false;
                    }
                    break;
                case 1:
                    // 가로
                    if(c+1<=N && !cur.v[r][c+1] && map[r][c+1]==0){
                        cur.v[r][c+1] = true;
                        q.add(new Node(new int[]{r,c+1,1}, cur.v));
                        cur.v[r][c+1] = false;
                    }
                    break;
                case 2:
                    // 세로
                    if(r+1<=N && !cur.v[r+1][c] && map[r+1][c]==0){
                        cur.v[r+1][c] = true;
                        q.add(new Node(new int[]{r+1,c,2}, cur.v));
                        cur.v[r+1][c] = false;
                    }
                    break;
            }
        }

        System.out.println(cnt);
    }
}