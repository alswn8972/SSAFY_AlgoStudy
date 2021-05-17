import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
    static int N, M, max;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                for(int k = 0; k<19; k++) {
                    int tmp = checkSum(i, j, k);
                    if (max < tmp) {
                        max = tmp;
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static int checkSum(int i, int j, int k) {
        int res = -1;
        int sum = 0;
        switch(k){
            case 0:
                if(j+3>=M)break;
                for(int d = 0; d<4; d++){
                    sum += map[i][j+d];
                }
                break;
            case 1:
                if(i+3>=N)break;
                for(int d = 0; d<4; d++){
                    sum += map[i+d][j];
                }
                break;
            case 2:
                if(i+1>=N || j+1>=M)break;
                sum = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
                break;
            case 3:
                if(i+2>=N)break;
                if(j+1>=M)break;
                for(int d = 0; d<3; d++){
                    sum += map[i+d][j];
                }
                sum += map[i+2][j+1];
                break;
            case 4:
                if(i+2>=N)break;
                if(j+1>=M)break;
                for(int d = 0; d<3; d++){
                    sum += map[i+d][j];
                }
                sum += map[i][j+1];
                break;
            case 5:
                if(i+2>=N)break;
                if(j-1<0)break;
                for(int d = 0; d<3; d++){
                    sum += map[i+d][j];
                }
                sum += map[i+2][j-1];
                break;
            case 6:
                if(i+2>=N)break;
                if(j-1<0)break;
                for(int d = 0; d<3; d++){
                    sum += map[i+d][j];
                }
                sum += map[i][j-1];
                break;
            case 7:
                if(j+2>=M)break;
                if(i-1<0)break;
                for(int d = 0; d<3; d++){
                    sum += map[i][j+d];
                }
                sum += map[i-1][j];
                break;
            case 8:
                if(j+2>=M)break;
                if(i-1<0)break;
                for(int d = 0; d<3; d++){
                    sum += map[i][j+d];
                }
                sum += map[i-1][j+2];
                break;
            case 9:
                if(j+2>=M)break;
                if(i+1>=N)break;
                for(int d = 0; d<3; d++){
                    sum += map[i][j+d];
                }
                sum += map[i+1][j];
                break;
            case 10:
                if(j+2>=M)break;
                if(i+1>=N)break;
                for(int d = 0; d<3; d++){
                    sum += map[i][j+d];
                }
                sum += map[i+1][j+2];
                break;
            case 11:
                if(i+2>=N)break;
                if(j+1>=M)break;
                sum += map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1];
                break;
            case 12:
                if(i+2>=N)break;
                if(j-1<0)break;
                sum += map[i][j]+map[i+1][j]+map[i+1][j-1]+map[i+2][j-1];
                break;
            case 13:
                if(i+1>=N)break;
                if(j+2>=M)break;
                sum += map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+1][j+2];
                break;
            case 14:
                if(i+1>=N)break;
                if(j-2<0)break;
                sum += map[i][j]+map[i][j-1]+map[i+1][j-1]+map[i+1][j-2];
                break;
            case 15:
                if(i+1>=N)break;
                if(j-1<0 || j+1>=M)break;
                sum += map[i][j]+map[i+1][j-1]+map[i+1][j]+map[i+1][j+1];
                break;
            case 16:
                if(i+1>=N)break;
                if(j+2>=M)break;
                for(int d = 0; d<3; d++){
                    sum += map[i][j+d];
                }
                sum += map[i+1][j+1];
                break;
            case 17:
                if(i+2>=N)break;
                if(j-1<0)break;
                for(int d = 0; d<3; d++){
                    sum += map[i+d][j];
                }
                sum += map[i+1][j-1];
                break;
            case 18:
                if(i+2>=N)break;
                if(j+1>=M)break;
                for(int d = 0; d<3; d++){
                    sum += map[i+d][j];
                }
                sum += map[i+1][j+1];
                break;
        }
        return sum;
    }

}
