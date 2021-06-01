import java.util.*;

class kakao_합승요금 {
    static int[][] map;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // n : 지점갯수, s : 시작지점 fares
        map = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(map[i],999999);   
            map[i][i] = 0;
        }
        
        for(int i = 0; i < fares.length; i++){
            map[fares[i][0]][fares[i][1]] = fares[i][2];
            map[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                if(k==i) continue;
                for(int j = 1; j <= n; j++){
                    if(k==j||i==j) continue;
                    if(map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
        
        int answer = map[s][a] + map[s][b];
        
        for(int i = 1; i <= n; i++){
            if(i == s) continue;
            int sh = map[s][i];
            int op = 0;
            if(i == a){
                op = sh + map[i][b];
            }
            else if(i == b){
                op = sh + map[i][a]; 
            }
            else{
                op = sh + map[i][a] + map[i][b];
            }
            answer = Math.min(answer, op);
        }
        return answer;
    }
}
