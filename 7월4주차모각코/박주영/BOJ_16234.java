import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234 {
    //https://www.acmicpc.net/problem/16234

    static int N, L, R, map[][];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] v;
    static ArrayList<int[]> unions; // {r, c, sum}


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //더이상 연합 만들 수 없을 때까지 반복
        //map을 다 돌면서 4방 확인
            // -> 연합가능하면 이미 연합인지 체크, sum+=인구, cnt++, 연합 리스트에 추가

        int cnt = 0;
        while(true){
            if(isEnd()) break;

            // 방문 초기화
            v = new boolean[N][N];
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(v[i][j])continue;

                    unions = new ArrayList<>();
                    unions.add(new int[]{i,j,map[i][j]});
                    int usum = dfs(i,j,map[i][j]);
                    // map 재조정
                    for(int[] item: unions){
                        map[item[0]][item[1]] = usum/unions.size();
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static int dfs(int i, int j, int sum) {
        v[i][j] = true;
        sum = map[i][j];
        for(int d = 0; d<4; d++){
            int ni = i+dx[d];
            int nj = j+dy[d];
            if(ni<0||nj<0||ni>=N||nj>=N||v[ni][nj])continue;
            int gap = Math.abs(map[i][j]-map[ni][nj]);
            if(gap>=L && gap<=R) {
                unions.add(new int[]{ni, nj});
                sum += dfs(ni, nj, sum);
            }
        }
        return sum;
    }

    private static boolean isEnd(){
        boolean res = true;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                for(int d = 0; d<4; d++){
                    int ni = i+dx[d];
                    int nj = j+dy[d];
                    if(ni<0||nj<0||ni>=N||nj>=N)continue;

                    int gap = Math.abs(map[i][j]-map[ni][nj]);
                    if(gap>=L && gap<=R) {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
