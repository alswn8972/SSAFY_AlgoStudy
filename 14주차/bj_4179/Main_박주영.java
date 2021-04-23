import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_박주영 {
    static class Pos{
        int x, y;
        int time;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int R, C;
    static char[][] map;
    static ArrayList<Pos> fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fire = new ArrayList<>();
        Pos jihun = null;
        for(int i = 0; i<R; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j<C; j++){
                if(map[i][j]=='.'||map[i][j]=='#')continue;
                else if(map[i][j] == 'J'){
                    jihun = new Pos(i,j,0);
                }
                else if(map[i][j] == 'F'){
                    fire.add(new Pos(i,j));
                }
            }
        }

        int res = bfs(jihun);
        System.out.println(res==-1?"IMPOSSIBLE":res);
    }

    private static int bfs(Pos jihun) {
        Queue<Pos> q = new LinkedList<>();
        Queue<Pos> domang = new LinkedList<>();
        for(Pos p: fire){
            q.add(p);
        }
        domang.add(jihun);
        while (!domang.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pos cur = q.poll();
                for(int d=0; d<4; d++){
                    int ni = cur.x+dx[d];
                    int nj = cur.y+dy[d];
                    if(ni>=0 && ni<R && nj>=0 && nj<C && (map[ni][nj]=='.'||map[ni][nj]=='J')){
                        map[ni][nj] = 'F';
                        q.add(new Pos(ni, nj));
                    }
                }
            }
            size = domang.size();
            while (size-->0){
                Pos cur = domang.poll();
                if(cur.x==0 || cur.y==0 || cur.x==R-1 || cur.y==C-1){
                    return cur.time+1;
                }
                for(int d=0; d<4; d++){
                    int ni = cur.x+dx[d];
                    int nj = cur.y+dy[d];
                    if(ni>=0 && ni<R && nj>=0 && nj<C && map[ni][nj]=='.'){
                        map[ni][nj] = 'J';
                        domang.add(new Pos(ni, nj, cur.time+1));
                    }
                }
            }
        }
        return -1;
    }
}
