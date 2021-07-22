import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
    static int R,C,hedgehog[] = new int[2];
    static char map[][];
    static Queue<int[]> waters = new LinkedList<>();
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        v = new boolean[R][C];
        for(int i = 0; i<R; i++){
            char[] rows = br.readLine().toCharArray();
            for(int j = 0; j<C; j++){
                map[i][j] = rows[j];
                if(map[i][j] == 'S'){
                    hedgehog[0] = i;
                    hedgehog[1] = j;
                }
                else if(map[i][j] == '*'){
                    waters.offer(new int[]{i,j});
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{hedgehog[0],hedgehog[1],0}); // 도치
        v[hedgehog[0]][hedgehog[1]] = true;
        int cnt = 0;
        boolean success = false;
        while(!q.isEmpty()){
            // 홍수
            int wSize = waters.size();
            for(int i = 0; i<wSize; i++){
                int[] curWater = waters.poll();
                for(int d = 0; d<4; d++){
                    int ni = curWater[0] + dx[d];
                    int nj = curWater[1] + dy[d];
                    if(ni<0||nj<0||ni>=R||nj>=C||map[ni][nj]=='X'||map[ni][nj]=='D'||map[ni][nj]=='*')continue;
                    map[ni][nj] = '*';
                    waters.offer(new int[]{ni,nj});
                }
            }

            // 도치
            int hSize = q.size();
            for(int i = 0; i<hSize; i++) {
                int[] cur = q.poll();
                if (map[cur[0]][cur[1]] == 'D') {
                    success = true;
                    cnt = cur[2];
                    break;
                }
                for (int d = 0; d < 4; d++) {
                    int ni = cur[0] + dx[d];
                    int nj = cur[1] + dy[d];
                    if (ni < 0 || nj < 0 || ni >= R || nj >= C || map[ni][nj] == 'X' || map[ni][nj] == '*' || v[ni][nj])
                        continue;
                    v[ni][nj] = true;
                    q.offer(new int[]{ni, nj, cur[2]+1});
                }
            }
        }

        if(success)
            System.out.println(cnt);
        else
            System.out.println("KAKTUS");
    }
}
