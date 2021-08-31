import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p_프렌즈4블록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] board = new String[n];
        for(int i = 0; i<m; i++){
            board[i] = br.readLine();
        }

        solution(m,n,board);
    }

    static char[][] map;
    public static int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for(int i = 0; i<m; i++){
            map[i] = board[i].toCharArray();
        }

        int answer = 0;
        while(true){
            // 더이상 사라질 블럭 없을때까지 반복
            int cnt = remove(m,n);
            if(cnt == 0)break;
            answer+=cnt;
            drop(m,n);
        }
        return answer;
    }

    private static void drop(int m, int n) {
        for(int j = 0; j<n; j++){
            for(int i = m-1; i>=0; i--){
                if(map[i][j]!='.')continue;
                for(int k = i-1; k>=0; k--){
                    if(map[k][j]=='.')continue;
                    map[i][j] = map[k][j];
                    map[k][j] = '.';
                    break;
                }
            }
        }
    }

    private static int remove(int m, int n) {
        int cnt = 0;
        boolean[][] v = new boolean[m][n];

        //4개씩 묶음있는 거 체크
        for(int i = 0; i<m-1; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == '.')continue;
                check(m,n,i,j,v);
            }
        }

        //체크된 것들 제거
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!v[i][j])continue;
                map[i][j] = '.';
                cnt++;
            }
        }

        //제거된 블럭 개수 리턴
        return cnt;
    }

    private static void check(int m, int n, int r, int c, boolean[][] v) {
        char cur = map[r][c];
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                if(r+i<0||c+j<0||r+i>=m||c+j>=n)return;
                if(map[r+i][c+j]!=cur)return;
            }
        }
        for(int i = 0; i<2; i++){
            for(int j = 0; j<2; j++){
                v[r+i][c+j]=true;
            }
        }
    }
}
