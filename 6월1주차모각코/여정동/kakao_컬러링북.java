import java.util.*;

class kakao_컬러링북 {
    
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] iv;
    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;
    static int M, N;
    static int[][] map;
    
    public int dfs(int y, int x, int value){
        iv[y][x] = true;
        int count = 1;
        for(int d = 0; d < 4; d++) {
            int ny = dy[d] + y;
            int nx = dx[d] + x;
            if(ny < M && nx < N && ny > -1 && nx > -1 && !iv[ny][nx] && map[ny][nx] == value){
                count += dfs(ny, nx, value);
            }
        }
        return count;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        M = m;
        N = n;
        map = picture;
        
        iv = new boolean[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(!iv[i][j] && picture[i][j] > 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(dfs(i, j, picture[i][j]), maxSizeOfOneArea);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
