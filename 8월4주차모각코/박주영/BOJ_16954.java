import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16954 {
    static char[][] map = new char[8][8];
    static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
    static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    static class Node{
        int r,c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static Queue<Node> walls = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<8; i++){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j<8; j++){
                map[i][j] = tmp[j];
                if(map[i][j] == '#') walls.add(new Node(i,j));
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(7,0));

        int ans = 0;
        a: while(true) {
            while(!q.isEmpty()) {
                Node cur = q.poll();
                if(cur.r == 0 && cur.c == 7){
                    ans = 1;
                    break a;
                }
                if(map[cur.r][cur.c]=='#')continue;
                for(int d = 0; d<9; d++){
                    int nr = cur.r+dx[d];
                    int nc = cur.c+dy[d];
                    if(nr<0||nc<0||nr>=8||nc>=8)continue;
                    if(map[nr][nc] == '.')
                        map[nr][nc] = 'W';
                }
            }

            // 벽
            if(walls.size() == 0){
                ans = 1;
                break;
            }

            // 벽 내리기
            int wsize = walls.size();
            for(int i = 0; i<wsize; i++){
                Node w = walls.poll();
                if(w.r+1 < 8){
                    map[w.r][w.c] = '.';
                    map[w.r+1][w.c] = '#';
                    walls.add(new Node(w.r+1, w.c));
                }
            }

            // 욱제위치확인
            for(int i = 0; i<8; i++){
                for(int j = 0; j<8; j++){
                    if(map[i][j] == 'W') q.add(new Node(i,j));
                }
            }
            if(q.size()==0)break;
        }
        System.out.println(ans);
    }
}
